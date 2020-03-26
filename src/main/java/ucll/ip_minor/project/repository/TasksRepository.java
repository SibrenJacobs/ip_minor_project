package ucll.ip_minor.project.repository;

import org.springframework.stereotype.Repository;
import ucll.ip_minor.project.domain.Task;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class TasksRepository {
    private Map<Integer,Task> map;

    public TasksRepository() {
        map = new HashMap<>();
        map.put(getNewId(),new Task("Task 1","Description of task 1", LocalDateTime.of(2020,3,20,10,0)));
        map.put(getNewId(),new Task("Task 2","Description of task 2", LocalDateTime.of(2020,3,21,18,0)));
        map.put(getNewId(),new Task("Task 3","Description of task 3", LocalDateTime.of(2020,3,27,17,0)));
    }

    public Collection<Task> getTasks() {
        return map.values();
    }

    public Task getTask(int id){
        return map.get(id);
    }

    public void addTask(Task task){
        task.setId(getNewId());
        map.put(task.getId(),task);
    }

    public void deleteTask(int id){
        map.remove(id);
    }

    public void editTask(Task task){
        map.replace(task.getId(),task);
    }

    public int size(){
        return map.size();
    }

    private int getNewId(){
        for (int i = 0; i < 1000; i++){
            if (!map.containsKey(i)){
                return i;
            }
        }
        throw new RuntimeException("Can't add anymore tasks");
    }
}
