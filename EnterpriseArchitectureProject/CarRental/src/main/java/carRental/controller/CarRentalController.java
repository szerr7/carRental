package carRental.controller;

import carRental.domain.Car;
import carRental.domain.CarRental;
import carRental.repositories.CarRentalRepository;
import carRental.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class CarRentalController {
    @Autowired
    CarRentalService carRentalService;
    RestTemplate restTemplate = new RestTemplate();
   private String serverUrl = "http://localhost:8084";
    private CarRentalRepository carRentalRepository;
    @PostMapping("cars/rental")
    public void carRental(){

    }
//    @GetMapping("/cars/{make}")
//    public void getCarByMaker(@PathVariable String make){
//        restTemplate.getForObject(serverUrl+"cars/{make}", Car.class,"Toyota");
//
//        System.out.println("worked");
//
//    }

    @PostMapping("rental")

    @ResponseStatus(HttpStatus.ACCEPTED)
    public CarRental rentCar(
            @RequestParam(value = "customerId") Long customerId,
            @RequestParam(value = "carId") String carId,
            @RequestParam(value = "pickupDate") LocalDate pickupDate,
            @RequestParam(value = "returnDate") LocalDate returnDate) throws Exception {
       CarRental carRental= carRentalService. rentCar(customerId,carId,pickupDate,returnDate);
               return carRental;

    }
}
