package carfleetrestclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarFleetRestClientApplication implements CommandLineRunner {
@Autowired
FleetManager fleetManager;
    public static void main(String[] args) {
        SpringApplication.run(CarFleetRestClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("........here we go .........Car fleet RestClient.....");


        //add car need to fix
//        fleetManager.createCar("1023","Toyota","Camry",2017,"Blue",3421,
//                "VA118",false,false,43000.0);

        // remove car
        String id ="1008";
       // fleetManager.removeCar(id);

        //update car  need to fix for internal server error

       // CarDto carDto = new CarDto("1003","Honda","Civic",2023,"White",3333,"VA2314");

        //fleetManager.updateCar(carDto,"1003");

     //get by maker need to fix
     //  fleetManager.getByCarMaker("Toyota");

       //get by maker and brand
       // fleetManager.getByCarMakerAndBrand("Toyota","Camry");


    }
}
