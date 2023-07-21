package vttp2023.batch3.assessment.paf.bookings.models;

public class Listing {
    
    private String country;

    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Listing() {}

    public Listing(String country) {
        this.country = country;
    }
}
