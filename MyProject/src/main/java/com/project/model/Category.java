package com.project.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Category_ID")
	private int categoryId;
	
	@Column(name="Category_Name", nullable=false)
	private String categoryName;
	
	@OneToMany(mappedBy="category")
	private List<UserProject> userProjectList;
	
	

	public List<UserProject> getUserProjectList() {
		return userProjectList;
	}

	public void setUserProjectList(List<UserProject> userProjectList) {
		this.userProjectList = userProjectList;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
