package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.models.Party;
import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.services.PartyServiceImp;
import org.academiadecodigo.thunderstructs.services.UserServiceImp;
import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class PartyController {

    private ClubDB clubDB;
    private PartyServiceImp partyService;

    @Autowired
    public void setPartyService(PartyServiceImp partyService) {
        this.partyService = partyService;
    }

    @Autowired
    public void setClubDB(ClubDB clubDB) {
        this.clubDB = clubDB;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/parties")
    public ResponseEntity<List<Party>> showParties() {

        List<Party> parties = clubDB.getParties();

        return new ResponseEntity<>(parties, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/join")
    public ResponseEntity<?> joinParty(User user, Party party){


        if(user.getBalance() < party.getEntryPrice()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        partyService.addUser(user.getId(), party.getPartyID());

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
