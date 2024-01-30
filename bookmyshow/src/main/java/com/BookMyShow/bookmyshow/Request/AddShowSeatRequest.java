package com.BookMyShow.bookmyshow.Request;

import lombok.Data;

@Data
public class AddShowSeatRequest {
    private int priceForClassicSeats;
    private int priceForPremiumSeats;
    private int showId;
}
