package carRental.domain;
//
import carRental.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.WindowFocusListener;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomer {

    Customer customer;
    @BeforeEach
    public void setUp(){
        customer= new Customer();
    }
    @Test
    public void testAddCustomer(){
        Customer customer1 =new Customer(null,"12","baba kaka",
                "b@gmail.com",20,"Gold");
        assertEquals(20,customer1.getPoints());
    }
    @Test
    public void testCreateTwoCustomers(){
        Customer customer1 =new Customer(null,"12","baba kaka",
                "b@gmail.com",20,"Gold");
        Customer customer2 =new Customer(null,"13","sol sol",
                "sol@gmail.com",20,"Gold");
        int expected = customer1.getPoints()+customer2.getPoints();
        assertEquals(40,expected);
    }
    @Test
    public void testCreateThreeCustomes(){
        Customer customer1 =new Customer(null,"12","baba kaka",
                "b@gmail.com",20,"Gold");
        Customer customer2 =new Customer(null,"13","sol sol",
                "sol@gmail.com",20,"Gold");
        Customer customer3 =new Customer(null,"14","man sol",
                "m@gmail.com",40,"Gold");
        int expected = customer1.getPoints()+customer2.getPoints()+customer3.getPoints();
        assertEquals(80,expected);
    }



}
