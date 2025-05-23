package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String showTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks"; // loads templates/tasks.html
    }

    @PostMapping("/")
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable long id) {
       taskService.deleteTask(id);
        return "redirect:/"; // loads templates/tasks.html
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable long id) {
        taskService.toggleTask(id);
        return "redirect:/"; // loads templates/tasks.html
    }


}
