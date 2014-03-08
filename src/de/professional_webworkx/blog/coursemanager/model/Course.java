package de.professional_webworkx.blog.coursemanager.model;

public class Course {

	// will be later the unique primary key
	private long id;
	private String name;
	private String description;
	private int maxParticipants;
	private double price;
	
	public Course() {
		
	}

	public Course(String name, String description, int maxParticipants,
			double price) {
		super();
		this.name = name;
		this.description = description;
		this.maxParticipants = maxParticipants;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Course: " + name + ", max Participants: " + maxParticipants + ", Price: " + price + " EUR";
	}
}
