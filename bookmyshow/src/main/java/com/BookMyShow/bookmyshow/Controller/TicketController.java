package com.BookMyShow.bookmyshow.Controller;

import com.BookMyShow.bookmyshow.Request.AddTicketRequest;
import com.BookMyShow.bookmyshow.Response.ShowTicketResponse;
import com.BookMyShow.bookmyshow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @PostMapping("/BookTicket")
    public ResponseEntity BookTicket(@RequestBody AddTicketRequest addTicketRequest){
        try{
            String result=ticketService.BookTicket(addTicketRequest);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/viewticket")
    public ShowTicketResponse viewTicket(@RequestParam("ticketId") Integer ticketId){
        ShowTicketResponse showTicketResponse=ticketService.ViewShow(ticketId);
        return showTicketResponse;
    }
}
