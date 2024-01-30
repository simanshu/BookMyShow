package com.BookMyShow.bookmyshow.Entity;

import com.BookMyShow.bookmyshow.Enums.Genre;
import com.BookMyShow.bookmyshow.Enums.Language;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie_info")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MovieId;
    @Column(unique = true,nullable = false)
    private String movieName;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Enumerated(value = EnumType.STRING)
    private Language movieLanguage;
    private LocalDate releaseDate;

    private double duration;
    private double rating;
    @OneToMany(mappedBy = "movie",cascade=CascadeType.ALL)
    List<Show> showList=new ArrayList<>();


}
