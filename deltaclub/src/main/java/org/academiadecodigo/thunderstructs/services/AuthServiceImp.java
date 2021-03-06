package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthServiceImp implements AuthService {


    private ClubDB clubDB;


    public boolean addRegistration(User user) {

        String username = user.getName();
        List<User> users = clubDB.getUsers();

        for(User u : users){

            if(u.getName().equals(username)){

                return false;
            }
        }

        clubDB.getUsers().add(user);
        return true;
    }


    public boolean authenticate(String username, String password) {

        List<User> users = clubDB.getUsers();


        for (User u : users) {

            System.out.println(u.getName());
            System.out.println(u.getPassword());

            if (u.getName().equals(username) && u.getPassword().equals(password)) {

                return true;
            }

        }

        return false;
    }


    public ClubDB getClubDB() {
        return clubDB;
    }

    @Autowired
    public void setClubDB(ClubDB clubDB) {
        this.clubDB = clubDB;
    }
}
