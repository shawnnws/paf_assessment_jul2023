package vttp2023.batch3.assessment.paf.bookings.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class SearchInput {
    
    @NotNull(message = "Country field cannot be empty!")
    @NotEmpty(message = "Country field cannot be empty!")
    private String country;

    @Min(value = 1, message = "Number of person must be at least 1!")
    @Max(value = 10, message = "Number of person must be below 10!")
    private int numberOfPerson;

    @Min(value = 1, message = "Price range must be at least 1!")
    private Float minPriceRange;

    @Max(value = 10000, message = "Price must be below 10000!")
    private Float maxPriceRange;

    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberOfPerson() {
        return this.numberOfPerson;
    }
    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public Float getMinPriceRange() {
        return this.minPriceRange;
    }
    public void setMinPriceRange(Float minPriceRange) {
        this.minPriceRange = minPriceRange;
    }

    public Float getMaxPriceRange() {
        return this.maxPriceRange;
    }
    public void setMaxPriceRange(Float maxPriceRange) {
        this.maxPriceRange = maxPriceRange;
    }

    public SearchInput() {}

    public SearchInput(String country, int numberOfPerson, Float minPriceRange, Float maxPriceRange) {
        this.country = country;
        this.numberOfPerson = numberOfPerson;
        this.minPriceRange = minPriceRange;
        this.maxPriceRange = maxPriceRange;
    }
}
