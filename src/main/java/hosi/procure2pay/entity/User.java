package hosi.procure2pay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
