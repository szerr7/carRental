package carRental.domain;



import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Payment {
    @Id

    private String CardNumber;
   // @NotBlank
    private String type;
  //  @NotBlank
    private int expireYear;
  //  @NotBlank
    private int  Month;
   // @NotBlank
    private String securityCode;
    //@NotBlank
    private double  balance;
}
