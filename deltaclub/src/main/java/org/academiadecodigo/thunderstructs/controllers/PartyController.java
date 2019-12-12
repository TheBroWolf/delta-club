package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.models.Party;
import org.academiadecodigo.thunderstructs.services.PartyServiceImp;
import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
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
    public ResponseEntity<List<Party>> showParties(Model model){

        List<Party> parties = clubDB.getParties();

        return new ResponseEntity<>(parties, HttpStatus.OK);
    }


}
