package entity;

import javax.persistence.*;

@Entity
public class Student {
	@Id
	private int Student_Id;
	private String Name;
	private int Age;
	private String CN; //course name
	
	
	// getter and setter method
	public int getStudent_Id() {
		return Student_Id;
	}
	public void setStudent_Id(int student_id) {
		Student_Id = student_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getCN() {
		return CN;
	}
	public void setCN(String cN) {
		CN = cN;
	}
	
	@Override
	public String toString() {
		return this.Student_Id + " "+this.Name + " : "+this.Age + " : "+this.CN;
		
	}	

}
