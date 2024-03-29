package iuh.fit.edu.vn.registerservice.controller;

import iuh.fit.edu.vn.registerservice.entity.User;
import iuh.fit.edu.vn.registerservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    List<User> getAllUsers() { return userRepository.findAll();
    }
    @GetMapping("/users/{id}") // get user by id
    User getUserById(@PathVariable int id) { return userRepository.findById(id).get();
    }
    @PostMapping("/users")
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
