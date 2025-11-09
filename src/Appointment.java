public class Appointment {
    // Static counter for unique appointment IDs
    private static int appointmentCounter = 1000;
    
    // Instance variables
    private String appointmentId;
    private String patientName;
    private String patientMobile;
    private TimeSlot preferredTimeSlot;
    private HealthProfessional selectedDoctor;
    private AppointmentStatus status;
    
    // Enum for time slots - makes scheduling more robust
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
    
    // Enum for appointment status tracking
    public enum AppointmentStatus {
        SCHEDULED,
        CONFIRMED,
        CANCELLED,
        COMPLETED
    }
    
    // Default constructor
    public Appointment() {
        this.appointmentId = generateAppointmentId();
        this.patientName = "";
        this.patientMobile = "";
        this.preferredTimeSlot = null;
        this.selectedDoctor = null;
        this.status = AppointmentStatus.SCHEDULED;
    }
    
    // Constructor that initializes all instance variables
    public Appointment(String patientName, String patientMobile, 
                      TimeSlot preferredTimeSlot, HealthProfessional selectedDoctor) {
        this.appointmentId = generateAppointmentId();
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.preferredTimeSlot = preferredTimeSlot;
        this.selectedDoctor = selectedDoctor;
        this.status = AppointmentStatus.SCHEDULED;
    }
    
    // Generate unique appointment ID
    private static String generateAppointmentId() {
        return "APT-" + (appointmentCounter++);
    }
    
    // Method to print all instance variables
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
    
    // Additional useful methods
    public void confirmAppointment() {
        this.status = AppointmentStatus.CONFIRMED;
    }
    
    public void cancelAppointment() {
        this.status = AppointmentStatus.CANCELLED;
    }
    
    public String getAppointmentId() {
        return appointmentId;
    }
    
    public AppointmentStatus getStatus() {
        return status;
    }
}
