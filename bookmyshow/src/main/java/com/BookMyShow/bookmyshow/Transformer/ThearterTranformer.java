package com.BookMyShow.bookmyshow.Transformer;

import com.BookMyShow.bookmyshow.Entity.Theater;
import com.BookMyShow.bookmyshow.Request.AddTheaterRequest;

public class ThearterTranformer {
    public static Theater convertRequestToEntity(AddTheaterRequest theaterRequest){

        Theater theater = Theater.builder()
                .address(theaterRequest.getAddress())
                .noOfScreens(theaterRequest.getNoOfScreens())
                .name(theaterRequest.getName())
                .build();

        return theater;
    }
}
