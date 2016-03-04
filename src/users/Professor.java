package users;

import java.util.ArrayList;

public class Professor extends User{
	protected ArrayList<Student> guideStudent;

	
	public Professor(String name, String email) {
		super(name, email);
		this.guideStudent = new ArrayList<Student>();
	}
	
	
	public ArrayList<Student> getGuideStudent() {
		return guideStudent;
	}

	public void setGuideStudent(Student student) {
		this.guideStudent.add(student);
	}
}
