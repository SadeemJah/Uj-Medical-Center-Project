package UjMedicalCenter;

import java.util.ArrayList;

public class HealthRecord implements Subject {
    private Student student;
    private ArrayList<RecordComponent> notes = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public HealthRecord(Student student) {
        this.student = student;
        registerObserver(new StudentSMSObserver(student.getPhoneNumber()));
    }

    public void addNote(RecordComponent note) {
        notes.add(note);
        notifyObservers("A new note has been added to your health record: " + note.getContent());
    }

    public ArrayList<RecordComponent> getNotes() {
        return notes;
    }

    public void showRecord() {
        System.out.println("\uD83E\uDE7A Health Record for " + student.getName());
        for (RecordComponent note : notes) {
            note.showDetails();
        }
    }

    // Observer pattern methods
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
