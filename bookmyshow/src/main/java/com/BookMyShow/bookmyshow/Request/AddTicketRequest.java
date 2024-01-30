package com.BookMyShow.bookmyshow.Request;

import com.BookMyShow.bookmyshow.Enums.SeatType;
import lombok.Data;

import java.util.List;

@Data
public class AddTicketRequest {
    public int showId;
    public List<String> seatList;
    private SeatType seatType;
    public String EmailID; //You can take the userId
}
