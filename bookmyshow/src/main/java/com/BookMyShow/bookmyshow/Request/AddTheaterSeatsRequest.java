package com.BookMyShow.bookmyshow.Request;

import lombok.Data;

@Data
public class AddTheaterSeatsRequest {
    private int noOfClassicSeats;
    private int noOfPremiumSeats;
    private int theaterId;
}
