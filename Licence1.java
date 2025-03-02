package LicenceManagement;

import java.time.LocalDate;

class License {
    private String licenseID;
    private String userID;
    private String category;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    public License(String licenseID, String userID, String category) {
        this.licenseID = licenseID;
        this.userID = userID;
        this.category = category;
        this.issueDate = LocalDate.now();
        this.expiryDate = this.issueDate.plusYears(5L);
    }

    public String getLicenseID() {
        return this.licenseID;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getCategory() {
        return this.category;
    }

    public LocalDate getIssueDate() {
        return this.issueDate;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(this.expiryDate);
    }

    public String toString() {
        String var10000 = this.licenseID;
        return "LicenseID: " + var10000 + ", Category: " + this.category + ", Issue Date: " + String.valueOf(this.issueDate) + ", Expiry Date: " + String.valueOf(this.expiryDate);
    }
}
