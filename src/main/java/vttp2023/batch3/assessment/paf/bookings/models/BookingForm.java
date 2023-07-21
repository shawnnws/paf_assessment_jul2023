package vttp2023.batch3.assessment.paf.bookings.models;

import java.util.Date;

public class BookingForm {
    
    private String userName;
    private String userEmail;
    private Date arrivalDate;
    private Integer durationOfStayInDays;
    private String accommodationId;

    public BookingForm() {
    }

    public BookingForm(String userName, String userEmail, Date arrivalDate, Integer durationOfStayInDays, String accommodationId) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.arrivalDate = arrivalDate;
        this.durationOfStayInDays = durationOfStayInDays;
        this.accommodationId = accommodationId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Integer getDurationOfStayInDays() {
        return durationOfStayInDays;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDurationOfStayInDays(Integer durationOfStayInDays) {
        this.durationOfStayInDays = durationOfStayInDays;
    }

    public String getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(String accommodationId) {
        this.accommodationId = accommodationId;
    }
    
    public boolean isAllFieldsNotNull() {
        Boolean usernameNull = this.userName == null;
        Boolean userEmailNull = this.userEmail == null;
        Boolean arrivalDateNull = this.arrivalDate == null;
        Boolean durationOfStayInDaysNull = this.durationOfStayInDays == null;
        Boolean accommodationIdNull = this.accommodationId == null;

        System.out.println("usernameNull: " + usernameNull);
        System.out.println("userEmailNull: " + userEmailNull);
        System.out.println("arrivalDateNull: " + arrivalDateNull);
        System.out.println("durationOfStayInDaysNull: " + durationOfStayInDaysNull);
        System.out.println("accommodationIdNull: " + accommodationIdNull);

        return this.userName != null && this.userEmail != null && this.arrivalDate != null && this.durationOfStayInDays != null && this.accommodationId != null;
    }
}
