package vttp2023.batch3.assessment.paf.bookings.models;

public class AccomDetails {
    
    private String accommodationId;
    private String description;
    private String image;
    private String street;
    private String suburb;
    private String country;
    private Float price;
    private String amenities;
    
    public String getAccommodationId() {
        return accommodationId;
    }
    public void setaccommodationId(String accommodationId) {
        this.accommodationId = accommodationId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getSuburb() {
        return suburb;
    }
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public String getAmenities() {
        return amenities;
    }
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public AccomDetails() {}

    public AccomDetails(String accommodationId, String description, String image, String street, String suburb, String country,
            Float price, String amenities) {
        this.accommodationId = accommodationId;
        this.description = description;
        this.image = image;
        this.street = street;
        this.suburb = suburb;
        this.country = country;
        this.price = price;
        this.amenities = amenities;
    }

    
}
