package carRental.adapter;

import carRental.domain.Car;
import carRental.domain.Customer;
import carRental.dto.CarDto;
import carRental.dto.CustomerDto;

public class CustomerAdaptor {
    public static CustomerDto fromCustomerToCustomerDto(Customer customer) {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setCustomerNumber(customer.getCustomerNumber());
        customerDto.setFullName(customer.getFullName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPoints(customer.getPoints());
        customerDto.setStatus(customer.getStatus());

        return customerDto;

    }

    public static Customer fromCustomerDtoToCustomer(CustomerDto customerDto) {

        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setCustomerNumber(customerDto.getCustomerNumber());
        customer.setFullName(customerDto.getFullName());
        customer.setEmail(customerDto.getEmail());
        customer.setPoints(customerDto.getPoints());
        customer.setStatus(customerDto.getStatus());

        return customer;

    }

    public static CarDto fromCarToCarDto(Car car) {
        CarDto carDto =new CarDto();
        carDto.setId(car.getId());
        carDto.setMake(car.getMake());
        carDto.setBrand(car.getBrand());
        carDto.setYear(car.getYear());
        carDto.setColor(car.getColor());
        carDto.setMiles(car.getMiles());
       carDto.setLicensePlate(car.getLicensePlate());
       carDto.setRentedOut(car.isRentedOut());
       carDto.setReserved(car.isReserved());
       carDto.setPrice(car.getPrice());

        return carDto;
    }
    public static Car fromCarDtoToCar(CarDto carDto) {
        Car car =new Car();
        car.setId(carDto.getId());
        car.setMake(carDto.getMake());
        car.setBrand(carDto.getBrand());
        car.setYear(carDto.getYear());
        car.setColor(carDto.getColor());
        car.setMiles(carDto.getMiles());
        car.setLicensePlate(carDto.getLicensePlate());
        car.setRentedOut(carDto.isRentedOut());
        car.setReserved(carDto.isReserved());
        car.setPrice(carDto.getPrice());

        return car;
    }
}