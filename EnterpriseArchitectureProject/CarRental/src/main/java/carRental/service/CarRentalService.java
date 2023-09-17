package carRental.service;

import carRental.Integration.MessageSender;
import carRental.domain.*;
import carRental.exception.PaymentException;
import carRental.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class CarRentalService {
    //@Autowired
    JmsTemplate jmsTemplate  =new JmsTemplate();
    RestTemplate restTemplate =new RestTemplate();
    @Autowired
    PaymentRepository paymentRepository;
@Autowired
    CustomerRepository customerRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    CarRentalRepository carRentalRepository;
    @Autowired
    RentalHistoryRepository rentalHistoryRepository;
    @Autowired
    MessageSender messageSender;

    @Value("${carfleet.url}")
    private String carFleetUrl;
    @Value("${carrental.maxCarsPerCustomer}")
    private String maxCarsPerCustomer;
    @Value("${reward.points}")
    private String rewardPoints;


 private long duration ;
    @Value("${cars.rental.perDay}")
private String price;
    public List<Car> getAllAvailableCars() {
        return carRepository.findByRentedOutFalse();
    }

    public CarRental rentCar(Long  customerId, String carId, LocalDate pickupDate, LocalDate returnDate) throws Exception {
         //check if customer has already rented max number of cars
        Integer maxCarsPerPerson =Integer.parseInt(maxCarsPerCustomer);
        if (carRentalRepository.countByCustomerIdAndReturnDateAfter(customerId,returnDate) >= maxCarsPerPerson) {
            throw new Exception("Customer already has maximum number of rented cars.");
        }


        // check if car is available for rent

        Car car = carRepository.findByIdAndRentedOutFalse(carId); //jira
        if (car  !=null) {
            throw new Exception("Car is not available for rent.");
        }

         //Car carFleet  =

        // look car in mongo db
       // System.out.println("..here..");
         Car carFleet  = restTemplate.getForObject(carFleetUrl+"/cars/{id}", Car.class,carId);
        if(carFleet==null){
            throw new Exception("wrong car id please double check");
        }
         System.out.println("get car " + carFleet);

        // reserve car by sending message to car fleet
         messageSender.send("created");
        jmsTemplate.convertAndSend("carFleet", carId);

        // create rental record in the database and car
        Car newCar = callCar(carId);

        Car savedCar = new Car();
        CarRental rental = new CarRental();
        rental.setCustomerId(customerId);
        rental.setCarId(carId);
        savedCar.setId(newCar.getId());
        savedCar.setMake(newCar.getMake());
        savedCar.setBrand(newCar.getBrand());
        savedCar.setYear(newCar.getYear());
        savedCar.setMiles(newCar.getMiles());
        savedCar.setColor(newCar.getColor());
        savedCar.setReserved(true);
        savedCar.setRentedOut(true);
        rental.setPickupDate(pickupDate);
        rental.setReturnDate(returnDate);

        // add to car db
        newCar.setReserved(true);
        newCar.setRentedOut(false); //not paid
         carRepository.save(newCar);



        // find duration

        duration=(Long) ChronoUnit.DAYS.between(pickupDate, returnDate);



        return carRentalRepository.save(rental);
    }
    public Car callCar(String carId){
        Car carFleet  = restTemplate.getForObject(carFleetUrl+"/cars/{id}", Car.class,carId);
        System.out.println("get car " + carFleet);

        return carFleet;
    }
//@Transactional
    public void makePayment(String cardNumber, String type,int expireYear,
                            int  month,String securityCode,Long rentalId ){


        try {
            Payment payment = paymentRepository.findById(cardNumber).get();
            System.out.println(payment);
            //  int aDuration = Integer.parseInt(duration);
           // System.out.println(price);

            double aPrice = Double.parseDouble(price);
           // System.out.println( "price "+ aPrice);
            CarRental carRental=    carRentalRepository.findById(rentalId).get();
            LocalDate pickupDate = carRental.getPickupDate();
            LocalDate returnDate = carRental.getReturnDate();
            duration=(Long) ChronoUnit.DAYS.between(pickupDate, returnDate);
            //System.out.println("duration "+duration);

            double amount =duration*aPrice;
            boolean success = payment.getCardNumber().equals(cardNumber) && payment.getType().equals(type)
                    && payment.getExpireYear() == expireYear && payment.getMonth() == month
                    && payment.getSecurityCode() == securityCode && (payment.getBalance() >= amount);
            //System.out.println(payment.getBalance()>=amount);

//        if((payment==null || success)  ){
            boolean pass = false;
           // if (payment==null || success==false)
                if(pass)
                throw new PaymentException(" payment failed ");

            double newBalance = payment.getBalance() - amount;
            System.out.println("new balance "+newBalance);
            payment.setBalance(newBalance);
            paymentRepository.save(payment);

            RentalHistory rentalHistory = new RentalHistory();
            rentalHistory.setCarId(carRental.getCarId());
            rentalHistory.setCustomerId(carRental.getCustomerId());
            rentalHistory.setRentDate(carRental.getPickupDate());
            rentalHistory.setReturnDate(carRental.getReturnDate());

            Long custmerId =carRental.getCustomerId();
            Customer customer =customerRepository.findById(custmerId).get();

            int points =customer.getPoints();
            int rPoint =Integer.parseInt(rewardPoints);
            points =points+rPoint;
            String status =customer.getStatus();
            if(points<100){
                status ="Bronze";
            }
            else if(points>100&points<200){
                status ="Silver";
            }
           else  if(points>200){
                status ="Gold";
            }
           customer.setPoints(points);
           customer.setStatus(status);

          carRental.setStatus("borrowed");
           carRental.setStatus("paid");

          String carId =carRental.getCarId();
            System.out.println(carId);

         // Long carId1 =Long.parseLong(carId);
            Car car =carRepository.findById(carId).get();
          String LicensePlate  = car.getLicensePlate();
           rentalHistory.setLicensePlate(LicensePlate);
           car.setRentedOut(true);

           carRental.setTotalCost(amount);
            System.out.println("amount " +amount);
            customerRepository.save(customer);
            carRentalRepository.save(carRental);
           rentalHistoryRepository.save(rentalHistory);
           carRepository.save(car);


        }
        catch (Exception e){
           //carRentalRepository.findById();
            System.out.println(e.getMessage());
            throw  e;
        }



    }
    public CarRental returnCar(Long rentalId,String cardNumber, String type,int expireYear,
                               int  month,String securityCode) {
        // get rental record by id
        CarRental rental = carRentalRepository.findById(rentalId).orElse(null);
        if (rental == null) {
            throw new RuntimeException("Rental record not found.");
        }
        LocalDate today = LocalDate.now();
        LocalDate returnDate = rental.getReturnDate();
      boolean delay= today.isAfter(returnDate)|| today.isEqual(returnDate);

        String carId = rental.getCarId();

        //RentalHistory rentalHistory =rentalHistoryRepository.findByCarId(carId);
        System.out.println("..here...");
      if(delay){
          long delayDuration = ChronoUnit.DAYS.between(returnDate, today);
         // rentalHistory.setReturnDate(today);
          // make payment
          delayPayment(rentalId,cardNumber,type,expireYear,month,securityCode,delayDuration);

      }


      // remove car from car db
       carRepository.deleteById(carId);
      //remove from car rental db
        carRentalRepository.deleteById(rentalId);

        // update rental record with return date and calculate total cost
        rental.setReturnDate(returnDate);


        // release car by sending message to car fleet
        jmsTemplate.convertAndSend("carFleet", rental.getCarId());

        return rental;
    }
    public void delayPayment(Long rentalID,String cardNumber, String type,int expireYear,
                             int  month,String securityCode,long delayDuration ){

        Payment payment = paymentRepository.findById(cardNumber).orElse(null);

        double aPrice = Double.parseDouble(price);


        double amount =delayDuration*aPrice;
        boolean success = payment.getCardNumber().equals(cardNumber) && payment.getType().equals(type)
                && payment.getExpireYear() == expireYear && payment.getMonth() == month
                && payment.getSecurityCode() == securityCode && (payment.getBalance() >= amount);
        //System.out.println(payment.getBalance()>=amount);

//        if((payment==null || success)  ){
        boolean pass = false;
        // if (payment==null || success==false)
        if(pass)
            throw new PaymentException(" payment failed ");

        double newBalance = payment.getBalance() - amount;
        System.out.println("new balance "+newBalance);
        payment.setBalance(newBalance);
        CarRental rental = carRentalRepository.findById(rentalID).get();
        String carId = rental.getCarId();
        RentalHistory rentalHistory =rentalHistoryRepository.findByCarId(carId);
        rentalHistory.setTotalCost(amount);
        rentalHistoryRepository.save(rentalHistory);
        paymentRepository.save(payment);
    }
   public int numberCursTheSameMakerAndBrand(String make, String brand){
       int number = carRepository.findByMakeAndBrand(make,brand).size();
       if(number<3){
           jmsTemplate.convertAndSend("carFleet",messageSender.send("less than 3 car available"));
       }
        return number;
   }

}