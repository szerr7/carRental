package carRental;

import carRental.domain.Car;
import carRental.domain.Customer;
import carRental.domain.Payment;
import carRental.dto.CustomerDto;
import carRental.repositories.PaymentRepository;
import carRental.service.CarRentalService;
import carRental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJms
@PropertySource(value = "classpath:application.properties")
@EnableScheduling
public class EnterpriseArchitectureProjectApplication  implements CommandLineRunner {
	@Autowired
	CustomerService customerService;
	@Autowired
	CarRentalService carRentalService;
	@Autowired
	PaymentRepository paymentRepository;


	public static void main(String[] args) {
		SpringApplication.run(EnterpriseArchitectureProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("........here wo go.....CarRental Module....................");

		//add customer
//		Address address1 =new Address("3rd st","Chicago","IL","54232");
		CustomerDto customer = new CustomerDto(null, "104", "someone",
				"some@gmail.com",0,"Bronze");
         //  customerService.addCustomer(customer);
		//System.out.println(customerService.findCustomerByEmail("j@gmail.com"));

		//


		// add Payment
		Payment payment = new Payment("123456","CREDIT", 2024,12,"122",12000);
		//paymentRepository.save(payment);



      // make payment
		//carRentalService.makePayment("123456","CREDIT", 2024,12,"122",1L);


//		//Car reserve
           LocalDate pickUp =LocalDate.of(2023,4,24);
             LocalDate returnDate =LocalDate.of(2023,4,27);
		//	carRentalService.rentCar(2L,"1024",pickUp,returnDate);


      // car return
		//carRentalService.returnCar(5L,"123456","CREDIT",
		//	2024,12,"122");


              // car  getAll car reserved
		//List<Car>  cars =carRentalService.getAllAvailableCars();
		//System.out.println(cars);

		//System.out.println(customerService.findCustomerByEmail("j@gmail.com"));
	//	System.out.println(customerService.findCustomerByCustomerNumber("101"));

	//	int number =carRentalService.numberCursTheSameMakerAndBrand("Toyota","Camry");
		//System.out.println(number);




	}
}