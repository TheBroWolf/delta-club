package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.User;

public interface AuthService {

    boolean addRegistration (User user);

    boolean authenticate (String username, String password);



}
