package com.nketu.journal.controller;

import com.nketu.journal.api.response.WeatherResponse;
import com.nketu.journal.entity.User;
import com.nketu.journal.service.UserService;
import com.nketu.journal.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User userInDb = userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        userService.deleteByUserName(userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greetings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        String message = "Hi "+userName;
        WeatherResponse weatherResponse = weatherService.getWeather("Mumbai");
        if (weatherResponse!=null){
            message= message+" weather feels like "+weatherResponse.getCurrent().getFeelslike();
            return new ResponseEntity<>(message,HttpStatus.OK);
        }
        return new ResponseEntity<>(message+". Not able to fetch weather info",HttpStatus.OK);

    }

//   *********** This is delete by id ********************
//    @DeleteMapping
//    public ResponseEntity<?> deleteUser(@RequestBody User user){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userName=authentication.getName();
//        User userInDb = userService.findByUserName(userName);
//        userService.deleteById(userInDb.getId());
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
