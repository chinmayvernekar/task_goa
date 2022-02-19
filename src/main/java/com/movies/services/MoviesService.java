package com.movies.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.movies.model.Movies;

public interface MoviesService {

	// Read the JSON file and insert the record in Postgre Sql
	public void readJsonAndSaveDetailsToDatabase(List<Movies> movies);

	// Filter and Sorting Working Together
	public ResponseEntity<?> filterByCatogeriesAndSortByMovieLength(String language, String genere,Integer offset, Integer pageSize)
			throws JsonMappingException, JsonProcessingException;
	
	// Filter and Sorting Working Together
		public ResponseEntity<?> filterByCatogeriesAndSortByReleaseDate(String language, String genere,Integer offset, Integer pageSize)
				throws JsonMappingException, JsonProcessingException;

	
}
