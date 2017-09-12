package com.project.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

  

@Entity
public class UserProject implements Serializable {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROJECT_ID")
	private int userProjectId;
	
	@Column(name="PROJECT_FILE")
	private String userProjectFile;
	
	@Column(name="PROJECT_TITLE", nullable=false, length=100)
	private String userProjectTitle;
	
	@Column(name="PROJECT_DESCRIPTION", nullable=false)
	private String userProjectDescription;
	
	@Column(name="PROJECT_TAG")
	private String userProjectTag;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	private Category category;
	
//	@ManyToOne
//	List<ProjectOfUser> projectOfUser = new ArrayList();




	public String getUserProjectFile() {
		return userProjectFile;
	}

	public int getUserProjectId() {
		return userProjectId;
	}

	public void setUserProjectId(int userProjectId) {
		this.userProjectId = userProjectId;
	}

	public void setUserProjectFile(String userProjectFile) {
		this.userProjectFile = userProjectFile;
	}

	public String getUserProjectTitle() {
		return userProjectTitle;
	}

	public void setUserProjectTitle(String userProjectTitle) {
		this.userProjectTitle = userProjectTitle;
	}

	public String getUserProjectDescription() {
		return userProjectDescription;
	}

	public void setUserProjectDescription(String userProjectDescription) {
		this.userProjectDescription = userProjectDescription;
	}

	public String getUserProjectTag() {
		return userProjectTag;
	}

	public void setUserProjectTag(String userProjectTag) {
		this.userProjectTag = userProjectTag;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//	public List<ProjectOfUser> getProjectOfUser() {
//		return projectOfUser;
//	}
//
//	public void setProjectOfUser(List<ProjectOfUser> projectOfUser) {
//		this.projectOfUser = projectOfUser;
//	}

	
	

	
	

	
}
