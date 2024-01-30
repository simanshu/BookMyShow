package com.BookMyShow.bookmyshow.Controller;

import com.BookMyShow.bookmyshow.Request.AddShowRequest;
import com.BookMyShow.bookmyshow.Request.AddShowSeatRequest;
import com.BookMyShow.bookmyshow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/AddShow")
    public ResponseEntity AddShow(@RequestBody AddShowRequest addShowRequest){
        try {
            String result = showService.AddShow(addShowRequest);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/AddShowSeat")
    public String AddShowSeat(@RequestBody AddShowSeatRequest addShowSeatRequest){
        String result=showService.AddShowSeat(addShowSeatRequest);
        return result;
    }


}
