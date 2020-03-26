package ucll.ip_minor.project.model.service;

import ucll.ip_minor.project.model.DTO.SubTaskDTO;
import ucll.ip_minor.project.model.DTO.TaskDTO;

import java.util.List;

public interface TasksService {
    List<TaskDTO> getTasks();
    TaskDTO getTask(int id);
    void addTask(TaskDTO taskDTO);
    void deleteTask(int id);
    void editTask(TaskDTO taskDTO);
    void addSubTask(SubTaskDTO subTaskDTO);
    List<SubTaskDTO> getSubtasks();
    List<SubTaskDTO> getSubTasksOfParent(int parentId);
}
