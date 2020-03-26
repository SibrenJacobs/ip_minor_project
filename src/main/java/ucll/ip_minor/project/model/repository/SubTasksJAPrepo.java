package ucll.ip_minor.project.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucll.ip_minor.project.model.entity.SubTask;

public interface SubTasksJAPrepo extends JpaRepository<SubTask,Integer> {
}
