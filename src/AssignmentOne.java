import java.util.ArrayList;

/**
 * Main class for the Health Professional System.
 * Demonstrates object-oriented programming concepts including inheritance,
 * polymorphism, encapsulation, and collection management.
 * 
 * @author Hongke Ouyang
 * @version 1.0
 */
public class AssignmentOne {
    // ArrayList to hold all appointments - using static so all methods can access it
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    
    /**
     * Main method - entry point of the program.
     * Creates health professionals, manages appointments, and demonstrates
     * the functionality of the system.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Assignment One - Health Professional System");

        // Part 3 – Using classes and objects
        // Create three General Practitioners
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. John Swift", "General Medicine", "City Health Clinic");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Sarah", "Family Medicine", "Suburban Medical Center");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Michael", "General Practice", "Downtown Health Hub");

        // Create two Paediatricians
        Paediatrician paed1 = new Paediatrician(4, "Dr. Emily", "Paediatrics", "0-18 years");
        Paediatrician paed2 = new Paediatrician(5, "Dr. James Wilson", "Child Health", "0-16 years");

        // Print details of all health professionals
        gp1.printDetails();
        System.out.println("------------------------------");
        gp2.printDetails();
        System.out.println("------------------------------");
        gp3.printDetails();
        System.out.println("------------------------------");
        paed1.printDetails();
        System.out.println("------------------------------");
        paed2.printDetails();
        System.out.println("------------------------------");
        
        // Part 5 – Collection of appointments
        // Make 2 appointments with general practitioners
        createAppointment("Alice Johnson", "0412345678", Appointment.TimeSlot.SLOT_08_00, gp1);
        createAppointment("Bob Smith", "0423456789", Appointment.TimeSlot.SLOT_10_00, gp2);
        
        // Make another 2 appointments with paediatricians
        createAppointment("Charlie Brown", "0434567890", Appointment.TimeSlot.SLOT_14_30, paed1);
        createAppointment("Diana Prince", "0445678901", Appointment.TimeSlot.SLOT_16_00, paed2);
        
        // Print existing appointments
        printExistingAppointments();
        
        // Cancel one of the existing appointments
        System.out.println("\nCancelling appointment for mobile: 0423456789");
        cancelBooking("0423456789");
        
        // Print again existing appointments to demonstrate the updated collection
        printExistingAppointments();
        
        System.out.println("------------------------------");
    }
    
    /**
     * Creates a new appointment and adds it to the collection.
     * Validates all required information before creating the appointment.
     * Uses polymorphism - accepts any HealthProfessional type (GP, Paediatrician, etc.)
     * 
     * @param patientName the name of the patient
     * @param patientMobile the mobile phone number of the patient (must be Australian format)
     * @param timeSlot the preferred time slot for the appointment
     * @param doctor the health professional for this appointment (can be any type)
     * @return true if appointment created successfully, false otherwise
     */
    public static boolean createAppointment(String patientName, String patientMobile, 
                                        Appointment.TimeSlot timeSlot, HealthProfessional doctor) {
        // Check if patient name is provided
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("Error: Patient name is required. Appointment not created.");
            return false;
        }
        // Check if mobile is provided
        if (patientMobile == null || patientMobile.trim().isEmpty()) {
            System.out.println("Error: Patient mobile phone is required. Appointment not created.");
            return false;
        }
        // Validate Australian mobile format (must start with 04 and have 10 digits total)
        if (!patientMobile.matches("^04\\d{8}$")) {
            System.out.println("Error: Invalid mobile format. Please use Australian format (04XXXXXXXX). Appointment not created.");
            return false;
        }
        // Check if time slot is selected
        if (timeSlot == null) {
            System.out.println("Error: Time slot is required. Appointment not created.");
            return false;
        }
        // Check if doctor is selected
        if (doctor == null) {
            System.out.println("Error: Doctor must be selected. Appointment not created.");
            return false;
        }
        
        // All checks passed - create and add the appointment
        Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointments.add(newAppointment);
        System.out.println("Appointment created successfully with ID: " + newAppointment.getAppointmentId());
        return true;
    }
    
    /**
     * Prints all existing appointments in the system.
     * Displays a message if no appointments exist.
     * Iterates through the ArrayList to display each appointment's details.
     */
    public static void printExistingAppointments() {
        System.out.println("\n========== EXISTING APPOINTMENTS ==========");
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments found.");
        } else {
            // Loop through all appointments and print each one
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println("\n[Appointment " + (i + 1) + "]");
                appointments.get(i).printDetails();
            }
        }
        System.out.println("===========================================\n");
    }
    
    /**
     * Cancels an appointment by searching for the patient's mobile number.
     * Only cancels appointments that are not already cancelled.
     * 
     * @param patientMobile the mobile phone number to search for
     * @return true if an appointment was cancelled, false if not found
     */
    public static boolean cancelBooking(String patientMobile) {
        // Make sure mobile number is provided
        if (patientMobile == null || patientMobile.trim().isEmpty()) {
            System.out.println("Error: Mobile phone number is required to cancel booking.");
            return false;
        }
        
        boolean found = false;
        // Search through all appointments to find matching mobile
        for (int i = 0; i < appointments.size(); i++) {
            Appointment apt = appointments.get(i);
            // Check if mobile matches and appointment is not already cancelled
            if (apt.getPatientMobile() != null && 
                apt.getPatientMobile().equals(patientMobile) && 
                apt.getStatus() != Appointment.AppointmentStatus.CANCELLED) {
                apt.cancelAppointment();
                System.out.println("Appointment " + apt.getAppointmentId() + " has been cancelled successfully.");
                found = true;
                break;  // Found it, no need to keep searching
            }
        }
        
        if (!found) {
            System.out.println("Error: No active appointment found with mobile phone: " + patientMobile);
        }
        
        return found;
    }
}
