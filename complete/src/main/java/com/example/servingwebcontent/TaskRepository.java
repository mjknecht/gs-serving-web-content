package com.example.servingwebcontent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

	List<Long> findByDescription(String keyString);

	Task findById(long id);
}
