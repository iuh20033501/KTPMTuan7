package iuh.fit.edu.vn.authentication.controller;

import iuh.fit.edu.vn.authentication.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private RestTemplate restTemplate;


    public AuthenticationController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private AuthenticationRepository authenticationRepository;

    @GetMapping("/getUsersData")
    public ResponseEntity<String> getUsersData() {
        String url = "http://localhost:8080/users/users";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }

    @GetMapping("/checkUser")
    public ResponseEntity<Map<String, Object>> checkUser() {
        String url = "http://localhost:8081/login/getUsersData";
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {
                }
        );
        List<Map<String, Object>> users = response.getBody();

        if (users != null) {
            for (Map<String, Object> userData : users) {
                String username = (String) userData.get("userName");
                String password = (String) userData.get("password");

                if ("Oge".equals(username) && "oge".equals(password)) {
                    return ResponseEntity.ok(userData); // Trả về dữ liệu của người dùng nếu tìm thấy khớp

                }
            }
        }

        return ResponseEntity.notFound().build(); // Trả về mã trạng thái 404 nếu không tìm thấy người dùng khớp
    }

@PostMapping("/authentication")
public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
    ResponseEntity<Map<String, Object>> userResponse = checkUser();
    if (userResponse.getStatusCode() == HttpStatus.OK) {
        Map<String, Object> userData = userResponse.getBody();
        String username = (String) userData.get("userName");
        String password = (String) userData.get("password");

        String inputUsername = credentials.get("userName");
        String inputPassword = credentials.get("password");

        if (username.equals(inputUsername) && password.equals(inputPassword)) {
            return ResponseEntity.ok("Đăng nhập thành công!");
        }
    }
    return ResponseEntity.badRequest().body("Thông tin đăng nhập không đúng!");
}
}
