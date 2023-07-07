package com.example.servingwebcontent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

@SpringBootApplication
public class TaskManagerWebContentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerWebContentApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TaskRepository repository) {
		return (args) -> {
			// save a few tasks
			
			LocalDate localDate = LocalDate.now();
			
			repository.save(new Task("Breakfast", localDate, true));
			repository.save(new Task("Lunch", localDate, false));
			repository.save(new Task("Dinner", localDate, false));
		};
	}

}
