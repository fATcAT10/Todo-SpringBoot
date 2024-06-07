package com.xeon.ToDo;

import com.xeon.ToDo.entity.Todo;
import com.xeon.ToDo.entity.User;
import com.xeon.ToDo.repository.TodoRepository;
import com.xeon.ToDo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
