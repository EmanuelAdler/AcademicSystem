package main;
import java.util.ArrayList;
import main.Project;
import publications.Publication;
import users.*;


public class Main {
	public static void main(String[] args) {
		
		ArrayList<User> user = new ArrayList<User>();
		ArrayList<Project> project = new ArrayList<Project>();
		ArrayList<Publication> publication = new ArrayList<Publication>();

		Professor baldoino = new Professor("Baldoino", "baldoino@ic.ufal.br");
		Project projeto1 = new Project("Projeto1", "Esse é o objetivo", "Essa é a descrição", "BlackBerry", 2000.00, "04/03", "04/05", false, "em elaboração");
		Project projeto2 = new Project("Projeto2", "Esse é o objetivo", "Essa é a descrição", "BlackBerry", 2000.00, "04/03", "04/04", false, "em elaboração");

		Student andre = new Student("Andre", "andre@ic.ufal.br", "Baldoino", "graduação");
		
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
		
		//consulta por colaborador
		for(int aux = 0; aux < user.size() ; aux++)
		{
			if(user.get(aux).getName().equals("Baldoino"))
			{
				System.out.println("Nome: " + user.get(aux).getName() + "\nEmail: " + user.get(aux).getEmail() + "\nLista de Projetos: " + user.get(aux).getProjects().toString() + "producao: " + user.get(aux).getPublication().toString() + "\n\n\n\n");
						
			}
		}
		//consulta por projeto	
		for(int aux = 0; aux < project.size(); aux++)
		{
			if(project.get(aux).getTitle().equals("Projeto2"))
			{
				System.out.println("Titulo: " + project.get(aux).getTitle() + "\nColaboradores: " + project.get(aux).getUsers().toString() + "producao: " + project.get(aux).getPublications().toString());
			}
		}
		
		
	}
}