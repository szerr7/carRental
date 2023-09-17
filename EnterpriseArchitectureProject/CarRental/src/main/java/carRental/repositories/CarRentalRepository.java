package carRental.repositories;

import carRental.domain.Car;
import carRental.domain.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CarRentalRepository extends JpaRepository<CarRental,Long> {
 //Integer countByCustomerIdAndReturnDateAfter(Long customerID, Date date);
 Integer countByCustomerIdAndReturnDateAfter(Long customerId, LocalDate date);

}
