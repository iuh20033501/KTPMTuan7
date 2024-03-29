package iuh.fit.edu.vn.authentication.repository;

import iuh.fit.edu.vn.authentication.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication,Long> {
}
