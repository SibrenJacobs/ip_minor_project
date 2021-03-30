package ucll.ip_minor.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ucll.ip_minor.project.model.DTO.SubTaskDTO;
import ucll.ip_minor.project.model.DTO.TaskDTO;
import ucll.ip_minor.project.model.service.TasksService;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    public String getTasks(Model model){
        model.addAttribute("tasks", tasksService.getTasks());
        return "tasksOverview";
    }

    @GetMapping("/{id}")
    public String getTaskDetail(@PathVariable int id,Model model){
        model.addAttribute("task",tasksService.getTask(id));
        model.addAttribute("subTasks",tasksService.getSubTasksOfParent(id));
        return "taskDetail";
    }

    @GetMapping("/new")
    public String getNewTaskForm(Model model){
        model.addAttribute("task",new TaskDTO());
        return "newTaskForm";
    }

    @PostMapping("/new")
    public String addTask(@ModelAttribute("task") @Valid TaskDTO task, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "newTaskForm";
        }
        tasksService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String getEditTaskForm(@PathVariable int id,Model model){
        model.addAttribute("task",tasksService.getTask(id));
        return "editTaskForm";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable int id,@ModelAttribute TaskDTO task){
        tasksService.editTask(task);
        return "redirect:/tasks/" + id;
    }

    @GetMapping("/{parentId}/sub/create")
    public String getNewSubTaskForm(@PathVariable int parentId,Model model){
        model.addAttribute("parentId",parentId);
        model.addAttribute("subTask",new SubTaskDTO());
        return "newSubTaskForm";
    }

    @PostMapping("/{parentId}/sub/create")
    public String addSubTask(@PathVariable int parentId,@ModelAttribute("subTask") SubTaskDTO subTask){
        subTask.setParent(tasksService.getTask(parentId));
        tasksService.addSubTask(subTask);
        return "redirect:/tasks/" + parentId;
    }
}
