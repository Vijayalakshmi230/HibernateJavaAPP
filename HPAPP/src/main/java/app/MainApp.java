package app;

import java.util.List;
import java.util.Scanner;

import Services.StudentRepo;
import Services.StudentRepoImpl;
import entity.Student;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRepo repo = new StudentRepoImpl();

        int choice;
        do {
            System.out.println("\n======= Student Management =======");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student s1 = new Student();
                    System.out.print("Enter Student ID: ");
                    s1.setStudent_Id(sc.nextInt());
                    System.out.print("Enter Name: ");
                    s1.setName(sc.next());
                    System.out.print("Enter Age: ");
                    s1.setAge(sc.nextInt());
                    System.out.print("Enter Course Name: ");
                    s1.setCN(sc.next());
                    System.out.println(repo.addStudent(s1));
                    break;

                case 2:
                    Student s2 = new Student();
                    System.out.print("Enter Student ID to update: ");
                    s2.setStudent_Id(sc.nextInt());
                    System.out.print("Enter new Name: ");
                    s2.setName(sc.next());
                    System.out.print("Enter new Age: ");
                    s2.setAge(sc.nextInt());
                    System.out.print("Enter new Course Name: ");
                    s2.setCN(sc.next());
                    System.out.println(repo.updateStudent(s2));
                    break;

                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    System.out.println(repo.deleteStudent(deleteId));
                    break;

                case 4:
                    List<Student> studentList = repo.getAllStudents();
                    if (studentList != null && !studentList.isEmpty()) {
                        System.out.println("\n--- All Students ---");
                        for (Student s : studentList) {
                            System.out.println(s);  // toString() is already overridden
                        }
                    } else {
                        System.out.println("No student records found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter between 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}
