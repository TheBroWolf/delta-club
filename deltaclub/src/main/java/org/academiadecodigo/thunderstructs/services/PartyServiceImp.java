package org.academiadecodigo.thunderstructs.services;


import org.academiadecodigo.thunderstructs.models.Party;
import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.academiadecodigo.thunderstructs.utils.errors.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImp implements PartyService{

    private ClubDB clubDB;
    private UserService userService;


    public void addUser(int id, int partyId){

        try {
            User user = clubDB.getUsers().get(id - 1);
            Party party = clubDB.getParties().get(partyId - 1);

            if (user == null || party == null) {
                throw new CustomerNotFoundException();
            }

            party.getUsers().add(user);

        }catch (CustomerNotFoundException ex){
            System.out.println("No customer/party with that id");
        }

    }


    @Autowired
    public void setClubDB(ClubDB clubDB) {
        this.clubDB = clubDB;
    }

    public ClubDB getClubDB() {
        return clubDB;
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
