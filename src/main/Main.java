package main;

import users.*;


public class Main {
	public static void main(String[] args) {
		
		Professor baldoino = new Professor("Baldoino", "baldoino@ic.ufal.br");
		Project projeto1 = new Project("Projeto1", "Esse é o objetivo", "Essa é a descrição", "Baldoino", "BlackBerry", 2000.00, "04/03", "04/05", false, "em elaboração");
		Student andre = new Student("André", "andre@ic.ufal.br", "Baldoino", "graduação");
		
		
		projeto1.setTeam(baldoino);
		projeto1.setTeam(andre);
		baldoino.setProjects(projeto1);
		andre.setProjects(projeto1);
		
	}
}
