package users;

import main.Project;
import publications.Publication;
import java.util.ArrayList;

public class User {
	protected String name;
	protected String email;
	protected ArrayList<Project> projects;
	protected ArrayList<Publication> publications;
	
	public User(String name, String email){
		this.name = name;
		this.email = email;
		this.projects = new ArrayList<Project>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Project> getProjects() {
		return projects;
	}
	public void setProjects(Project newProject) {
		this.projects.add(newProject);
	}
	public ArrayList<Publication> getPublication() {
		return publications;
	}
	public void setPublication(Publication newPublication) {
		this.publications.add(newPublication);
	}
	public String toString()
	{
		return name;
	}
	
	
}
