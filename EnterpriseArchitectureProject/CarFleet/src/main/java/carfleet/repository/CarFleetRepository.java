package carfleet.repository;



import carfleet.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarFleetRepository extends MongoRepository<Car,String> {
    List<Car>findByMakeAndBrand(String make, String brand);
    List<Car>findByMake(String make);

}
