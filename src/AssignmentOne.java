import java.util.ArrayList;

public class AssignmentOne {
    // ArrayList to store appointments
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    
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
     * Creates a new appointment and adds it to the ArrayList.
     * Uses polymorphism to handle any HealthProfessional subtype (GP, Paediatrician, etc.)
     * All required information must be supplied, otherwise appointment is not created.
     */
    public static void createAppointment(String patientName, String patientMobile, 
                                        Appointment.TimeSlot timeSlot, HealthProfessional doctor) {
        // Validate that all required information is supplied
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("Error: Patient name is required. Appointment not created.");
            return;
        }
        if (patientMobile == null || patientMobile.trim().isEmpty()) {
            System.out.println("Error: Patient mobile phone is required. Appointment not created.");
            return;
        }
        if (timeSlot == null) {
            System.out.println("Error: Time slot is required. Appointment not created.");
            return;
        }
        if (doctor == null) {
            System.out.println("Error: Doctor must be selected. Appointment not created.");
            return;
        }
        
        // Create and add the appointment
        Appointment newAppointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointments.add(newAppointment);
        System.out.println("Appointment created successfully with ID: " + newAppointment.getAppointmentId());
    }
    
    /**
     * Displays all existing appointments in the ArrayList.
     * If there are no existing appointments, prints a message to indicate this.
     */
    public static void printExistingAppointments() {
        System.out.println("\n========== EXISTING APPOINTMENTS ==========");
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments found.");
        } else {
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println("\n[Appointment " + (i + 1) + "]");
                appointments.get(i).printDetails();
            }
        }
        System.out.println("===========================================\n");
    }
    
    /**
     * Cancels a booking using a patient's mobile phone.
     * If the mobile phone is not found in existing appointments, prints an error message.
     */
    public static void cancelBooking(String patientMobile) {
        if (patientMobile == null || patientMobile.trim().isEmpty()) {
            System.out.println("Error: Mobile phone number is required to cancel booking.");
            return;
        }
        
        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            Appointment apt = appointments.get(i);
            // Check if this appointment matches the mobile and is not already cancelled
            if (apt.getPatientMobile().equals(patientMobile) && apt.getStatus() != Appointment.AppointmentStatus.CANCELLED) {
                apt.cancelAppointment();
                System.out.println("Appointment " + apt.getAppointmentId() + " has been cancelled successfully.");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Error: No active appointment found with mobile phone: " + patientMobile);
        }
    }
}
