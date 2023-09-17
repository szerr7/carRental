package carRental.domain;

import lombok.*;

import org.springframework.stereotype.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
    public class Car {

        @Id
        String id;
       // @NotBlank
        private String make;
       // @NotBlank
        private String brand;
       // @NotBlank
        private int year;
       // @NotBlank
        private String color;
       // @NotBlank
        private int miles;
       @Column(unique = true)
        private String LicensePlate;
        private boolean rentedOut;
        private boolean reserved;
        private  double price;


}
