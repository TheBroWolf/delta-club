package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class AuthController {


    private AuthService authService;


    @RequestMapping(method = RequestMethod.POST, value = {"/", ""})
    public ResponseEntity<?> login(String userAndPass) {

        String[] usernameAndPassword = userAndPass.split("#");

        if (authService.authenticate(usernameAndPassword[0], usernameAndPassword[1])) {

            return new ResponseEntity<>(HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST, value = {""})
    public ResponseEntity<?> submitRegistration(@Valid @RequestBody User user, BindingResult bindingResult){ //TODO: configure User properties

        boolean status = authService.addRegistration(user);

        if (bindingResult.hasErrors() || !status) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
