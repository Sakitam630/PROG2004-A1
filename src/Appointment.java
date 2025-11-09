/**
 * Appointment class - manages bookings between patients and doctors.
 * I used enums for time slots and status to make the code safer and clearer.
 */
public class Appointment {
    // Static counter - shared by all appointments to generate unique IDs
    private static int appointmentCounter = 1000;
    
    // Instance variables for each appointment
    private String appointmentId;
    private String patientName;
    private String patientMobile;
    private TimeSlot preferredTimeSlot;
    private HealthProfessional selectedDoctor;  // Can be any type of doctor (polymorphism!)
    private AppointmentStatus status;
    
    // Enum for available time slots - prevents invalid times
    public enum TimeSlot {
        SLOT_08_00("08:00"),
        SLOT_09_00("09:00"),
        SLOT_10_00("10:00"),
        SLOT_11_00("11:00"),
        SLOT_14_00("14:00"),
        SLOT_14_30("14:30"),
        SLOT_15_00("15:00"),
        SLOT_16_00("16:00");
        
        private final String time;
        
        TimeSlot(String time) {
            this.time = time;
        }
        
        public String getTime() {
            return time;
        }
    }
    
    // Enum for tracking appointment status - makes it easy to manage lifecycle
    public enum AppointmentStatus {
        SCHEDULED,
        CONFIRMED,
        CANCELLED,
        COMPLETED
    }
    
    // Default constructor - generates a unique ID automatically
    public Appointment() {
        this.appointmentId = generateAppointmentId();
        this.patientName = "";
        this.patientMobile = "";
        this.preferredTimeSlot = null;
        this.selectedDoctor = null;
        this.status = AppointmentStatus.SCHEDULED;
    }
    
    // Constructor with all the details needed for an appointment
    // The doctor parameter can be GP, Paediatrician, or any future health professional type
    public Appointment(String patientName, String patientMobile, 
                      TimeSlot preferredTimeSlot, HealthProfessional selectedDoctor) {
        this.appointmentId = generateAppointmentId();
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.preferredTimeSlot = preferredTimeSlot;
        this.selectedDoctor = selectedDoctor;
        this.status = AppointmentStatus.SCHEDULED;
    }
    
    // Helper method to generate unique IDs (APT-1000, APT-1001, etc.)
    private static String generateAppointmentId() {
        return "APT-" + (appointmentCounter++);
    }
    
    // Print all appointment details including the doctor's information
    public void printDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Preferred Time: " + (preferredTimeSlot != null ? preferredTimeSlot.getTime() : "Not set"));
        System.out.println("Status: " + status);
        System.out.println("--- Assigned Doctor ---");
        if (selectedDoctor != null) {
            selectedDoctor.printDetails();
        } else {
            System.out.println("No doctor assigned");
        }
    }
    
    // Methods to change appointment status
    public void confirmAppointment() {
        this.status = AppointmentStatus.CONFIRMED;
    }
    
    public void cancelAppointment() {
        this.status = AppointmentStatus.CANCELLED;
    }
    
    // Getter methods - allow access to private data
    public String getAppointmentId() {
        return appointmentId;
    }
    
    public AppointmentStatus getStatus() {
        return status;
    }
    
    public String getPatientMobile() {
        return patientMobile;
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public TimeSlot getPreferredTimeSlot() {
        return preferredTimeSlot;
    }
    
    public HealthProfessional getSelectedDoctor() {
        return selectedDoctor;
    }
}
