package com.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movies.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
