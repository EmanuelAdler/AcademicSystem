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
		ArrayList<Project> project = new ArrayList<Project>();
		ArrayList<Publication> publication = new ArrayList<Publication>();
		Utilities utility = new Utilities();
		
		
		/*Professor baldoino = new Professor("Baldoino", "baldoino@ic.ufal.br");
		Project projeto1 = new Project("Projeto1", "Esse Ã© o objetivo", "Essa Ã© a descriÃ§Ã£o", "BlackBerry", 2000.00, "04/03", "04/05", false, "em elaboraÃ§Ã£o");
		Project projeto2 = new Project("Projeto2", "Esse Ã© o objetivo", "Essa Ã© a descriÃ§Ã£o", "BlackBerry", 2000.00, "04/03", "04/04", false, "em elaboraÃ§Ã£o");

		Student andre = new Student("Andre", "andre@ic.ufal.br", "Baldoino", "graduaÃ§Ã£o");
		
		user.add(baldoino);
		user.add(andre);
		project.add(projeto1);
		project.add(projeto2);

		projeto1.setTeam(baldoino);
		projeto1.setTeam(andre);
		baldoino.setProjects(projeto1);
		andre.setProjects(projeto1);
		
		projeto2.setTeam(baldoino);
		baldoino.setProjects(projeto2);
		*/
		
		System.out.println("--- Sistema de Gestão de Produtividade Acadêmica ---");
		System.out.println("Escolha uma opção:");
		System.out.println("1. Criar usuário");
		System.out.println("2. Projetos");
		System.out.println("3. Criar publicação");
		System.out.println("4. Consultas");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		if(option == 1){
			User newUser = userCreate();
			userList.add(newUser);
		}
		else if(option == 2)
			projectsMenu();
		else if(option == 3)
			createPublication();
		else if(option == 4)
			consultation();
		sc.close();
		/*
		//consulta por colaborador
		utility.consultCollaborator(user, "Baldoino");
		//consulta por projeto	
		utility.consultProject(project, "Projeto2");
		*/
		
	}
	
	public static User userCreate(){
		System.out.println("--- Sistema de Gestão de Produtividade Acadêmica ---");
		System.out.println("Escolha o tipo de usuário");
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
		sc.close();
		return newUser;
	}
	public static Professor createProfessor(){
		Professor newProfessor = new Professor(null, null);
		System.out.println("--- Sistema de Gestão de Produtividade Acadêmica ---");
		System.out.println("Nome:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		newProfessor.setName(name);
		newProfessor.setEmail(email);
		sc.close();
		return newProfessor;
	}
	public static Student createStudent(){
		Student newUser = new Student(null, null, null);
		System.out.println("--- Sistema de Gestão de Produtividade Acadêmica ---");
		System.out.println("Escolha o tipo de estudante");
		System.out.println("1. Graduação");
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
		sc.close();
		return newUser;
		
	}
	public static Student createStudentGeneral(Student newUser){
		System.out.println("--- Sistema de Gestão de Produtividade Acadêmica ---");
		System.out.println("Nome:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		newUser.setName(name);
		newUser.setEmail(email);
		sc.close();
		return newUser;
		
	}
	public static Project projectsMenu(){
		System.out.println("--- Sistema de Gestão de Produtividade Acadêmica ---");
		System.out.println("Escolha uma opção:");
		System.out.println("1. Criar projeto");
		System.out.println("2. Adicionar usuário a um projeto");
		System.out.println("3. Adicionar publicação a um projeto");
		
		Project newProject = new Project(null, null, null, null, 0.0, null, null, false, null);
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		if(option == 1)
			newProject = createProject();
		else if(option == 2)
			addUserToProject();
		else if(option == 3)
			addPublicationToProject();
		sc.close();
		return newProject;
	}
	public static void createPublication(){
		
	}
	public static void consultation(){
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		if(option == 1)
			contributors();
		else if(option == 2)
			projects();
		sc.close();
	}
	public static Project createProject(){
		Project newProject = new Project(null, null, null, null, 0.0, null, null, false, null);
		System.out.println("--- Sistema de Gestão de Produtividade Acadêmica ---");
		System.out.println("Título:");
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		System.out.println("Objetivo:");
		String objective = sc.nextLine();
		System.out.println("Descrição:");
		String description = sc.nextLine();
		System.out.println("Agência financiadora:");
		String fundingAgency = sc.nextLine();
		System.out.println("Valor financiado:");
		double financedAmount = sc.nextDouble();
		System.out.println("Data de início:");
		String startDate = sc.nextLine();
		System.out.println("Data de término:");
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
		sc.close();
		return newProject;
		
	}
	public static void addUserToProject(){
		
	}
	public static void addPublicationToProject(){
		
	}
	public static void contributors(){
		
	}
	public static void projects(){
		
	}
}