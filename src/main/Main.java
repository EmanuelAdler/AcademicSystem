package main;
import java.util.ArrayList;
import java.util.InputMismatchException;

import main.Project;
import main.Utilities;
import publications.Publication;
import users.*;
import java.util.Scanner;

public class Main {
	static ArrayList<User> userList = new ArrayList<User>();
	static ArrayList<Project> projectList = new ArrayList<Project>();
	static ArrayList<Publication> publicationList = new ArrayList<Publication>();
	static Utilities utility = new Utilities();
	
	public static void main(String[] args) {
		
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Escolha uma opcao:");
		System.out.println("1. Criar usuario");
		System.out.println("2. Projetos");
		System.out.println("3. Criar publicacao");
		System.out.println("4. Consultas");
		System.out.println("5. Sair");
		
		Scanner sc = new Scanner(System.in);
		try{
			int option = sc.nextInt();
			
			if(option == 1){
				User newUser = userCreate();
				userList.add(newUser);
				main(args);
			}
			else if(option == 2){
				projectList = projectsMenu(projectList);
				if(projectList.get(0).getUsers().size() > 0)
				projectList.get(0).getUsers().get(0).getName();
				main(args);
			}
			else if(option == 3){
				Publication newPublication = createPublication();
				main(args);
			}
			else if(option == 4){
				consultation(projectList, userList, utility);
				main(args);
			}
			else if(option == 5)
				System.exit(0);
			else{
				System.out.println("Insira uma opção válida");
				main(null);
			}
		}
		catch(InputMismatchException e){
			System.out.println("Insira uma entrada válida");
			main(null);
		}
		
	}
	
	public static User userCreate() throws InputMismatchException, NumberFormatException{
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
	public static Professor createProfessor() throws InputMismatchException, NumberFormatException{
		Professor newProfessor = new Professor(null, null);
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Nome:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		newProfessor.setName(name);
		newProfessor.setEmail(email);
		userList.add(newProfessor);
		return newProfessor;
	}
	public static Student createStudent() throws InputMismatchException, NumberFormatException{
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
			userList.add(newUser);
		}
		else if(option == 2){
			newUser.setType("mestrado");
			newUser = createStudentGeneral(newUser);
			userList.add(newUser);
		}
		else if(option == 3){
			newUser.setType("doutorado");
			newUser = createStudentGeneral(newUser);
			userList.add(newUser);
		}
		
		return newUser;
		
	}
	public static Student createStudentGeneral(Student newUser) throws InputMismatchException, NumberFormatException{
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
	public static ArrayList<Project> projectsMenu(ArrayList<Project> projectList) throws InputMismatchException, NumberFormatException{
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
		else if(option == 2){
			String aux = sc.nextLine();
			System.out.println("Insira o nome do projeto");
			String projectName = sc.nextLine();
			System.out.println("Insira o nome do usuÃ¡rio");
			String userName = sc.nextLine();
			projectList = addUserToProject(projectList, userList, projectName, userName);
		}
		else if(option == 3){
			String aux = sc.nextLine();
			System.out.println("Insira o nome do projeto");
			String projectName = sc.nextLine();
			System.out.println("Insira o titulo da publicacao");
			String publicationName = sc.nextLine();
			projectList = addPublicationToProject(projectList, publicationName, projectName);
		}
		
		return projectList;
	}
	public static Publication createPublication() throws InputMismatchException, NumberFormatException{
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
	public static void consultation(ArrayList<Project> projectList, ArrayList<User> userList, Utilities utility) throws InputMismatchException, NumberFormatException{
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
	public static Project createProject() throws InputMismatchException, NumberFormatException{
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
		System.out.println("Data de inicio:");
		String startDate = sc.nextLine();
		System.out.println("Data de termino:");
		String endDate = sc.nextLine();
		System.out.println("Valor financiado:");
		double financedAmount = sc.nextDouble();
		
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
	public static ArrayList<Project> addUserToProject(ArrayList<Project> projectList, ArrayList<User> userList, String projectName, String userName){
		for(int i = 0; i < userList.size(); i++){
			if(userList.get(i).getName().equalsIgnoreCase(userName)){
				for(int j = 0; j < projectList.size(); j++){
					if(projectList.get(j).getTitle().equalsIgnoreCase(projectName)){
						projectList.get(j).allocateUser(userList.get(i));
						return projectList;
					}
				}
			}
		}
		return projectList;
	}
	public static ArrayList<Project> addPublicationToProject(ArrayList<Project> projectList, String publicationTitle, String projectName){
		for(int i = 0; i < publicationList.size(); i++){
			if(publicationList.get(i).getTitle().equalsIgnoreCase(publicationTitle)){
				for(int j = 0; j < projectList.size(); j++){
					if(projectList.get(j).getTitle().equalsIgnoreCase(projectName)){
						projectList.get(j).setPublications(publicationList.get(i));
						return projectList;
					}
				}
			}
		}
		return projectList;
		
	}
	public static void contributors(ArrayList<User> userList, Utilities utility) throws InputMismatchException, NumberFormatException{
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Digite o nome do colaborador:");
		Scanner sc = new Scanner(System.in);
		String collaboratorName = sc.nextLine();
		utility.consultCollaborator(userList, collaboratorName);
	}
	public static void projects(ArrayList<Project> projectList, Utilities utility) throws InputMismatchException, NumberFormatException{
		System.out.println("--- Sistema de Gestao de Produtividade Academica ---");
		System.out.println("Digite o titulo do projeto:");
		Scanner sc = new Scanner(System.in);
		String projectName = sc.nextLine();
		utility.consultProject(projectList, projectName);
	}
}