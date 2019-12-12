package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {


    private AuthService authService;


    @RequestMapping(method = RequestMethod.POST, value = {"/"})
    public void login(){

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User>submitRegistration(@Valid @RequestBody User user, BindingResult bindingResult, @PathVariable Integer id){

        authService.addRegistration();
    }


    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
