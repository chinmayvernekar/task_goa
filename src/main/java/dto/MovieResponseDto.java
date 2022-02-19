package dto;

import javax.persistence.Column;

public class MovieResponseDto {
	
	private String title;

	@Column(length = 10485760)
	private String description;

	@Column(length = 10485760)
	private String featured_image;
	
	private String language;

	public MovieResponseDto(String title, String description, String featured_image, String language) {
		super();
		this.title = title;
		this.description = description;
		this.featured_image = featured_image;
		this.language = language;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "MovieResponseDto [title=" + title + ", description=" + description + ", featured_image="
				+ featured_image + ", language=" + language + "]";
	}
	
	
	
}
