package UjMedicalCenter;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterStudentCommand implements Command {
    private ArrayList<Student> students;
    private Scanner input;
    private Student lastStudent;

    public RegisterStudentCommand(ArrayList<Student> students, Scanner input) {
        this.students = students;
        this.input = input;
    }

    @Override
    public void execute() {
        input.nextLine();
        System.out.print("Enter student name: ");
        String name = input.nextLine();
        System.out.print("Enter phone: ");
        int phone = input.nextInt();
        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter branch: ");
        String branch = input.nextLine();

        lastStudent = new Student(id, name, phone, branch);
        students.add(lastStudent);
        System.out.println("Student registered successfully.");
    }

    @Override
    public void undo() {
        if (lastStudent != null && students.contains(lastStudent)) {
            students.remove(lastStudent);
            System.out.println("↩️ Undo: " + lastStudent.getName() +  " registration removed.");
        } else {
            System.out.println("Nothing to undo");
        }
    }
}
