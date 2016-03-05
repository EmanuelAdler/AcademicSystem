package publications;

import java.util.ArrayList;
import users.*;

public class Publication {
	protected ArrayList<User> authors;
	protected String title;
	protected String conference;
	protected int year;
	protected String project;
	protected boolean isProject;
	
	//THIS CONSTRUCTOR IS CALLED WHEN THERE IS A PROJECT TO BE ADDED
	public Publication(ArrayList<User> authors, String title, String conference, int year, String project) {
		super();
		this.authors = authors;
		this.title = title;
		this.conference = conference;
		this.year = year;
		this.project = project;
		this.isProject = true;
	}
	
	//THIS CONSTRUCTOR IS CALLED WHEN THERE ISN'T A PROJECT
	public Publication(ArrayList<User> authors, String title, String conference, int year) {
		super();
		this.authors = authors;
		this.title = title;
		this.conference = conference;
		this.year = year;
		this.isProject = false;
	}

	public ArrayList<User> getAuthors() {
		return authors;
	}
	public void setAuthors(User author) {
		this.authors.add(author);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getConference() {
		return conference;
	}
	public void setConference(String conference) {
		this.conference = conference;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public boolean isProject() {
		return isProject;
	}
	public void setIsProject(boolean isProject) {
		this.isProject = isProject;
	}
	

}