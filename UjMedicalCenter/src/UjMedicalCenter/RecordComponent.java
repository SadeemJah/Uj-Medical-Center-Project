package UjMedicalCenter;

public interface RecordComponent {
    void showDetails();
    String getContent();


     class Note implements RecordComponent {
     private String content;
         
       public Note(String content) {
            this.content = content;
        }

        @Override
        public void showDetails() {
            System.out.println("- " + content);
        }

        @Override
        public String getContent() {
            return content;
        }
    }
}
