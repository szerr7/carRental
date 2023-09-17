package carRental.controller;

import carRental.adapter.CustomerAdaptor;
import carRental.domain.Customer;
import carRental.dto.CustomerDto;
import carRental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;


/*
    @PostMapping("customers")
    public ResponseEntity<?>createCustomer( @RequestParam(value ="customerNumber") String  customerNumber,
                                            @RequestParam(value ="fullName")   String fullName,
                                            @RequestParam(value ="email") String email,
                                            @RequestParam(value ="points") int points,
                                            @RequestParam(value ="status") String status){

       CustomerDto customerDto =customerService.createCustomer(customerNumber,fullName,email,points,status);
       return new ResponseEntity<CustomerDto>(customerDto,HttpStatus.CREATED);
    }

 */
@PostMapping("customers")
public ResponseEntity<?>createCustomer( String  customerNumber,
                                        String fullName,
                                        String email,
                                        int points,
                                         String status){

    CustomerDto customerDto =customerService.createCustomer(customerNumber,fullName,email,points,status);
    return new ResponseEntity<CustomerDto>(customerDto,HttpStatus.CREATED);
}
    @DeleteMapping("customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCustomer(@PathVariable Long id){
customerService.removeCustomer(id);
    }
//    @PutMapping("/customers/{id}")
//            @ResponseStatus(HttpStatus.OK)
//    public CustomerDto updateCustomer(@PathVariable Long id,@RequestBody  CustomerDto customerDto){
//      CustomerDto customerDto1=  customerService.updateCustomer(id,customerDto);
//        return customerDto1;
//            }
@PutMapping("/customers/{id}")
@ResponseStatus(HttpStatus.OK)
public CustomerDto updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
    CustomerDto customerDto = CustomerAdaptor.fromCustomerToCustomerDto(customer);
    System.out.println(".........herre....");
    CustomerDto customerDto1=  customerService.updateCustomer(id,customerDto);
    return customerDto1;
     }

     @GetMapping("customers")
    public  CustomerDto findCustomerByOperations(String customerNumber, String fullName, String email,
           String operation) {
CustomerDto customerDto =new CustomerDto();
                if (operation.equals("byname")) {

                 return  customerService.findByFullName(fullName);
                }
                if (operation.equals("byEmail")) {

                    return  customerService.findCustomerByEmail(email);

                }
                if (operation.equals("byCustomerNumber")) {

                    return  customerService.findCustomerByCustomerNumber(customerNumber);
                }
                return  customerDto;

    }


}
