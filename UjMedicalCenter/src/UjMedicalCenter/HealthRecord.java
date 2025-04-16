package UjMedicalCenter;


import java.util.ArrayList;

public class HealthRecord {
    private Student student;
    private ArrayList<String> notes = new ArrayList<>();

    public HealthRecord(Student student) {
        this.student = student;
    }

    public void addNote(String note) {
        notes.add(note);
    }

    public ArrayList<String> getNotes() {
        return notes;
    }

    public void showRecord() {
        System.out.println("\uD83E\uDE7A Health Record for " + student.getName());
        for (String note : notes) {
            System.out.println("- " + note);
        }
    }
}
