package org.academiadecodigo.thunderstructs.models;

import org.academiadecodigo.thunderstructs.services.UserService;


import java.util.List;

public class Order {

    private UserService userService;
    private List<Drink> drinks;



    public UserService getUserService() {
        return userService;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }


    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

}
