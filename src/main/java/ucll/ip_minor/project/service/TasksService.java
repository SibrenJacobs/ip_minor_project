package ucll.ip_minor.project.service;

import ucll.ip_minor.project.DTO.SubTaskDTO;
import ucll.ip_minor.project.DTO.TaskDTO;

import java.util.Collection;

public interface TasksService {
    Collection<TaskDTO> getTasks();
    TaskDTO getTask(int id);
    void addTask(TaskDTO taskDTO);
    void deleteTask(int id);
    void editTask(TaskDTO taskDTO);
    void addSubTask(SubTaskDTO subTaskDTO);
    Collection<SubTaskDTO> getSubtasks();
    Collection<SubTaskDTO> getSubTasksOfParent(int parentId);
}
