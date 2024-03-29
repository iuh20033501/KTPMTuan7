package iuh.fit.edu.vn.login.repository;

import iuh.fit.edu.vn.login.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Long> {
}
