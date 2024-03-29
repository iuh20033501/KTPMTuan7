package iuh.fit.edu.vn.registerservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID", nullable = false)
    private int userID;
    @Column(name = "Username")
    private String userName;
    @Column(name = "Password")
    private String  password;
    @Column(name ="Email")
    private String email;
    public User(int userID) {
        this.userID = userID;
    }
}
