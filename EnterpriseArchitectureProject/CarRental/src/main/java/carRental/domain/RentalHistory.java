package carRental.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RentalHistory {
    @Id
            @GeneratedValue
   private Long id;
   private Long customerId;
   private String carId;
   private  String LicensePlate;
   private LocalDate rentDate ;
    private LocalDate returnDate ;
    private double totalCost;




}
