package ucll.ip_minor.project.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String name;
    @OneToMany
    private Set<Task> tasks;
    @ManyToMany
    private Set<User> members;

    public Team(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Set<User> getMembers() {
        return members;
    }
}
