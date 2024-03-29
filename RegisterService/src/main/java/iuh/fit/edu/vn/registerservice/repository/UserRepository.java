package iuh.fit.edu.vn.registerservice.repository;

import iuh.fit.edu.vn.registerservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
