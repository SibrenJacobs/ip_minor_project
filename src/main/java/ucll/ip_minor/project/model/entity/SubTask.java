package ucll.ip_minor.project.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SubTask {
    @Id
    @GeneratedValue
    private int id;
    private String title,description;
    @ManyToOne
    private Task parent;

    public SubTask(){

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

    public void setParent(Task parent) {
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

    public Task getParent() {
        return parent;
    }
}
