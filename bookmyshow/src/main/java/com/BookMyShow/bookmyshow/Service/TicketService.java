package com.BookMyShow.bookmyshow.Service;

import com.BookMyShow.bookmyshow.Entity.Show;
import com.BookMyShow.bookmyshow.Entity.ShowSeat;
import com.BookMyShow.bookmyshow.Entity.Ticket;
import com.BookMyShow.bookmyshow.Entity.User;
import com.BookMyShow.bookmyshow.Repository.ShowRepository;
import com.BookMyShow.bookmyshow.Repository.TheaterRepository;
import com.BookMyShow.bookmyshow.Repository.TicketRepository;
import com.BookMyShow.bookmyshow.Repository.UserRepository;
import com.BookMyShow.bookmyshow.Request.AddTicketRequest;
import com.BookMyShow.bookmyshow.Response.ShowTicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String BookTicket(AddTicketRequest addTicketRequest) throws Exception{

        Show show=showRepository.findById(addTicketRequest.getShowId()).get();
        List<ShowSeat> showSeatList=show.getShowSeatList();
        int totalamount=0;

        for(String seatNoBooked:addTicketRequest.getSeatList()){
            for(ShowSeat showSeat:showSeatList){
                if(showSeat.getSeatNo().equals(seatNoBooked)&&addTicketRequest.getSeatType().equals(showSeat.getSeatType())){
                    if(showSeat.isAvailable()) {
                        showSeat.setAvailable(false);
                        totalamount=totalamount+showSeat.getPrice();
                    }else{
                        throw new Exception("Seat No"+showSeat.getSeatNo()+"Is already Booked");
                    }
                }
            }
        }
        User user = userRepository.findByEmailId(addTicketRequest.getEmailID());

        Ticket ticket=Ticket.builder()
                .SeatNoBokked(addTicketRequest.getSeatList().toString())
                .totalAmountPaid(totalamount)
                .show(show)
                .user(user)
                .build();
        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);
        ticket=ticketRepository.save(ticket);
        return "This is the Ticket with Ticket ID "+ticket.getTicketId();
    }
    public ShowTicketResponse ViewShow(Integer ticketId){
        Ticket ticket=ticketRepository.findById(ticketId).get();

        Show show=ticket.getShow();
        String movieName=show.getMovie().getMovieName();
        String theaterInfo=show.getTheater().getName()+" "+show.getTheater().getAddress();
        String bookTicket=ticket.getSeatNoBokked();

        ShowTicketResponse showTicketResponse=ShowTicketResponse.builder()
                .movieName(movieName)
                .theaterInfo(theaterInfo)
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .seatNos(bookTicket)
                .totalAmt(ticket.getTotalAmountPaid())
                .build();
        String EmailID=ticket.getUser().getEmailId();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("simanshu1928@gmail.com");
        simpleMailMessage.setTo(EmailID);
        simpleMailMessage.setSubject("Movie Ticket Confirmation");
        simpleMailMessage.setText(showTicketResponse.toString());
        javaMailSender.send(simpleMailMessage);

        return showTicketResponse;
    }
}
