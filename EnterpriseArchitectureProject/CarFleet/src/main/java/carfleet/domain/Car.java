package carfleet.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "cars")
@ToString
public class Car {
    @Id
    String id;
    @NotBlank
    private String make;
    @NotBlank
    private String brand;
    @NotBlank
    private int year;
    @NotBlank
    private String color;
    @NotBlank
    private int miles;
   @Indexed(unique = true)
    private String LicensePlate;
    private boolean rented;
    private boolean reserved;
    private  double price;

    public Car(String id, String make, String brand, int year, String color, int miles, String licensePlate) {
        this.id = id;
        this.make = make;
        this.brand = brand;
        this.year = year;
        this.color = color;
        this.miles = miles;
        LicensePlate = licensePlate;
    }
}
