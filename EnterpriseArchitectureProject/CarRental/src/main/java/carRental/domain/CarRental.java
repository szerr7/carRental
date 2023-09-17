package carRental.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString

public class CarRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private String carId;


    private LocalDate pickupDate;

    private LocalDate returnDate;
    private double TotalCost;
    private String  status ="reserved";

}
