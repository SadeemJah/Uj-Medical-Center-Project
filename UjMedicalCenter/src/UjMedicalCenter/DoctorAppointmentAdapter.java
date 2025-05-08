package UjMedicalCenter;

public class
DoctorAppointmentAdapter implements AppointmentDetails {

    private Doctor doctor;
    private Appointment appointment;

    public DoctorAppointmentAdapter(Doctor doctor, Appointment appointment) {
        this.doctor = doctor;
        this.appointment = appointment;
    }

    @Override
    public void showDoctorInfo() {
        System.out.println("Doctor: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization());
    }

    @Override
    public void showAppointmentInfo() {
        System.out.println("Appointment Time: " + appointment.getTime());
    }

    @Override
    public void showFullDetails() {
        System.out.println("Dr. " + doctor.getName() + " (" + doctor.getSpecialization() + ") at " + appointment.getTime());
    }
}
