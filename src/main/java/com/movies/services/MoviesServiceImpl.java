package com.movies.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.movies.model.Movies;
import com.movies.repo.CategoryRepo;
import com.movies.repo.MoviesRepo;

@Service
public class MoviesServiceImpl implements MoviesService {

	/*
	 * 
	 * Filter by language Filter by Genre Sort by Length Sort by release date
	 */

	@Autowired
	private MoviesRepo moviesRepo;

	@Autowired
	CategoryRepo categoryRepo;

	//// Read the JSON file and insert the record in Postgre Sql
	@Override
	public void readJsonAndSaveDetailsToDatabase(List<Movies> movies) {
		moviesRepo.saveAll(movies);
	}
	
	//Filter by Category And Sort By Movie Length
	public ResponseEntity<?> filterByCatogeriesAndSortByMovieLength(String language, String genere, Integer offset, Integer pageSize)
			throws JsonMappingException, JsonProcessingException {

		List<Movies> movies = null;
		try {
			Pageable pageable = PageRequest.of(offset, pageSize);
			return ResponseEntity
					.ok(moviesRepo.sortByMovieLengthAndFilterByCategories(language, genere, pageable, offset, pageSize));
		} catch (Exception e) {

		}

		return ResponseEntity.ok(movies);

	}


	//Filter by Category And Sort By Release Date
	@Override
	public ResponseEntity<?> filterByCatogeriesAndSortByReleaseDate(String language, String genere, Integer offset,
			Integer pageSize) throws JsonMappingException, JsonProcessingException {
		List<Movies> movies = null;
		try {
			Pageable pageable = PageRequest.of(offset, pageSize);
			return ResponseEntity
					.ok(moviesRepo.sortByReleaseDateAndFilterByCategories(language, genere, pageable, offset, pageSize));
		} catch (Exception e) {

		}

		return ResponseEntity.ok(movies);

	}

}
