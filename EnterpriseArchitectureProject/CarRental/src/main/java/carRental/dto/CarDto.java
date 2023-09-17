package carRental.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {
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
  //  @Column(unique = true)
    private String LicensePlate;
    private boolean rentedOut;
    private boolean reserved;
    private  double price;
}
