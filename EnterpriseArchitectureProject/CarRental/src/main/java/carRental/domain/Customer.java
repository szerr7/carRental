package carRental.domain;


import lombok.*;
import org.hibernate.annotations.Table;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "customer_number", unique = true)
    private String customerNumber;
    @NotBlank
    @Column(name = "fullName", unique = true)
    private String fullName;

    @Column(name = "email", unique = true)
    @Email
    private String email;

   private  Integer  points;
   private String status;


//    public Customer(Long id, String customerNumber, String fullName, String email) {
//        this.id = id;
//        this.customerNumber = customerNumber;
//        this.fullName = fullName;
//        this.email = email;
//    }


//    public Customer(Long id, String customerNumber, String fullName, String email, String carId) {
//        this.id = id;
//        this.customerNumber = customerNumber;
//        this.fullName = fullName;
//        this.email = email;
//        this.carId = carId;
//    }
}
