package RestCarClient;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class CustomerManagementGateWay {
    RestTemplate restTemplate = new RestTemplate();
    private String serverUrl = "http://localhost:8084";
    public void createCustomer(String  customerNumber,String fullName,String email,int points, String status){
        restTemplate.postForLocation(serverUrl+"/customers?customerNumber={customerNumber}&" +
                "fullName={fullName}&email={email}&points={points}&status={status}",
                Customer.class,customerNumber,fullName,email,points,status);

    }
    public void removeCustomer( Long id){
         restTemplate.delete(serverUrl+"/customers/{id}", id );

    }
    public void updateCustomer(Long id,Customer customer){

        System.out.println("...here1...");
       restTemplate.put(serverUrl+"/customers/{id}",customer,id);


    }
    public CustomerDto findCustomerByName(String fullName,String operation ){
     CustomerDto customerDto=   restTemplate.getForObject(serverUrl+"/customers?fullName={fullName}&operation={operation}", CustomerDto.class,fullName,operation);
        return customerDto;
    }
    public CustomerDto findCustomerByCustomerNumber(String customerNumber,String operation ){
        CustomerDto customerDto=   restTemplate.getForObject(serverUrl+"/customers?customerNumber={customerNumber}&operation={operation}", CustomerDto.class,customerNumber,operation);
        return customerDto;
    }
    public CustomerDto findCustomerByEmail(String email,String operation ){
        CustomerDto customerDto=   restTemplate.getForObject(serverUrl+"/customers?email={email}&operation={operation}", CustomerDto.class,email,operation);
        return customerDto;
    }
}
