package ucll.ip_minor.project.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ucll.ip_minor.project.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
