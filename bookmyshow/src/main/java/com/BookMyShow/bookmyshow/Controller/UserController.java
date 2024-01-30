package com.BookMyShow.bookmyshow.Controller;
import com.BookMyShow.bookmyshow.Request.AddUserRequest;
import com.BookMyShow.bookmyshow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/AddUser")
    public ResponseEntity AddUser(@RequestBody AddUserRequest addUserRequest){
        String result=userService.AddUser(addUserRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
