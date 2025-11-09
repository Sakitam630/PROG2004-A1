public class AssignmentOne {
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
    }
}
