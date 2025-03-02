package LicenceManagement;

import java.util.ArrayList;
import java.util.HashMap;

class ApplicationManager {
    private static ArrayList<Application> applications = new ArrayList();
    private static HashMap<String, License> issuedLicenses = new HashMap();

    ApplicationManager() {
    }

    public static void submitApplication(Application application) {
        applications.add(application);
        System.out.println("Application submitted successfully! Your Application ID: " + application.getApplicationID());
    }

    public static ArrayList<Application> getPendingApplications() {
        ArrayList<Application> pending = new ArrayList();

        for(Application app : applications) {
            if (app.getStatus().equals("Pending")) {
                pending.add(app);
            }
        }

        return pending;
    }

    public static Application getApplicationByUser(String userID) {
        for(Application app : applications) {
            if (app.getUserID().equals(userID)) {
                return app;
            }
        }

        return null;
    }

    public static void approveApplication(String applicationID, String adminID) {
        for(Application app : applications) {
            if (app.getApplicationID().equals(applicationID) && app.getStatus().equals("Pending")) {
                app.approve();
                License newLicense = new License("L" + issuedLicenses.size(), app.getUserID(), app.getRequestedCategory());
                issuedLicenses.put(app.getUserID(), newLicense);
                System.out.println("Application approved. License issued: " + String.valueOf(newLicense));
                return;
            }
        }

        System.out.println("Application not found or already processed.");
    }

    public static void rejectApplication(String applicationID) {
        for(Application app : applications) {
            if (app.getApplicationID().equals(applicationID) && app.getStatus().equals("Pending")) {
                app.reject();
                System.out.println("Application " + applicationID + " has been rejected.");
                return;
            }
        }

        System.out.println("Application not found or already processed.");
    }

    public static License getLicenseByUser(String userID) {
        return (License)issuedLicenses.get(userID);
    }
}
