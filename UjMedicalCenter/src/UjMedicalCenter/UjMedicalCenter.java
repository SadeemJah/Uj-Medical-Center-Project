package UjMedicalCenter;

import java.util.*;

public class UjMedicalCenter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Doctor> doctorList = new ArrayList<>();
        ArrayList<String> timeSlots = new ArrayList<>(List.of("1:30","2:30","2:00","3:00", "3:30", "4:00", "4:30", "5:00"));
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<FeedBack> feedbacks = new ArrayList<>();

        // Sample doctors (you can load from a file too)
        doctorList.add(new Doctor(1, "DR. Motasim Jawi", "20 - 04 - 2025", "Lipid Disease Clinic"));
        doctorList.add(new Doctor(2, "DR. ABDULRAHMAN alshamrani", "22 - 04 - 2025", "Ophthalmology"));
        doctorList.add(new Doctor(3, "DR. Shahad Abbas", "26 - 04 - 2025", "General Physician"));

        while (true) {
            System.out.println("\n Welcome to UJ Medical Center Menu:");
            System.out.println("1. Register Student");
            System.out.println("2. Book Appointment");
            System.out.println("3. Show Appointments");
            System.out.println("4. Add/View Health Record");
            System.out.println("5. Leave Feedback");
            System.out.println("6. Show All Feedbacks");
            System.out.println("0. Exit");
            System.out.print("Choose One of the options: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
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
                    students.add(new Student(id, name, phone, branch));
                    break;

                case 2:
                    Student studentToBook = selectStudent(students, input);
                    if (studentToBook != null)
                        Appointment.bookAppointments(studentToBook, doctorList, timeSlots);
                    break;

                case 3:
                    Student studentToView = selectStudent(students, input);
                    if (studentToView != null)
                        Appointment.displayAppointments(studentToView);
                    break;

                case 4:
                    Student studentHR = selectStudent(students, input);
                    if (studentHR != null) {
                        System.out.println("1. Add Note\n2. View Record");
                        int hrChoice = input.nextInt();
                        input.nextLine();
                        if (hrChoice == 1) {
                            System.out.print("Enter note: ");
                            String note = input.nextLine();
                            studentHR.getHealthRecord().addNote(note);
                        } else {
                            studentHR.getHealthRecord().showRecord();
                        }
                    }
                    break;

                case 5:
                    Student fbStudent = selectStudent(students, input);
                    if (fbStudent != null) {
                        System.out.println("Choose doctor for feedback:");
                        for (int i = 0; i < doctorList.size(); i++)
                            System.out.println((i + 1) + "- " + doctorList.get(i).getName());
                        int dIndex = input.nextInt() - 1;
                        input.nextLine();
                        if (dIndex >= 0 && dIndex < doctorList.size()) {
                            System.out.print("Write your feedback: ");
                            String message = input.nextLine();
                            feedbacks.add(new FeedBack(fbStudent, doctorList.get(dIndex), message));
                        }
                    }
                    break;

                case 6:
                    for (FeedBack f : feedbacks)
                        System.out.println(f);
                    break;

                case 0:
                    RecordManager.saveStudentRecords(students, "students.txt");
                    System.out.println("Get Well Soon!");
                    return;


                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static Student selectStudent(ArrayList<Student> students, Scanner input) {
        System.out.print("Enter student id number: ");
        int id = input.nextInt();
        for (Student s : students) {
            if (s.getID() == id)
                return s;
        }
        System.out.println("Student not found.");
        return null;
    }
}
