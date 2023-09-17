package carRental.repositories;

import carRental.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,String> {

    List<Car>findByRentedOutFalse();
    //Car findByIdAndRentedOutIsFalse();
    Car findByIdAndAndRentedOutFalse(String id);
 //  Car  findByIdAndRentedOutFalse(String carId);
   Car findByIdAndRentedOutFalse(String id);
   Car findByIdAndAndReserved(String id, boolean reserved);
   List<Car>findByMakeAndBrand(String make,String brand);
}

