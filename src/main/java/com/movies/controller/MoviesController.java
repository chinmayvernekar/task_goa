package com.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.movies.model.Category;
import com.movies.services.MoviesService;

@RestController
@RequestMapping(value = "/movies")
public class MoviesController {

	@Autowired
	MoviesService moviesService;

	@RequestMapping(value = "/sort-by-movie-length")
	public ResponseEntity<?> filterByCatogeriesAndSortByMovieLength(@RequestParam(required = false) String language,
			@RequestParam(required = false) String genere, @RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "10") Integer pageSize, Category category)
			throws JsonMappingException, JsonProcessingException {

		return moviesService.filterByCatogeriesAndSortByMovieLength(language,genere,offset, pageSize);
	}
	
	@RequestMapping(value = "/sort-by-release-date")
	public ResponseEntity<?> filterByCatogeriesAndSortByReleaseDate(@RequestParam(required = false) String language,
			@RequestParam(required = false) String genere, @RequestParam(defaultValue = "0") Integer offset,
			@RequestParam(defaultValue = "10") Integer pageSize, Category category)
			throws JsonMappingException, JsonProcessingException {

		return moviesService.filterByCatogeriesAndSortByReleaseDate(language,genere,offset, pageSize);
	}
}
