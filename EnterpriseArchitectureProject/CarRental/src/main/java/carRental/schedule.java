package carRental;

import carRental.domain.Car;
import carRental.service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class schedule {
    @Autowired
    CarRentalService carRentalService;
    @Scheduled(fixedDelay = 20000)
    	public void printCarOverview() {
		List<Car> cars = carRentalService.getAllAvailableCars();
		System.out.println("==== Car Overview ====");
		cars.forEach(car -> {
			System.out.println("ID: " + car.getId() + " | make: " + car.getMake()+ " | Brand: " + car.getBrand() +
					 " | Year: " + car.getYear() + " | Price: " + car.getPrice() +
					" | Available: " + !car.isRentedOut());
		});
		System.out.println("======================");
	}

}
