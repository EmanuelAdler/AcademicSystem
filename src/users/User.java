package users;

import main.Project;
import java.util.ArrayList;

public class User {
	protected String name;
	protected String email;
	protected ArrayList<Project> projects;
	
	
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
	
	
}
