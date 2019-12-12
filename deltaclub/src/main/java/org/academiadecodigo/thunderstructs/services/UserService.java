package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.User;

public interface UserService {

    User getUser(int id);

    boolean deposit(int userID, int amount);

    boolean withdraw(int userID, int amount);


}
