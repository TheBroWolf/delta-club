package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.models.Drink;
import org.academiadecodigo.thunderstructs.models.Order;
import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.services.UserService;
import org.academiadecodigo.thunderstructs.services.UserServiceImp;
import org.academiadecodigo.thunderstructs.utils.ClubDB;
import org.academiadecodigo.thunderstructs.utils.errors.EmptyOrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class OrderController {

    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/order")
    private ResponseEntity<List<Drink>> getDrinkList() {

        List<Drink> drinkList = new LinkedList<>();
        drinkList.add(Drink.BEER);
        drinkList.add(Drink.ARTISAN_BEER);
        drinkList.add(Drink.VODKA);
        drinkList.add(Drink.WHISKEY);
        drinkList.add(Drink.WATER);
        drinkList.add(Drink.RUM);
        drinkList.add(Drink.SHOT);
        drinkList.add(Drink.LONG_DRINK);
        drinkList.add(Drink.TEQUILA);

        return new ResponseEntity<>(drinkList, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/confirmOrder")
    private ResponseEntity<?> makeOrder(int userId) {

        User user = userService.getUser(userId);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            List<Drink> orderList = user.getOrder().getDrinks();

            if(user.getOrder() == null){
                throw new EmptyOrderException();
            }

            for (Drink drink : orderList) {
                userService.withdraw(userId, drink.getPrice());
            }


        }catch (EmptyOrderException ex){
            System.out.println("User order is empty");
        }
            return new ResponseEntity<>(HttpStatus.OK);
    }

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }
}
