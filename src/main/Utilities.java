package main;

import java.util.ArrayList;
import users.*;

public class Utilities {

	public void consultCollaborator(ArrayList<User> user, String collaborator){
		for(int aux = 0; aux < user.size() ; aux++)
		{
			if(user.get(aux).getName().equals(collaborator))
			{
				System.out.println("Nome: " + user.get(aux).getName() + "\nEmail: " + user.get(aux).getEmail() + "\nLista de Projetos: ");
				if(user.get(aux).getProjects().size() != 0){
					System.out.println(user.get(aux).getProjects().toString());
				}
				else{
					System.out.println("Nenhum");
				}
				System.out.println("\nProducoes: ");
				if(user.get(aux).getPublication().size() != 0){
					System.out.println(user.get(aux).getPublication().toString());
				}
				else{
					System.out.println("Nenhuma");
				}
				System.out.println("\n\n\n\n");
			}
		}
	}	

	public void consultProject(ArrayList<Project> project, String projectName){
		for(int aux = 0; aux < project.size() ; aux++)
		{
			if(project.get(aux).getTitle().equals(projectName))
			{
				System.out.println("Titulo: " + project.get(aux).getTitle() + "\nColaboradores: ");
				if(project.get(aux).getUsers().size() != 0){
					System.out.println(project.get(aux).getUsers().toString());
				}
				else{
					System.out.println("Nenhum");
				}
				System.out.println("\nProducoes: ");
				if(project.get(aux).getPublications().size() != 0){
					System.out.println(project.get(aux).getPublications().toString());
				}
				else{
					System.out.println("Nenhuma");
				}
				System.out.println("\n\n\n\n");
			}
		}
	}
}
