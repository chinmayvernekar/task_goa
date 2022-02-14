package com.movies.repo;

import org.springframework.data.repository.CrudRepository;

import com.movies.model.Category;

public interface CategoryRepo extends CrudRepository<Category, Integer>{

}
