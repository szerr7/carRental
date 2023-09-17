package carfleet.controller;

import carfleet.domain.Car;
import carfleet.dto.CarDto;
import carfleet.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
       // @RequestMapping("/cars")
public class CarFleetController {
    @Autowired
    CarService carService;

    @PostMapping("/cars")

    @ResponseStatus(HttpStatus.CREATED)
   public void addCar(String  make,String brand,int year,String color,
                      int miles,String LicensePlate,boolean rented,boolean reserved,double price ){
        Car car = new Car(null,make,brand,year,color,miles,LicensePlate,rented,reserved,price);
        carService.createCar(car);
    }

    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCar(@PathVariable String id){
        carService.removeCar(id);
    }

    @PutMapping("/cars/{id}")

    @ResponseStatus(HttpStatus.OK)
    public CarDto updateCar(CarDto carDto,String id){
        //carDto.setId(id);
      CarDto carDto1=  carService.updateCar(id, carDto);
      return carDto1;
    }
//    @GetMapping("/cars/{make}")
//    @ResponseStatus(HttpStatus.OK)
//    public Collection<CarDto> getCarByBrand(@PathVariable String make ){
//    Collection<CarDto> cars=  carService.getCarsByMaker(make);
//        return cars;
//    }
    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public int getCarByBrandAndBrand(@RequestParam(value ="make") String  make,
                                     @RequestParam(value ="brand")
                                     String brand ){
        int number = carService.getCarByMakeAndBrand(make, brand);
        return number;
    }

    @GetMapping("cars/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public Car getCarById(@PathVariable String id ){
        Car car = carService.getCarById(id);
        System.out.println(car);
        return car;
    }


    }

