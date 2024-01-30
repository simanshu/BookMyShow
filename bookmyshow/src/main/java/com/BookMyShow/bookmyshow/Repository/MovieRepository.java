package com.BookMyShow.bookmyshow.Repository;

import com.BookMyShow.bookmyshow.Entity.Movie;
import com.BookMyShow.bookmyshow.Enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieByMovieNameAndAndMovieLanguage(String movieName, Language language);
    Movie findMovieByMovieName(String movieName);

}
