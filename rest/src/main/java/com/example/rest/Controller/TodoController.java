
package com.example.rest.Controller;

import com.example.rest.Model.Task;
import com.example.rest.Repository.TodoReposiotory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @Autowired
    private TodoReposiotory todoReposiotory;
    
    @GetMapping (value = "/")
    public String holaMundo(){
        return "Hola mundo";
    }
    
    @GetMapping (value = "/tasks")
    public List <Task> getTasks(){
        return todoReposiotory.findAll();
    }
    
    @PostMapping (value = "/savetask")
    public String saveTask(@RequestBody Task task){
        todoReposiotory.save(task);
        return "Save Task";
    }
    
    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        Task updatedTask = todoReposiotory.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        todoReposiotory.save(updatedTask);
        return "Updated Task";
    }
    
    @DeleteMapping(value = "delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deleteTask = todoReposiotory.findById(id).get();
        todoReposiotory.delete(deleteTask);
        return "Deleted task";
    }
}
