package com.BookMyShow.bookmyshow.Repository;

import com.BookMyShow.bookmyshow.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailId(String EmailId);

}
