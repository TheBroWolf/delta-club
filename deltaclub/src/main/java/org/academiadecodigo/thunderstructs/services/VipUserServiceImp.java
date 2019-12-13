package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.models.VipSpot;
import org.academiadecodigo.thunderstructs.models.VipUser;
import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VipUserServiceImp implements UserService {

    private ClubDB clubDB;


    @Override
    public User getUser(int id) {

        return clubDB.getUsers().get(id - 1);
    }

    @Override
    public boolean deposit(int userID, double amount) {

        User user = clubDB.getUsers().get(userID - 1);

        user.setBalance(user.getBalance() + amount);

        return true;

    }

    @Override
    public boolean withdraw(int userID, double amount) {

        User user = clubDB.getUsers().get(userID - 1);
        if (user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            return true;

        }

        return false;
    }


    public void reserveRoom(int vipUserId, VipSpot vipSpot){

        User user = clubDB.getUsers().get(vipUserId -1);

        if(!vipSpot.isAvailable() || !(user instanceof VipUser) ){
            return;
        }

        vipSpot.setAvailable(false);
        ((VipUser) user).setVipSpot(vipSpot);

    }

    public ClubDB getClubDB() {
        return clubDB;
    }

    @Autowired
    public void setClubDB(ClubDB clubDB) {
        this.clubDB = clubDB;
    }
}
