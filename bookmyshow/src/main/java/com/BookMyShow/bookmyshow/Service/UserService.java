package com.BookMyShow.bookmyshow.Service;

import com.BookMyShow.bookmyshow.Entity.User;
import com.BookMyShow.bookmyshow.Repository.UserRepository;
import com.BookMyShow.bookmyshow.Request.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String AddUser(AddUserRequest addUserRequest){
        User user=User.builder()
                .Name(addUserRequest.getName())
                .emailId(addUserRequest.getEmailId())
                .build();
        user=userRepository.save(user);
        return "User Add To Database With UserID:-"+user.getUserId();
    }
}
