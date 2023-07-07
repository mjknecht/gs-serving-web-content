package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.servingwebcontent.Task;
import com.example.servingwebcontent.TaskRepository;

import java.util.List;

@Controller
public class TaskController {
    private final TaskRepository repository;

    @Autowired
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }
		
    @GetMapping("/tasks")
    public String tasks(Model model) {
        List<Task> tasks = (List)repository.findAll();
        model.addAttribute("tasks", tasks);
        return "task-list";
	}

    @GetMapping("/createGet")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/createPost")
    public String createTask(@ModelAttribute("task") Task task) {
    	this.repository.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Task task = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id: " + id));
        model.addAttribute("task", task);
        return "task-form";
    }

    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable("id") Long id, @ModelAttribute("task") Task task) {
        task.setId(id);
        this.repository.save(task);
        return "redirect:/tasks";
    }
    
    @PostMapping("/update")
    public String update(@PathVariable("id") Long id, @PathVariable("complete") boolean complete, Model model) {
        Task task = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + id));
        task.setComplete(true);
        model.addAttribute("task", task);
        this.repository.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Task task = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task Id: " + id));
        this.repository.delete(task);
        return "redirect:/tasks";
    }

}
