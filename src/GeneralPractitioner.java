public class GeneralPractitioner extends HealthProfessional {
    private String clinicName;

    // Default constructor
    public GeneralPractitioner() {
        super();
        this.clinicName = "";
    }

    // Constructor that initializes all instance variables
    public GeneralPractitioner(int id, String name, String specialization, String clinicName) {
        super(id, name, specialization);
        this.clinicName = clinicName;
    }

    // Override method to print all instance variables
    @Override
    public void printDetails() {
        System.out.println("Health Professional Type: General Practitioner");
        super.printDetails();
        System.out.println("Clinic Name: " + clinicName);
    }
}
