package LicenceManagement;

import java.util.Scanner;

class NormalUser extends User {
    public NormalUser(String userID, String name, String email, String password, String citizenshipNumber) {
        super(userID, name, email, password, citizenshipNumber);
    }

    public void userDashboard(Scanner scanner) {
        while(true) {
            System.out.println("\n===== USER DASHBOARD =====");
            System.out.println("1. Apply for License");
            System.out.println("2. Check Application Status");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    this.applyForLicense(scanner);
                    break;
                case 2:
                    this.checkStatus();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void applyForLicense(Scanner scanner) {
        System.out.println("Applying for a license...");
        System.out.print("Enter requested category: ");
        String category = scanner.nextLine();
        int var10000 = ApplicationManager.getPendingApplications().size();
        String applicationID = "A" + (var10000 + 1);
        Application application = new Application(applicationID, this.userID, category);
        ApplicationManager.submitApplication(application);
    }

    public void checkStatus() {
        System.out.println("Checking application status...");
        Application application = ApplicationManager.getApplicationByUser(this.userID);
        if (application != null) {
            System.out.println(application);
        } else {
            System.out.println("No application found.");
        }

    }

    public void displayDashboard() {
        System.out.println("Welcome to Normal User Dashboard!");
    }
}
