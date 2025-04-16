package UjMedicalCenter;

import java.util.ArrayList;

public class Student {
    private int ID;
    private String name;
    private int phoneNumber;
    private String branch;
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private HealthRecord healthRecord;

    public Student(int ID, String name, int phoneNumber, String branch) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.branch = branch;
        this.healthRecord = new HealthRecord(this);
    }

    public int getID() { return ID; }
    public String getName() { return name; }
    public int getPhoneNumber() { return phoneNumber; }
    public String getBranch() { return branch; }
    public ArrayList<Appointment> getAppointments() { return appointments; }
    public HealthRecord getHealthRecord() { return healthRecord; }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public String toString() {
        return "UjMedicalCenter.Student name: " + name + "\n Student ID: " + ID;
    }
}
