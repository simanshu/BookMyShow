package com.BookMyShow.bookmyshow.Controller;

import com.BookMyShow.bookmyshow.Repository.TheaterRepository;
import com.BookMyShow.bookmyshow.Request.AddTheaterRequest;
import com.BookMyShow.bookmyshow.Request.AddTheaterSeatsRequest;
import com.BookMyShow.bookmyshow.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/addTheater")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest addTheaterRequest){
        String result=theaterService.addTheater(addTheaterRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats(@RequestBody AddTheaterSeatsRequest theaterSeatsRequest){

        String result = theaterService.addTheaterSeats(theaterSeatsRequest);
        return result;
    }
}
