package iuh.fit.edu.vn.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Login {
    @Id
        private String username;
        private String password;
    public Login(String username) {
        this.username = username;
    }
}
