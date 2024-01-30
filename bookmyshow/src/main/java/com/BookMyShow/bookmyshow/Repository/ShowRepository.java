package com.BookMyShow.bookmyshow.Repository;

import com.BookMyShow.bookmyshow.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Integer> {
}
