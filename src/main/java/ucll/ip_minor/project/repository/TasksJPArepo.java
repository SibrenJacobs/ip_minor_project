package ucll.ip_minor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucll.ip_minor.project.domain.Task;

public interface TasksJPArepo extends JpaRepository<Task,Integer> {

}
