package carRental.repositries;

import carRental.domain.Customer;
import carRental.repositories.CustomerRepository;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@DataJpaTest
public class TestCustomerRepository {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepository customerRepository;
    @Test
    public void whenFindByEmail_thenReturnCustomer() {
// given
        Customer customer1  =new Customer(null,"12","baba kaka",
                "b@gmail.com",20,"Gold");
        entityManager.persist(customer1);
        entityManager.flush();
// when
        Customer found = customerRepository.findByEmail("b@gmail.com");
// then

        assertThat(found.getEmail())
                .isEqualTo(customer1.getEmail());
    }
    @Test
    public void whenFindByCustomerNumber_thenReturnCustomer() {
// given
        Customer customer1  =new Customer(null,"12","baba kaka",
                "b@gmail.com",20,"Gold");
        entityManager.persist(customer1);
        entityManager.flush();
// when
        Customer found = customerRepository.findByCustomerNumber("12");
// then
        assertThat(customer1.getCustomerNumber())
                .isEqualTo(found.getCustomerNumber());
    }
    @Test
    public void whenFindByFullName_thenReturnCustomer() {
// given
        Customer customer1  =new Customer(null,"12","baba kaka",
                "b@gmail.com",20,"Gold");
        entityManager.persist(customer1);
        entityManager.flush();
// when
        Customer found = customerRepository.findByFullName("baba kaka");
// then
        assertThat(customer1.getFullName())
                .isEqualTo(found.getFullName());
    }



}
