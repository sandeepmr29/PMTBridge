package com.bridge.bridgepmt.model;

import java.util.ArrayList;


public class ListOfProjectScreenReturns 
{
	
	ArrayList<ProjectDetails> projects;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	String status;

	public ArrayList<ProjectDetails> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<ProjectDetails> projects) {
		this.projects = projects;
	}
	
}
