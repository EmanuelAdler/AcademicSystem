package main;
import java.util.ArrayList;
import main.Project;
import main.Utilities;
import publications.Publication;
import users.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Project> projectList = new ArrayList<Project>();
		ArrayList<Publication> publication = new ArrayList<Publication>();
		Utilities utility = new Utilities();
		
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Escolha uma opcao:");
		System.out.println("1. Criar usuario");
		System.out.println("2. Projetos");
		System.out.println("3. Criar publicacao");
		System.out.println("4. Consultas");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		if(option == 1){
			User newUser = userCreate();
			userList.add(newUser);
		}
		else if(option == 2)
			projectList = projectsMenu(projectList);
		else if(option == 3){
			Publication newPublication = createPublication();
		}
		else if(option == 4)
			consultation(projectList, userList, utility);
		
		/*
		//consulta por colaborador
		utility.consultCollaborator(user, "Baldoino");
		//consulta por projeto	
		utility.consultProject(project, "Projeto2");
		*/
		
	}
	
	public static User userCreate(){
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Escolha o tipo de usuario");
		System.out.println("1. Professor");
		System.out.println("2. Estudante");
		
		Student newUser = new Student(null, null, null);
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		if(option == 1)
			createProfessor();
		else if(option == 2){
			newUser = createStudent();
		}
		
		return newUser;
	}
	public static Professor createProfessor(){
		Professor newProfessor = new Professor(null, null);
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Nome:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		newProfessor.setName(name);
		newProfessor.setEmail(email);
		
		return newProfessor;
	}
	public static Student createStudent(){
		Student newUser = new Student(null, null, null);
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Escolha o tipo de estudante");
		System.out.println("1. Graduacao");
		System.out.println("2. Mestrado");
		System.out.println("3. Doutorado");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		if(option == 1){
			newUser.setType("graduacao");
			newUser = createStudentGeneral(newUser);
		}
		else if(option == 2){
			newUser.setType("mestrado");
			newUser = createStudentGeneral(newUser);
		}
		else if(option == 3){
			newUser.setType("doutorado");
			newUser = createStudentGeneral(newUser);
		}
		
		return newUser;
		
	}
	public static Student createStudentGeneral(Student newUser){
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Nome:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		newUser.setName(name);
		newUser.setEmail(email);
		
		return newUser;
		
	}
	public static ArrayList<Project> projectsMenu(ArrayList<Project> projectList){
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Escolha uma opcao:");
		System.out.println("1. Criar projeto");
		System.out.println("2. Adicionar usuario a um projeto");
		System.out.println("3. Adicionar publicacao a um projeto");
		
		Project newProject = new Project(null, null, null, null, 0.0, null, null, false, null);
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		if(option == 1){
			newProject = createProject();
			projectList.add(newProject);
		}
		else if(option == 2)
			addUserToProject(projectList);
		else if(option == 3)
			addPublicationToProject(projectList);
		
		return projectList;
	}
	public static Publication createPublication(){
		ArrayList<User> authorsList = new ArrayList<User>();
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Criacao de Publicacao");
		System.out.println("Titulo:");
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		System.out.println("Conferencia");
		String conference = sc.nextLine();
		System.out.println("Ano:");
		int year = sc.nextInt();
		Publication newPublication = new Publication(authorsList, title, conference, year, "");
		
		return newPublication;
	}
	public static void consultation(ArrayList<Project> projectList, ArrayList<User> userList, Utilities utility){
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Escolha uma opcao:");
		System.out.println("1. Consulta por colaborador");
		System.out.println("2. Consulta por projeto");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		if(option == 1)
			contributors(userList, utility);
		else if(option == 2)
			projects(projectList, utility);
		
	}
	public static Project createProject(){
		Project newProject = new Project(null, null, null, null, 0.0, null, null, false, null);
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Titulo:");
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		System.out.println("Objetivo:");
		String objective = sc.nextLine();
		System.out.println("Descricao:");
		String description = sc.nextLine();
		System.out.println("Agencia financiadora:");
		String fundingAgency = sc.nextLine();
		System.out.println("Valor financiado:");
		double financedAmount = sc.nextDouble();
		System.out.println("Data de inicio:");
		String startDate = sc.nextLine();
		System.out.println("Data de termino:");
		String endDate = sc.nextLine();
		
		newProject.setTitle(title);
		newProject.setObjective(objective);
		newProject.setDescription(description);
		newProject.setFundingAgency(fundingAgency);
		newProject.setFinancedAmount(financedAmount);
		newProject.setStartDate(startDate);
		newProject.setEndDate(endDate);
		newProject.setDone(false);
		newProject.setStatus("em elaboracao");
		
		return newProject;
		
	}
	public static void addUserToProject(ArrayList<Project> projectlist){
		
	}
	public static void addPublicationToProject(ArrayList<Project> projectList){
		
	}
	public static void contributors(ArrayList<User> userList, Utilities utility){
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Digite o nome do colaborador:");
		Scanner sc = new Scanner(System.in);
		String collaboratorName = sc.nextLine();
		utility.consultCollaborator(userList, collaboratorName);
	}
	public static void projects(ArrayList<Project> projectList, Utilities utility){
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Digite o titulo do projeto:");
		Scanner sc = new Scanner(System.in);
		String projectName = sc.nextLine();
		utility.consultProject(projectList, projectName);
	}
}