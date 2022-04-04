package com.thunder.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@Deprecated
@ApiModel(description="All details about the user.")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	@Size(min=2,message = "Name should have at least 2 characters")
	@ApiModelProperty(notes="Name should have at least 2 characters")
	private String name;
	
	@NotNull
	@Past
	@ApiModelProperty(notes="Birth date should be in the past")
	private Date birthDate;
	
	@OneToMany
	private List<Post> posts;
	
	protected User() {
		
	}

	public User(Integer id, 
			@NotNull @Size(min=2,message = "Name should have at least 2 characters")String name, 
			@NotNull @Past Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	

}
