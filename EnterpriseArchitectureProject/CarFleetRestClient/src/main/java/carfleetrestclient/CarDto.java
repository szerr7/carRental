package carfleetrestclient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class CarDto {

    String id;

    private String make;

    private String brand;

    private int year;

    private String color;

    private int miles;

    private String LicensePlate;
    private boolean rented;
    private boolean reserved;
    private  double price;

//    public CarDto(String make, String brand, int year, String color, int miles, String licensePlate) {
//        this.make = make;
//        this.brand = brand;
//        this.year = year;
//        this.color = color;
//        this.miles = miles;
//        LicensePlate = licensePlate;
//    }
}
