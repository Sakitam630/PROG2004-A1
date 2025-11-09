public class Paediatrician extends HealthProfessional {
    private String ageRange;

    // Default constructor
    public Paediatrician() {
        super();
        this.ageRange = "";
    }

    // Constructor that initializes all instance variables
    public Paediatrician(int id, String name, String specialization, String ageRange) {
        super(id, name, specialization);
        this.ageRange = ageRange;
    }

    // Override method to print all instance variables
    @Override
    public void printDetails() {
        System.out.println("Health Professional Type: Paediatrician");
        super.printDetails();
        System.out.println("Age Range: " + ageRange);
    }
}
