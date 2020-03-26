package ucll.ip_minor.project.model.DTO;


import java.util.Objects;

public class SubTaskDTO {
    private int id;
    private String title,description;
    private TaskDTO parent;

    public SubTaskDTO(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setParent(TaskDTO parent) {
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public TaskDTO getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof SubTaskDTO){
            return this.id == ((SubTaskDTO) o).id;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }
}
