package ucll.ip_minor.project.model.DTO;

import org.springframework.format.annotation.DateTimeFormat;
import ucll.ip_minor.project.model.entity.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TaskDTO implements Comparable<TaskDTO> {
    private int id;
    private String title,description;
    private LocalDateTime dueDate;

    public TaskDTO(){

    }

    public TaskDTO(String title,String description,LocalDateTime dueDate){
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DateTimeFormat
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy 'at' H");
        return title + ": due " + dueDate.format(formatter);
    }

    @Override
    public int compareTo(TaskDTO task){
        return dueDate.compareTo(task.dueDate);
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof TaskDTO){
            return this.id == ((TaskDTO) o).id;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }
}
