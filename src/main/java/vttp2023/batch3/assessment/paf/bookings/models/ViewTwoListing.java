package vttp2023.batch3.assessment.paf.bookings.models;

public class ViewTwoListing {
    
    private String accommodationId;
    private String name;
    private Float price;
    private String image;

    public String getAccommodationId() {
        return this.accommodationId;
    }
    public void setAccommodationId(String accommodationId) {
        this.accommodationId = accommodationId;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public ViewTwoListing() {}

    public ViewTwoListing(String accommodationId, String name, Float price, String image) {
        this.accommodationId = accommodationId;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    
}
