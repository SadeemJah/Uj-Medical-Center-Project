package UjMedicalCenter;

public interface RecordComponent {
    void showDetails();

    public class Note implements RecordComponent {
        private String note;

        public Note(String note) {
            this.note = note;
        }

        @Override
        public void showDetails() {
            System.out.println("- " + note);
        }
    }
}
