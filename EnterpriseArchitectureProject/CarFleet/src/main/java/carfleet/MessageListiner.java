package carfleet;

import carfleet.adaptor.CarFleetAdaptor;
import carfleet.domain.Car;
import carfleet.repository.CarFleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListiner {
    @Autowired
    CarFleetRepository carFleetRepository;
    @JmsListener(destination = "carFleet")
    public void receiveMessage(final String carId) {
       Car car = carFleetRepository.findById(carId).get();
       car.setRented(true);
       car.setReserved(true);

        System.out.println("carID "+carId+ "has reserved");
    }
}
