package UjMedicalCenter;

import java.util.ArrayList;
import java.util.Scanner;

public class Appointment implements Cloneable {
    private String specialization;
    private String time;

    public Appointment(String specialization, String time) {
        this.specialization = specialization;
        this.time = time;
    }

    public String getSpecialization() { return specialization; }
    public String getTime() { return time; }

    public String toString() {
        return specialization + " at " + time;
    }

    public static void bookAppointments(Student student, ArrayList<Doctor> doctorList, ArrayList<String> timeSlots) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("List of Doctors\n");
            for (int i = 0; i < doctorList.size(); i++) {
                System.out.println((i + 1) + "- " + doctorList.get(i));
            }

            System.out.println("Enter number of Doctor to book with (0 to Exit):");
            int doctorIndex = input.nextInt() - 1;
            if (doctorIndex == -1) return;
            if (doctorIndex >= 0 && doctorIndex < doctorList.size()) {
                Doctor selectedDoctor = doctorList.get(doctorIndex);

                System.out.println("Available Times:");
                for (int i = 0; i < timeSlots.size(); i++) {
                    System.out.println((i + 1) + "- " + timeSlots.get(i));
                }

                System.out.println("Select a time:");
                int timeIndex = input.nextInt() - 1;
                if (timeIndex >= 0 && timeIndex < timeSlots.size()) {
                    String time = timeSlots.get(timeIndex);
                    Appointment appointment = new Appointment(selectedDoctor.getSpecialization(), time);
                    student.addAppointment(appointment);
                    timeSlots.remove(timeIndex);
                    System.out.println("Appointment booked!");
                }
            } else {
                System.out.println("Invalid selection.");
            }

            System.out.println("Do you want to book another appointment? (y/n):");
            if (!input.next().equalsIgnoreCase("y")) break;
        }
    }

    public static void displayAppointments(Student student) {
        System.out.println("Appointments for " + student.getName() + ":");
        for (Appointment appointment : student.getAppointments()) {
            System.out.println("- " + appointment);
        }
    }
}
