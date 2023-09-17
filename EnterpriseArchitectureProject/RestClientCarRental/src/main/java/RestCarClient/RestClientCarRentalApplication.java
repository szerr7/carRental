package RestCarClient;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SpringBootApplication
public class RestClientCarRentalApplication  implements CommandLineRunner {
@Autowired
CustomerManagementGateWay customerManagementGateWay;


    public static void main(String[] args) {
        SpringApplication.run(RestClientCarRentalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("........here wo go.....RestClientCarRental  module.........");

      CustomerDto customerDto =new CustomerDto();

      //add customer  done
    customerManagementGateWay.createCustomer("108","kaba theaGreat","k@gmail.com",0,"Bronze");

        //remove customer
      // customerManagementGateWay.removeCustomer(6L);

        //update customer  need too fix
        Customer customer1 =new Customer(2L,"103","Sami arkey","sami@sami.com",10,"Bronze");

        //customerManagementGateWay.updateCustomer(2L,customer1);
        //find by email
       CustomerDto getCustomer=    customerManagementGateWay.findCustomerByCustomerNumber("106","byCustomerNumber");

        System.out.println(getCustomer);
    }
}
