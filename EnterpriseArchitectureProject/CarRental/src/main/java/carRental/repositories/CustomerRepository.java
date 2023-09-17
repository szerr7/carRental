package carRental.repositories;

import carRental.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository  extends JpaRepository<Customer,Long> {

    Customer findByCustomerNumber(String customerNumber);
    Customer findByFullName(String fullName);


    Customer findByEmail(String email);

}
