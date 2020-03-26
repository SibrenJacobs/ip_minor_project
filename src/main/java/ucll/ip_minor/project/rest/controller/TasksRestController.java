package ucll.ip_minor.project.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ucll.ip_minor.project.model.DTO.SubTaskDTO;
import ucll.ip_minor.project.model.DTO.TaskDTO;
import ucll.ip_minor.project.model.service.TasksService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apiTasks")
public class TasksRestController {
    private final TasksService tasksService;

    @Autowired
    public TasksRestController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    @ResponseBody
    public List<TaskDTO> getTasks(){
        return tasksService.getTasks();
    }

    @PostMapping
    public void addTask(@RequestBody @Valid TaskDTO task){
        tasksService.addTask(task);
    }

    @PutMapping
    public void editTask(@RequestBody @Valid TaskDTO task){
        tasksService.editTask(task);
    }

    @GetMapping("/{id}")
    public List<SubTaskDTO> getTaskDetail(@PathVariable int id){
        return tasksService.getSubTasksOfParent(id);
    }

    @PostMapping("/{id}")
    public void addSubTask(@PathVariable int id,@RequestBody @Valid SubTaskDTO subTask){
        subTask.setParent(tasksService.getTask(id));
        tasksService.addSubTask(subTask);
    }
}
