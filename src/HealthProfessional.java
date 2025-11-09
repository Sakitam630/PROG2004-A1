/**
 * Base class for all health professionals.
 * This class holds basic information that every doctor needs.
 */
public class HealthProfessional {
    // Using private to protect data - learned this is good practice
    private int id;
    private String name;
    private String specialization;

    // Default constructor - creates empty health professional
    public HealthProfessional() {
        this.id = 0;
        this.name = "";
        this.specialization = "";
    }

    // Constructor with parameters - easier to create objects with all info at once
    public HealthProfessional(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // Print method - displays all the doctor's information
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
    
    // Getters - provide access to private data
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSpecialization() {
        return specialization;
    }
    
    // Setters - allow changing values safely
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
