package com.xeon.ToDo.controllers;

import com.xeon.ToDo.entity.Todo;
import com.xeon.ToDo.entity.User;
import com.xeon.ToDo.repository.TodoRepository;
import com.xeon.ToDo.repository.UserRepository;
import com.xeon.ToDo.request.AddTodoRequest;
import com.xeon.ToDo.request.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
     private UserRepository userRepository;
    @Autowired
     private TodoRepository todoRepository;

//    public UserController(UserRepository userRepository, TodoRepository todoRepository) {
//        this.userRepository = userRepository;
//        this.todoRepository = todoRepository;
//    }
    @GetMapping("{userId}")
    public User getUserById(@PathVariable("userId") Long uId){
        return userRepository.findById(uId).orElseThrow(()-> new NoSuchElementException());
    }

    @PostMapping
    public User addUser(@RequestBody AddUserRequest userRequest){
        User user=new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }

    @PostMapping("{userId}/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest){
        User user=userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());
        Todo todo=new Todo();
        todo.setContent(todoRequest.getContent());
        user.getTodoList().add(todo);
        userRepository.save(user);
    }

    @PostMapping("todos/{todoId}")
    public void toggleTodoCompleted(@PathVariable Long todoId){
        Todo todo=todoRepository.findById(todoId).orElseThrow(()->new NoSuchElementException());
        todo.setCompleted(!todo.getCompleted());
        todoRepository.save(todo);
    }

    @DeleteMapping("{userId}/todos/{todoId}")
    public void deleteTodo(@PathVariable Long userId,@PathVariable Long todoId){
        User user=userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());
        Todo todo=todoRepository.findById(todoId).orElseThrow(()->new NoSuchElementException());
        user.getTodoList().remove(todo);
        todoRepository.delete(todo);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable Long userId){
        User user=userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());
        userRepository.delete(user);
    }

}
