package users;

public class Student extends User{
	protected String guideProfessor;
	protected String type;
	
	
	public Student(String name, String email, String guideProfessor){
		super(name, email);
		this.guideProfessor = guideProfessor;
	}
	
	
	public String getGuideProfessor() {
		return guideProfessor;
	}
	public void setGuideProfessor(String guideProfessor) {
		this.guideProfessor = guideProfessor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
