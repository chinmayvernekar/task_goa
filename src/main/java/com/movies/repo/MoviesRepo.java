package com.movies.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.movies.model.Movies;

public interface MoviesRepo extends CrudRepository<Movies, Integer>{
	
	@Query("select count(title) from Movies")
	public Integer checkDataExist();
}
