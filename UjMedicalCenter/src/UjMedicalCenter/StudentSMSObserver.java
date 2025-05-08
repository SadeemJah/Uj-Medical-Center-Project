package UjMedicalCenter;

public class StudentSMSObserver implements Observer {
    private int phoneNumber;

    public StudentSMSObserver(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String message) {
        System.out.println("Sending SMS to: 0" + phoneNumber);
        System.out.println("Message: " + message);
        System.out.println("--------------------------------------");
    }
}