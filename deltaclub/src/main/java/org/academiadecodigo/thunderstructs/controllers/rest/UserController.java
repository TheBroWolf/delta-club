package org.academiadecodigo.thunderstructs.controllers.rest;

import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserController {


    private UserService userService;


    @RequestMapping(method = RequestMethod.GET, path = {"/{id}", ""})
    public ResponseEntity<User> getUser (@PathVariable int userId) {

        User user = userService.getUser(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
