package LicenceManagement;

import java.util.Scanner;

public class LicenceManagementSystem {
    public void LicenseManagementSystem() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        while(true) {
            System.out.println("\n===== LICENSE MANAGEMENT SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        userManager.registerUser(scanner);
                        break;
                    case 2:
                        User user = userManager.loginUser(scanner);
                        if (user != null) {
                            if (user instanceof Admin) {
                                ((Admin)user).adminDashboard(scanner);
                            } else {
                                ((NormalUser)user).userDashboard(scanner);
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Exiting the system. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
