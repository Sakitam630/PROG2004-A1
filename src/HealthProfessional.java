public class HealthProfessional {
    // Instance variables
    private int id;
    private String name;
    private String specialization;

    // Default constructor
    public HealthProfessional() {
        this.id = 0;
        this.name = "";
        this.specialization = "";
    }

    // Constructor that initializes all instance variables
    public HealthProfessional(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // Method that prints all instance variables
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}
