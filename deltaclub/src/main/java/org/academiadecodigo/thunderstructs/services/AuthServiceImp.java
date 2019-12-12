package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImp implements AuthService{


    private ClubDB clubDB;

    public void addRegistration(){
        clubDB
    }


    public void authenticate(String username, String password){

    }


    public ClubDB getClubDB() {
        return clubDB;
    }

    @Autowired
    public void setClubDB(ClubDB clubDB) {
        this.clubDB = clubDB;
    }
}
