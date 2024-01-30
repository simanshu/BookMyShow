package com.BookMyShow.bookmyshow.Repository;

import com.BookMyShow.bookmyshow.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
