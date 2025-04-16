package UjMedicalCenter;

public class FeedBack {
    private Student student;
    private Doctor doctor;
    private String message;

    public FeedBack(Student student, Doctor doctor, String message) {
        this.student = student;
        this.doctor = doctor;
        this.message = message;
    }

    public String toString() {
        return "\uD83D\uDCDD " + student.getName() + " on Dr. " + doctor.getName() + ": \"" + message + "\"";
    }
}