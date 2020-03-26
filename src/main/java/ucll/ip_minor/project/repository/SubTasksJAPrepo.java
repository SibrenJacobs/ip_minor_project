package ucll.ip_minor.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucll.ip_minor.project.domain.SubTask;

public interface SubTasksJAPrepo extends JpaRepository<SubTask,Integer> {
}
