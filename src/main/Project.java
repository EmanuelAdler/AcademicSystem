package main;
import java.util.ArrayList;
import users.*;
import publications.Publication;

public class Project {
	protected String title;
	protected String objective;
	protected String description;
	protected ArrayList<String> professorList;
	protected String fundingAgency;
	protected Double financedAmount;
	protected String startDate;
	protected String endDate;
	protected ArrayList<User> team;
	protected boolean isDone;
	protected String status;
	protected ArrayList<Publication> publications;

	
	
	public Project(String title, String objective, String description, String fundingAgency, Double financedAmount, String startDate, String endDate, boolean isDone, String status){
		this.title = title;
		this.objective = objective;
		this.description = description;
		this.professorList = new ArrayList<String>();
		this.fundingAgency = fundingAgency;
		this.financedAmount = financedAmount;
		this.isDone = isDone;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.team = new ArrayList<User>();
	}
	
	public void allocateUser(User newUser){
		if(this.status != "em andamento"){
			if(newUser instanceof Professor){
				if(this.team.size() == 0){
					/*
					 * Um projeto precisa de no minimo um professor.
					 * Verifica se o novo usuário é um professor.
					 */
					if(newUser instanceof Professor){
						this.team.add(newUser);
						this.professorList.add(newUser.getName());
					}
					else{
						System.out.println("Este projeto não possui um professor cadastrado");
					}
				}
				else{
					/*
					 * Verifica se o usuário já está no projeto.
					 */
					for(int i = 0; i < this.team.size(); i++){
						if(this.team.get(i) == newUser){
							System.out.println("Este usuário já está no projeto");
							break;
						}
						else if(this.team.get(i) != newUser && i == this.team.size()-1){
							if(newUser instanceof Student){
								/*
								 * Um estudante não pode estar em mais de dois projetos "em andamento"
								 */
								int quantity = 0;
								for(i = 0; i < newUser.getProjects().size(); i++){
									if(newUser.getProjects().get(i).getStatus() == "em andamento"){
										quantity++;
										if(quantity == 2)
											System.out.println("Este aluno não pode participar deste projeto");
										else if(quantity < 2 && i == newUser.getProjects().size()-1)
											this.team.add(newUser);
									}
									else{
										this.team.add(newUser);
									}
								}
							}
						}
					}
					
				}
			}
		}
		else
			System.out.println("Este projeto já está em andamento");
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
	public ArrayList<String> getProfesor() {
		return professorList;
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
	public ArrayList<User> getUsers() {
		return team;
	}
	public String toString()
	{
		return title;
	}
	public ArrayList<Publication> getPublications() {
		return publications;
	}
}
