package com.example.demo.seeder;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDb(TodoRepository repo){
        return args -> {
            log.info("Seeding " + repo.save(new Todo("Let the dogs out", "Dogs gotta be out", true)));
            log.info("Seeding " + repo.save(new Todo("Party hard", "Humans gotta party", false)));
        };
    }

}
