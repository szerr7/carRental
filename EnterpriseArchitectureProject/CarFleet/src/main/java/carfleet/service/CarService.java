package carfleet.service;

import carfleet.adaptor.CarFleetAdaptor;
import carfleet.domain.Car;
import carfleet.dto.CarDto;
import carfleet.exception.ResourceNotFoundError;
import carfleet.repository.CarFleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CarService {
@Autowired
CarFleetRepository carFleetRepository;


//add Car
    public CarDto createCar(Car car){
       // String id =car.getId();
//      Car getCar =  carFleetRepository.findById(id).get();
//     //   System.out.println(getCar);
//      if(!(getCar ==null)){
//          NotDuplicateIdError  error = new NotDuplicateIdError("id: "+id+ " is duplicated");
//          return null;
//      }
      Car savedCar =  carFleetRepository.save(car);
        CarDto carDto = CarFleetAdaptor.fromCarToCarDto(savedCar);
        return carDto;


    }
   public void addCar(String  make,String brand,int year,String color,int miles,String LicensePlate){
        Car car =new Car(null,make,brand,year,color,miles,LicensePlate);
        carFleetRepository.save(car);
   }
    //  remove car
    public void removeCar(String id) {

        Car carExist= carFleetRepository.findById(id).get();
        if (carExist ==null){
            System.out.println("no car has registered with this id");
        }
        carFleetRepository.deleteById(id);

    }

    public Car getCarById(String id){
      return  carFleetRepository.findById(id).get();
    }

public CarDto updateCar(String id,CarDto carDto){
     Car existCar=   carFleetRepository.findById(id).get();
    Car car = CarFleetAdaptor.fromCarDtoToCar(carDto);
        if(existCar==null){
            carFleetRepository.save(car);
            return CarFleetAdaptor.fromCarToCarDto(car);
        }
        existCar.setMake(car.getMake());
        existCar.setBrand(car.getBrand());
        existCar.setYear(car.getYear());
        existCar.setColor(car.getColor());
        existCar.setMiles(car.getMiles());
        existCar.setLicensePlate(car.getLicensePlate());
        carFleetRepository.save(existCar);
        CarDto savedCarDto = CarFleetAdaptor.fromCarToCarDto(existCar);
        return savedCarDto;

}
    public int getCarByMakeAndBrand(String make ,String brand){

   List<Car>  cars =   carFleetRepository.findByMakeAndBrand(make, brand);

    int numberOfCars = cars.size();

      return numberOfCars;
    }
    public Collection<CarDto> getCarsByMaker(String maker){
        Collection<Car>  cars =   carFleetRepository.findByMake(maker);
      Collection<CarDto> carDtos =new ArrayList<>();
       for (Car car:cars){

           carDtos.add(CarFleetAdaptor.fromCarToCarDto(car));
       }

        return carDtos;
    }
}
