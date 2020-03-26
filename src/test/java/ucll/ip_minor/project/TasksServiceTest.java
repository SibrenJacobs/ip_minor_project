package ucll.ip_minor.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ucll.ip_minor.project.DTO.TaskDTO;
import ucll.ip_minor.project.service.TasksService;

import java.time.LocalDateTime;
import java.util.Collection;

@SpringBootTest
public class TasksServiceTest {
    @Autowired
    private TasksService service;
    private TaskDTO task1,task2,task3;

    @BeforeEach
    public void setUp(){
        task1 = new TaskDTO("task 1","task 1", LocalDateTime.now());
        task1.setId(1);

        task2 = new TaskDTO("task 2","task 2", LocalDateTime.now());
        task2.setId(2);

        task3 = new TaskDTO("task 3","task 3", LocalDateTime.now());
        task3.setId(3);

        service.addTask(task1);
        service.addTask(task2);
        service.addTask(task3);
    }

    @Test
    public void getTasks_give_tasks(){
        Collection<TaskDTO> tasks = service.getTasks();

        assertEquals(3,tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
        assertTrue(tasks.contains(task3));
    }

    @Test
    @Transactional
    public void getTask_gives_correct_task(){
        assertEquals(task1, service.getTask(task1.getId()));
        assertEquals(task2, service.getTask(task2.getId()));
        assertEquals(task3, service.getTask(task3.getId()));
    }
}
