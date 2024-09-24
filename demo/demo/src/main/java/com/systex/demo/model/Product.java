package com.systex.demo.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Qualifier("dog")
public class Product implements Serializable{

	private int id;
	private String name;
	private String description;
	
	public Product() {
		super();
	}
	
	@PostConstruct
	public void init() {
		this.id = 10001;
		this.name = "iPhone Pro Max";
		this.description = "Will be very expensive";
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && id == other.id && Objects.equals(name, other.name);
	}
	
	
}
