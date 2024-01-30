package com.BookMyShow.bookmyshow.Entity;

import com.BookMyShow.bookmyshow.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "show_seat")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private int price;

    private boolean isAvailable;

    private boolean foodAttached;

    private String seatNo; //These values will

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType; //come from the Theater seats
    //based on mapping or seat structure

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Show show;
}
