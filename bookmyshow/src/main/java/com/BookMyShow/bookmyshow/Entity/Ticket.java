package com.BookMyShow.bookmyshow.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tickets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer ticketId;
    private String SeatNoBokked;
    private Integer totalAmountPaid;

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Show show;

    @JoinColumn
    @ManyToOne
    private User user;

}
