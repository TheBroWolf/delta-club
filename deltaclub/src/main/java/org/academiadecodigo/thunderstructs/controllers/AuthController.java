package org.academiadecodigo.thunderstructs.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {


    @RequestMapping(method = RequestMethod.POST, value = {"/"})
    public void login(){

    }

}
