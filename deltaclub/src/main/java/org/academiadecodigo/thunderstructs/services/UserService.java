package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    private ClubDB clubDB;

    public void getUser(int id){

    }

    public void deposit(){

    }

    public void withdraw(){

    }

    @Autowired
    public void setClubDB(ClubDB clubDB) {
        this.clubDB = clubDB;
    }

    public ClubDB getClubDB() {
        return clubDB;
    }
}
