package com.BookMyShow.bookmyshow.Request;

import lombok.Data;

@Data
public class AddTheaterRequest {
    private String name;
    private String address;
    private int noOfScreens;
}
