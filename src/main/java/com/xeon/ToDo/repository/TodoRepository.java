package com.xeon.ToDo.repository;

import com.xeon.ToDo.entity.Todo;
import com.xeon.ToDo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{

}
