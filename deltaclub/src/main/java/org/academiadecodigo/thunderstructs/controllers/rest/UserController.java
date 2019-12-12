package org.academiadecodigo.thunderstructs.controllers.rest;

import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.services.UserService;
import org.academiadecodigo.thunderstructs.services.UserServiceImp;
import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {


    private UserService userService;


    @RequestMapping(method = RequestMethod.GET, path = {"/{userId}"})
    public ResponseEntity<User> getUser (@PathVariable int userId) {

        User user = userService.getUser(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {

        UserController userController = new UserController();
        UserServiceImp userServiceImp = new UserServiceImp();
        ClubDB clubDB = new ClubDB();

        userServiceImp.setClubDB(clubDB);
        userController.setUserService(userServiceImp);

        System.out.println(userController.getUser(1));

    }
}
