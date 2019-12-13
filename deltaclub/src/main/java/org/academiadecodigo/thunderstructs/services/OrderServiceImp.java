package org.academiadecodigo.thunderstructs.services;

import org.academiadecodigo.thunderstructs.models.Drink;
import org.academiadecodigo.thunderstructs.models.Order;
import org.academiadecodigo.thunderstructs.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {

    private UserService userService;


    private void addToOrder (int id, Drink drink){

        User user = userService.getUser(id);
        Order order = user.getOrder();

        if(user.getBalance() > drink.getPrice()) {
            order.getDrinks().add(drink);
        }

    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }

}
