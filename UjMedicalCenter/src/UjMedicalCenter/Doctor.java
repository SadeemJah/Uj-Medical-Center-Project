package UjMedicalCenter;

public class Doctor {
    private int ID;
    private String name;
    private int phone;
    private String specialization;

    public Doctor(int ID, String name, int phone, String specialization) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.specialization = specialization;
    }

    public int getID() { return ID; }
    public String getName() { return name; }
    public int getPhone() { return phone; }
    public String getSpecialization() { return specialization; }

    public void setID(int ID) { this.ID = ID; }
    public void setName(String name) { this.name = name; }
    public void setPhone(int phone) { this.phone = phone; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String toString() {
        return String.format("%-25s %s", name, specialization);
    }
}
