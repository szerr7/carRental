package carfleet.dto;


import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CarDto {
    @NotBlank
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
}
