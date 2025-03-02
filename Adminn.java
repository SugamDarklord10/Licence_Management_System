package LicenceManagement;

import java.util.Scanner;

class Admin extends User {
    public Admin(String userID, String name, String email, String password, String citizenshipNumber) {
        super(userID, name, email, password, citizenshipNumber);
    }

    public void adminDashboard(Scanner scanner) {
        while(true) {
            System.out.println("\n** WELCOME TO ADMIN DASHBOARD **");
            System.out.println("1. View The Pending Applications:");
            System.out.println("2. Approve/Reject Application:");
            System.out.println("3. Generate Reports:");
            System.out.println("4. --Logout--");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    this.viewPendingApplications();
                    break;
                case 2:
                    this.processApplication(scanner);
                    break;
                case 3:
                    this.generateReports();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void viewPendingApplications() {
        System.out.println("Viewing pending applications...");

        for(Application app : ApplicationManager.getPendingApplications()) {
            System.out.println(app);
        }

    }

    public void processApplication(Scanner scanner) {
        System.out.print("Enter application ID to approve/reject: ");
        String appId = scanner.nextLine();
        System.out.print("Approve or Reject (A/R): ");
        String decision = scanner.nextLine().toUpperCase();
        if (decision.equals("A")) {
            ApplicationManager.approveApplication(appId, this.userID);
        } else if (decision.equals("R")) {
            ApplicationManager.rejectApplication(appId);
        } else {
            System.out.println("Invalid decision. Please enter 'A' to approve or 'R' to reject.");
        }

    }

    public void generateReports() {
        System.out.println("Generating reports...");
        System.out.println("Total Applications: " + ApplicationManager.getPendingApplications().size());
        System.out.println("Total Licenses Issued: " + String.valueOf(ApplicationManager.getLicenseByUser(this.userID)));
    }

    public void displayDashboard() {
        System.out.println("Welcome to Admin Dashboard!");
    }
}
