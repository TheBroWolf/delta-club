package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.User;

public interface UserService {

    User getUser(int id);

    boolean deposit(int userID, double amount);

    boolean withdraw(int userID, double amount);


}
