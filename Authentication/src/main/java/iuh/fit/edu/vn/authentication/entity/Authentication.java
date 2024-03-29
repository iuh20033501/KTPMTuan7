package iuh.fit.edu.vn.authentication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Authentication {
    @Id
        private String username;
        private String password;
    public Authentication(String username) {
        this.username = username;
    }
}
