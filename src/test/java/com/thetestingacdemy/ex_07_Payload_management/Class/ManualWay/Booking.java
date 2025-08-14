package com.thetestingacdemy.ex_07_Payload_management.Class.ManualWay;

public class Booking {
    private String FirstName;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        TotalPrice = totalPrice;
    }

    public Boolean getDepositePaid() {
        return DepositePaid;
    }

    public void setDepositePaid(Boolean depositePaid) {
        DepositePaid = depositePaid;
    }

    public String getAdditionalNeeds() {
        return AdditionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        AdditionalNeeds = additionalNeeds;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    private String LastName;
    private Integer TotalPrice;
    private Boolean DepositePaid;
    private  String AdditionalNeeds;
    private BookingDates bookingDates;


}
