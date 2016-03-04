package main;
import java.util.ArrayList;

import users.*;

public class Project {
	protected String title;
	protected String objective;
	protected String description;
	protected String professor;
	protected String fundingAgency;
	protected Double financedAmount;
	protected String startDate;
	protected String endDate;
	protected ArrayList<User> team;
	protected boolean isDone;
	protected String status;
	
	
	
	public Project(String title, String objective, String description, String professor, String fundingAgency, Double financedAmount, String startDate, String endDate, boolean isDone, String status){
		this.title = title;
		this.objective = objective;
		this.description = description;
		this.professor = professor;
		this.fundingAgency = fundingAgency;
		this.financedAmount = financedAmount;
		this.isDone = isDone;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.team = new ArrayList<User>();
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProfesor() {
		return professor;
	}
	public void setProfesor(String profesor) {
		this.professor = profesor;
	}
	public String getFundingAgency() {
		return fundingAgency;
	}
	public void setFundingAgency(String fundingAgency) {
		this.fundingAgency = fundingAgency;
	}
	public Double getFinancedAmount() {
		return financedAmount;
	}
	public void setFinancedAmount(Double financedAmount) {
		this.financedAmount = financedAmount;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public ArrayList<User> getTeam() {
		return team;
	}
	public void setTeam(User newUser) {
		this.team.add(newUser);
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
