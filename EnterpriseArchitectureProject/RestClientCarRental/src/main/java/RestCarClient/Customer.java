package RestCarClient;

//import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Setter
//@ToString
//@Entity
//@Table(name = "customers")
public class Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @NotBlank

    private String customerNumber;
    @NotBlank
   // @Column(name = "fullName", unique = true)
    private  String fullName;

   // @Column(name = "fullName", unique = true)
    @Email
    private String email;
    private  Integer  points;
    private String status;


}
