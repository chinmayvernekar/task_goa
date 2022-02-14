package com.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.movies.services.MoviesService;

@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

	@Autowired
	MoviesService moviesService;
	
	//Get All the movies present in db
	@RequestMapping(value = "/get-all-movies")
	public ResponseEntity<?> getAllMovies() throws JsonMappingException, JsonProcessingException {

		return moviesService.getAllMovies();
	}

}
