/**
 * General Practitioner - extends HealthProfessional to inherit common properties.
 * I added clinicName because GPs usually work at specific clinics.
 */
public class GeneralPractitioner extends HealthProfessional {
    private String clinicName;

    // Default constructor - calls parent constructor first with super()
    public GeneralPractitioner() {
        super();
        this.clinicName = "";
    }

    // Constructor with all parameters
    // Uses super() to set the parent class fields (id, name, specialization)
    public GeneralPractitioner(int id, String name, String specialization, String clinicName) {
        super(id, name, specialization);
        this.clinicName = clinicName;
    }

    // Override printDetails to show GP-specific info
    // Calls super.printDetails() to print common info first, then adds clinic name
    @Override
    public void printDetails() {
        System.out.println("Health Professional Type: General Practitioner");
        super.printDetails();
        System.out.println("Clinic Name: " + clinicName);
    }
    
    public String getClinicName() {
        return clinicName;
    }
    
    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
}
