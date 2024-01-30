package com.BookMyShow.bookmyshow.Service;

import com.BookMyShow.bookmyshow.Entity.Movie;
import com.BookMyShow.bookmyshow.Repository.MovieRepository;
import com.BookMyShow.bookmyshow.Request.AddMovieRequest;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieRequest addMovieRequest){
        Movie movie=Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .movieLanguage(addMovieRequest.getMovieLanguage())
                .releaseDate(addMovieRequest.getReleaseDate())
                .duration(addMovieRequest.getDuration())
                .rating(addMovieRequest.getRating())
                .build();
        movie=movieRepository.save(movie);
        return "The movie has been saved with MovieID:-"+movie.getMovieId();
    }
}
