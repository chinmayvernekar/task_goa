package com.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.movies.model.Movies;
import com.movies.repo.MoviesRepo;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	MoviesRepo moviesRepo;

	//// Read the JSON file and insert the record in Postgre Sql
	@Override
	public void readJsonAndSaveDetailsToDatabase(List<Movies> movies) {
		moviesRepo.saveAll(movies);
	}

	@Override
	public ResponseEntity<?> getAllMovies() throws JsonMappingException, JsonProcessingException {

		try {

			return ResponseEntity.ok(moviesRepo.findAll());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}

}
