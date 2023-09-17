package carfleet;

import carfleet.domain.Car;
import carfleet.repository.CarFleetRepository;
import carfleet.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;

import java.util.List;

@SpringBootApplication
@EnableJms
@PropertySource(value = "classpath:application.properties")
public class CarFleetApplication implements CommandLineRunner {
@Autowired
    CarService carService;

    public static void main(String[] args) {
        SpringApplication.run(CarFleetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("........here we go .........Car fleet.....");
       // System.out.println(carService.getCarsByMaker("Toyota"));
        Car car =new Car("1024","Honda","Civic",2022,"Black",4444,"VA6574",
                false,false,3400);
       // carService.createCar(car);

        //update
        Car car1 = new Car("1021","Toyota","Camry",2021,"White",3241,"VA4545",
                false,true,2300);
      //  carService.updateCar("1021",car1);

      // System.out.println( carService.getCarById("1007"));
    }
//    @Value("${carfleet.email.threshold}")
//    private int emailThreshold;
//    // ...
//    public void sendEmailNotification(String brand, String type, int numAvailable) {
//        if (numAvailable < emailThreshold) {
//            System.out.println("Send email notification to fleet manager: " + brand + " " + type + " has only " +
//                    numAvailable + " cars available.");
//        }
   // }

}
