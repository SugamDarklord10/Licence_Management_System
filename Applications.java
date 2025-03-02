package LicenceManagement;

class Application {
    private String applicationID;
    private String userID;
    private String requestedCategory;
    private String status;

    public Application(String applicationID, String userID, String requestedCategory) {
        this.applicationID = applicationID;
        this.userID = userID;
        this.requestedCategory = requestedCategory;
        this.status = "Pending";
    }

    public void approve() {
        this.status = "Approved";
    }

    public void reject() {
        this.status = "Rejected";
    }

    public String getStatus() {
        return this.status;
    }

    public String getApplicationID() {
        return this.applicationID;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getRequestedCategory() {
        return this.requestedCategory;
    }

    public String toString() {
        return "ApplicationID: " + this.applicationID + ", UserID: " + this.userID + ", Category: " + this.requestedCategory + ", Status: " + this.status;
    }
}

