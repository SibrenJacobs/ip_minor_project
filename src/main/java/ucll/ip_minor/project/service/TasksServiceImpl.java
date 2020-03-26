package ucll.ip_minor.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucll.ip_minor.project.DTO.SubTaskDTO;
import ucll.ip_minor.project.DTO.TaskDTO;
import ucll.ip_minor.project.domain.SubTask;
import ucll.ip_minor.project.domain.Task;
import ucll.ip_minor.project.repository.SubTasksJAPrepo;
import ucll.ip_minor.project.repository.TasksJPArepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksServiceImpl implements TasksService {

    private final TasksJPArepo tasksJPArepo;
    private final SubTasksJAPrepo subTasksJAPrepo;

    @Autowired
    public TasksServiceImpl(TasksJPArepo tasksJPArepo, SubTasksJAPrepo subTasksJAPrepo) {
        this.tasksJPArepo = tasksJPArepo;
        this.subTasksJAPrepo = subTasksJAPrepo;
    }

    @Override
    public List<TaskDTO> getTasks() {
        return tasksJPArepo.findAll().stream().map(task ->{
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setDueDate(task.getDueDate());
            return taskDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(int id){
        Task task = tasksJPArepo.getOne(id);
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setDueDate(task.getDueDate());
        return taskDTO;
    }

    @Override
    public void addTask(TaskDTO taskDTO){
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        tasksJPArepo.save(task);
    }

    @Override
    public void deleteTask(int id) {
        tasksJPArepo.deleteById(id);
    }

    @Override
    public void editTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        tasksJPArepo.save(task);
    }

    @Override
    public void addSubTask(SubTaskDTO subTaskDTO) {
        SubTask subTask = new SubTask();
        subTask.setId(subTaskDTO.getId());
        subTask.setTitle(subTaskDTO.getTitle());
        subTask.setDescription(subTaskDTO.getDescription());

        TaskDTO taskDTO = subTaskDTO.getParent();
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());

        subTask.setParent(task);

        subTasksJAPrepo.save(subTask);
    }

    @Override
    public List<SubTaskDTO> getSubtasks(){
        return subTasksJAPrepo.findAll().stream().map(subTask ->{
            SubTaskDTO subTaskDTO = new SubTaskDTO();
            subTaskDTO.setId(subTask.getId());
            subTaskDTO.setTitle(subTask.getTitle());
            subTaskDTO.setDescription(subTask.getDescription());

            Task task = subTask.getParent();
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setTitle(task.getTitle());
            taskDTO.setDescription(task.getDescription());
            taskDTO.setDueDate(task.getDueDate());

            subTaskDTO.setParent(taskDTO);
            return subTaskDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<SubTaskDTO> getSubTasksOfParent(int parentId) {
        List<SubTaskDTO> result = new ArrayList<>();
        for (SubTask subTask : subTasksJAPrepo.findAll()){
            if (subTask.getParent().getId() == parentId){
                SubTaskDTO subTaskDTO = new SubTaskDTO();
                subTaskDTO.setId(subTask.getId());
                subTaskDTO.setTitle(subTask.getTitle());
                subTaskDTO.setDescription(subTask.getDescription());

                Task task = subTask.getParent();
                TaskDTO taskDTO = new TaskDTO();
                taskDTO.setId(task.getId());
                taskDTO.setTitle(task.getTitle());
                taskDTO.setDescription(task.getDescription());
                taskDTO.setDueDate(task.getDueDate());

                subTaskDTO.setParent(taskDTO);

                result.add(subTaskDTO);
            }
        }
        return result;
    }
}
