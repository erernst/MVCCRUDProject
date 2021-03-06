package com.erernst.emaze.data;

public class Emaze {
	@Override
	public String toString() {
		return "Emaze [name=" + name + ", state=" + state + ", course=" + course + ", city=" + city + "]";
	}
	private int id;
	private String name;
	private String state;
	private String course;
	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Emaze(int id, String name, String city, String state, String course) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.course = course;
		this.city = city;
	}

}
