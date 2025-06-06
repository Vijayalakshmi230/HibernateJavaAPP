package Services;

import java.util.List;

import entity.Student;

public interface StudentRepo {
	
	String addStudent(Student student);
	String updateStudent(Student student);
	String deleteStudent(int Student_Id);
	List<Student> getAllStudents();

}
