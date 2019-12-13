package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService{


    private ClubDB clubDB;


    public User getUser(int id){

        return clubDB.getUsers().get(id - 1);
    }

    public User getUserByName (String username) {

        for (User u : clubDB.getUsers()) {

            if (u.getUsername().equals(username)) {

                return u;
            }
        }

        return null;
    }

    @Override
    public boolean deposit(int userID, double amount) {

        User user = clubDB.getUsers().get(userID - 1);

        double userBalance = user.getBalance();
        user.setBalance(userBalance + amount);

        return true;
    }

    @Override
    public boolean withdraw(int userID, double amount) {

        System.out.println("Teste" + userID);

        User user = clubDB.getUsers().get(userID - 1);

        if ((user.getBalance() - amount) >= 0) {

            return true;
        }

        return false;
    }


    @Autowired
    public void setClubDB(ClubDB clubDB) {
        this.clubDB = clubDB;
    }





    //### TEST ###
    public static void main(String[] args) {

        ClubDB clubDB = new ClubDB();
        UserServiceImp userServiceImp = new UserServiceImp();
        userServiceImp.setClubDB(clubDB);

        User user = clubDB.getUsers().get(1);

        System.out.println("Teste1: " + userServiceImp.getUser(1).getUsername());

        System.out.println("User balance: " + user.getBalance());
        System.out.println("Withdraw 80 with Balance 77: " + userServiceImp.withdraw(user.getId() , 80));
    }
}


