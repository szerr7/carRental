package carRental.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto {
   @NotBlank
    private  Long id;

    private String customerNumber;

    private  String fullName;

    private String email;
    private  Integer  points;
    private String status;
}
