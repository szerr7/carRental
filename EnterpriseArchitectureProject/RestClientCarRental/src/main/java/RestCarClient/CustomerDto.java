package RestCarClient;

//import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerDto {
    private  Long id;

    private String customerNumber;

    private  String fullName;

    private String email;
    private  Integer  points;
    private String status;


}
