package org.academiadecodigo.thunderstructs.controllers;


import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.models.dtos.LoginDTO;
import org.academiadecodigo.thunderstructs.services.AuthService;
import org.academiadecodigo.thunderstructs.services.AuthServiceImp;
import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.Valid;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/login")
public class AuthController {


    private AuthService authService;


    @RequestMapping(method = RequestMethod.POST, value = {"/a"})
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO, BindingResult bindingResult) {

        System.out.println(loginDTO.getPassword());
        System.out.println(loginDTO.getUsername());
        System.out.println("LoginDTO Object: " + loginDTO);

        String name = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        if (authService.authenticate(name, password)) {

            return new ResponseEntity<>(HttpStatus.OK);
        }

/*        String[] usernameAndPassword = userAndPass.split("#");

        if (authService.authenticate(usernameAndPassword[0], usernameAndPassword[1])) {

            return new ResponseEntity<>(HttpStatus.OK);

        }*/

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

    public static void main(String[] args) {

        AuthController authController = new AuthController();
        AuthServiceImp authService = new AuthServiceImp();
        ClubDB clubDB = new ClubDB();

        authController.setAuthService(authService);
        authService.setClubDB(clubDB);



    }
}
