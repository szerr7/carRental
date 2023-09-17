package carRental.service;

import carRental.adapter.CustomerAdaptor;
import carRental.domain.Customer;
import carRental.dto.CustomerDto;
import carRental.exception.ResourceNotFoundException;
import carRental.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  @Autowired
    CustomerRepository customerRepository;
    public void addCustomer(CustomerDto customerDto){
        Customer customer = CustomerAdaptor.fromCustomerDtoToCustomer(customerDto);
        customerRepository.save(customer);
    }
    public void removeCustomer(Long id){
        customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));
        customerRepository.deleteById(id);
    }
    public CustomerDto createCustomer(String customerNumber, String fullName, String email,int points, String status){

        Customer customer = new Customer(null,customerNumber,fullName,email,points,status);
        customerRepository.save(customer);
        CustomerDto customerDto =new CustomerDto();
        customerDto  =  CustomerAdaptor.fromCustomerToCustomerDto(customer);
        return customerDto;
    }
    public CustomerDto updateCustomer(Long id,CustomerDto customerDto){

        Customer customer =CustomerAdaptor.fromCustomerDtoToCustomer(customerDto);
        Customer existCustomer = customerRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("customer","id",id));

              existCustomer.setCustomerNumber(customer.getCustomerNumber());
              existCustomer.setFullName(customer.getFullName());
              existCustomer.setEmail(customerDto.getEmail());
              existCustomer.setStatus(customerDto.getStatus());
              existCustomer.setPoints(customerDto.getPoints());

              customerRepository.save(existCustomer);
        CustomerDto savedCustomerDto= CustomerAdaptor.fromCustomerToCustomerDto(existCustomer);
       return savedCustomerDto;
    }
    public CustomerDto findCustomerByCustomerNumber(String customerNumber){
     Customer customer=   customerRepository.findByCustomerNumber(customerNumber);
     if(customer==null){
        return null;
     }
     CustomerDto customerDto=CustomerAdaptor.fromCustomerToCustomerDto(customer);
     return customerDto;
    }
    public CustomerDto findByFullName(String fullName){
        Customer customer=   customerRepository.findByFullName(fullName);
        if(customer==null){
          return null;
        }
        CustomerDto customerDto=CustomerAdaptor.fromCustomerToCustomerDto(customer);
        return customerDto;
    }
   public CustomerDto findCustomerByEmail(String email){
       Customer customer=   customerRepository.findByEmail(email);


       if(customer==null){
           return null;
       }
       CustomerDto customerDto=CustomerAdaptor.fromCustomerToCustomerDto(customer);
       return customerDto;

   }





}
