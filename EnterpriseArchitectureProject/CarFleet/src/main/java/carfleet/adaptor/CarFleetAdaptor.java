package carfleet.adaptor;


import carfleet.domain.Car;
import carfleet.dto.CarDto;

public class CarFleetAdaptor {
    public static Car fromCarDtoToCar(CarDto carDto){
        Car car = new Car();
        car.setId(carDto.getId());
        car.setMake(carDto.getMake());
        car.setBrand(carDto.getBrand());
        car.setYear(carDto.getYear());
        car.setColor(carDto.getColor());
        car.setMiles(carDto.getMiles());
        car.setLicensePlate(carDto.getLicensePlate());
        return car;
    }
    public static CarDto  fromCarToCarDto( Car car){
        CarDto carDto =new CarDto();
        carDto.setId(car.getId());
        carDto.setMake(car.getMake());
        carDto.setBrand(car.getBrand());
        carDto.setYear(car.getYear());
        carDto.setColor(car.getColor());
        carDto.setMiles(car.getMiles());
        carDto.setLicensePlate(car.getLicensePlate());
        return carDto;
    }


}
