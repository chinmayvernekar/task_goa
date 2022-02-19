package com.movies.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.movies.model.Movies;

import dto.MovieResponseDto;

@Repository
public interface MoviesRepo extends JpaRepository<Movies, Integer> {

	@Query("select count(title) from Movies")
	public Integer checkDataExist();

	// Sort By Release Date And Filter By Language or genere
	@Query("SELECT u FROM Movies u JOIN u.catogery r WHERE r.language LIKE %?1% OR r.genere LIKE %?2% ORDER BY release_date desc")
	public List<Movies> sortByReleaseDateAndFilterByCategories(String language, String genere,Pageable pePageable, Integer offset, Integer pageSize);
	
	// Sort By Length And Filter By Language or genere
	@Query("SELECT u FROM Movies u JOIN u.catogery r WHERE r.language LIKE %?1% OR r.genere LIKE %?2% ORDER BY movie_length desc")
	public List<Movies> sortByMovieLengthAndFilterByCategories(String language, String genere, Pageable pePageable, Integer offset,
			Integer pageSize);

}
