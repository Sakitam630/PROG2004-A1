/**
 * Paediatrician - child doctors who treat young patients.
 * Similar structure to GeneralPractitioner but with different specific info.
 */
public class Paediatrician extends HealthProfessional {
    private String ageRange;  // Stores which age groups this doctor treats

    // Default constructor
    public Paediatrician() {
        super();
        this.ageRange = "";
    }

    // Constructor with all parameters
    public Paediatrician(int id, String name, String specialization, String ageRange) {
        super(id, name, specialization);
        this.ageRange = ageRange;
    }

    // Override to show paediatrician-specific information
    @Override
    public void printDetails() {
        System.out.println("Health Professional Type: Paediatrician");
        super.printDetails();
        System.out.println("Age Range: " + ageRange);
    }
    
    public String getAgeRange() {
        return ageRange;
    }
    
    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }
}
