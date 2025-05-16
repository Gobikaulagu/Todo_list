package com.todo.controller;

import com.todo.model.Todo;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        model.addAttribute("newTodo", new Todo());
        return "todos";
    }

    @GetMapping("/pending")
    public String listPendingTodos(Model model) {
        model.addAttribute("todos", todoService.getPendingTodos());
        model.addAttribute("newTodo", new Todo());
        return "todos";
    }

    @GetMapping("/completed")
    public String listCompletedTodos(Model model) {
        model.addAttribute("todos", todoService.getCompletedTodos());
        model.addAttribute("newTodo", new Todo());
        return "todos";
    }

    @PostMapping
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo.getTitle(), todo.getDescription());
        return "redirect:/todos";
    }

    @PostMapping("/{id}/complete")
    public String markAsCompleted(@PathVariable int id) {
        todoService.markAsCompleted(id);
        return "redirect:/todos";
    }

    @PostMapping("/{id}/delete")
    public String deleteTodo(@PathVariable int id) {
        todoService.removeTodo(id);
        return "redirect:/todos";
    }

    @PostMapping("/{id}/update")
    public String updateTodo(@PathVariable int id, @ModelAttribute Todo todo) {
        todoService.updateTodo(id, todo.getTitle(), todo.getDescription());
        return "redirect:/todos";
    }
} 