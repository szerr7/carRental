package carRental.domain;

import lombok.*;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class RentalEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @NotBlank
    @Column(name = "fullName", unique = true)
    private  String fullName;
    @Column(name = "email", unique = true)
    @Email
    private String email;


}
