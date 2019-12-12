package org.academiadecodigo.thunderstructs.services;


import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyService {

    private ClubDB clubDB;


    private UserServiceImp userService;


    public void addUser(int id, int partyID){

    }


    @Autowired
    public void setClubDB(ClubDB clubDB) {
        this.clubDB = clubDB;
    }

    public ClubDB getClubDB() {
        return clubDB;
    }
}
