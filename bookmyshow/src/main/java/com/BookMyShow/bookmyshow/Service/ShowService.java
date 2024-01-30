package com.BookMyShow.bookmyshow.Service;
import com.BookMyShow.bookmyshow.CustomException.InvaildMovieException;
import com.BookMyShow.bookmyshow.CustomException.InvaildTheaterException;
import com.BookMyShow.bookmyshow.Entity.*;
import com.BookMyShow.bookmyshow.Enums.SeatType;
import com.BookMyShow.bookmyshow.Repository.MovieRepository;
import com.BookMyShow.bookmyshow.Repository.ShowRepository;
import com.BookMyShow.bookmyshow.Repository.ShowSeatRepository;
import com.BookMyShow.bookmyshow.Repository.TheaterRepository;
import com.BookMyShow.bookmyshow.Request.AddShowRequest;
import com.BookMyShow.bookmyshow.Request.AddShowSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;

    public String AddShow(AddShowRequest addShowRequest)throws Exception{
        Movie movie=movieRepository.findMovieByMovieName(addShowRequest.getMovieName());
        if(movie==null){
            throw new InvaildMovieException("Movie name is incorrect");
        }
        Optional<Theater> theaterOptional=theaterRepository.findById(addShowRequest.getTheaterId());
        if(theaterOptional.isEmpty()){
            throw new InvaildTheaterException("Theater Id Invaild");
        }
        Theater theater=theaterOptional.get();
        Show show=new Show(addShowRequest.getShowDate(),addShowRequest.getShowTime());

        show.setMovie(movie);
        show.setTheater(theater);

        movie.getShowList().add(show);
        theater.getShowList().add(show);
        show=showRepository.save(show);
        return "Show Add To Database with ShowID:-"+show.getShowId();
    }

    public String AddShowSeat(AddShowSeatRequest addShowSeatRequest){
        Show show=showRepository.findById(addShowSeatRequest.getShowId()).get();
        Theater theater=show.getTheater();

        List<TheaterSeat> theaterSeatList=theater.getTheaterSeatList();
        List<ShowSeat> showSeatList=new ArrayList<>();

        for(TheaterSeat theaterSeat:theaterSeatList){
            String SeatNo=theaterSeat.getSeatNo();
            SeatType seatType=theaterSeat.getSeatType();

            ShowSeat showSeat=ShowSeat.builder()
                    .foodAttached(false)
                    .isAvailable(true)
                    .show(show)
                    .seatNo(SeatNo)
                    .seatType(seatType)
                    .build();
            if(seatType.equals(SeatType.CLASSIC)){
                showSeat.setPrice(addShowSeatRequest.getPriceForClassicSeats());
            }else{
                showSeat.setPrice(addShowSeatRequest.getPriceForPremiumSeats());
            }
            showSeatList.add(showSeat);

        }
        showSeatRepository.saveAll(showSeatList);
        return "Show Seat Add to DB";
    }
}
