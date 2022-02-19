package com.movies;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.movies.model.Movies;
import com.movies.repo.MoviesRepo;
import com.movies.services.MoviesService;

@SpringBootApplication
public class TaskMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskMoviesApplication.class, args);
	}

	@Autowired
	MoviesRepo moviesRepo;

	@Bean
	CommandLineRunner runner(MoviesService movies) {
		return args -> {
			// read and write data to database
			if (moviesRepo.checkDataExist() == 0) {
				ObjectMapper mapper = new ObjectMapper();
				TypeReference<List<Movies>> typeReference = new TypeReference<List<Movies>>() {
				};

				InputStream inputStream = TypeReference.class.getResourceAsStream("/json/movies.json");
			
				try {
					List<Movies> moviesInsert = mapper.readValue(inputStream, typeReference);
					movies.readJsonAndSaveDetailsToDatabase(moviesInsert);
					System.out.println("Details Saved");
				} catch (IOException e) {
					System.out.println("Unable to save details " + e);
				}

			} else {

				System.out.println("Data Already Exist");
			}

		};
	}
}
