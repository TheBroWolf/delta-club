package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.User;

public interface AuthService {

    boolean addRegistration(User user);

    void authenticate(String username, String password);



}
