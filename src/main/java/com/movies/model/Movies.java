package com.movies.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movie_id;

	private String title;

	@Column(length = 10485760)
	private String description;

	@Column(length = 10485760)
	private String featured_image;

	private int movie_length;

	private Date release_date;

	@OneToMany(targetEntity = Category.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "relationship", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
//	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
//	@JoinColumn(name = "category_id", referencedColumnName = "movie_id")
	private Set<Category> catogery = new HashSet<>();

	public Movies() {

	}

	public Movies(int movie_id, String title, String description, String featured_image, int movie_length,
			Date release_date, Set<Category> catogery) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.description = description;
		this.featured_image = featured_image;
		this.movie_length = movie_length;
		this.release_date = release_date;
		this.catogery = catogery;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFeatured_image() {
		return featured_image;
	}

	public void setFeatured_image(String featured_image) {
		this.featured_image = featured_image;
	}

	public int getMovie_length() {
		return movie_length;
	}

	public void setMovie_length(int movie_length) {
		this.movie_length = movie_length;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

//	public List<Category> getCatogery() {
//		return catogery;
//	}
//
//	public void setCatogery(List<Category> catogery) {
//		this.catogery = catogery;
//	}

	@Override
	public String toString() {
		return "Movies [movie_id=" + movie_id + ", title=" + title + ", description=" + description
				+ ", featured_image=" + featured_image + ", movie_length=" + movie_length + ", release_date="
				+ release_date + ", catogery=" + catogery + "]";
	}

	public Set<Category> getCatogery() {
		return catogery;
	}

	public void setCatogery(Set<Category> catogery) {
		this.catogery = catogery;
	}

}
