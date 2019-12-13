package org.academiadecodigo.thunderstructs.utils;

import org.academiadecodigo.thunderstructs.models.*;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ClubDB {

    private List<Party> parties;
    private List<User> users;
    private List<LoginObj> loginObjList;
    private List<VipSpot> vipSpots;


    public ClubDB() {
        populate();
    }

    private void populate() {
        parties = new LinkedList<>();
        users = new LinkedList<>();
        loginObjList = new LinkedList<>();
        vipSpots = new LinkedList<>();

        List<Drink> drinks1 = new LinkedList<>();
        drinks1.add(Drink.VODKA);
        drinks1.add(Drink.SHOT);

        List<Drink> drinks2 = new LinkedList<>();
        drinks2.add(Drink.RUM);
        drinks2.add(Drink.TEQUILA);
        drinks2.add(Drink.BEER);
        drinks2.add(Drink.BEER);
        drinks2.add(Drink.ARTISAN_BEER);
        drinks2.add(Drink.SHOT);


        List<Drink> drinks3 = new LinkedList<>();
        drinks3.add(Drink.BEER);

        Order order1 = new Order();
        order1.setDrinks(drinks1);

        Order order2 = new Order();
        order2.setDrinks(drinks2);

        Order order3 = new Order();
        order3.setDrinks(drinks3);


        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        VipUser vipUser1 = new VipUser();
        VipUser vipUser2 = new VipUser();


        LoginObj loginObj1 = new LoginObj();
        LoginObj loginObj2 = new LoginObj();
        LoginObj loginObj3 = new LoginObj();
        LoginObj loginObj4 = new LoginObj();
        LoginObj loginObj5 = new LoginObj();
        LoginObj loginObj6 = new LoginObj();

        Party party1 = new Party();
        party1.setDescription("The best party ever thrown by the legendary ThunderSTRUCTs!");
        party1.setEntryPrice(7);
        party1.setPartyID(1);
        party1.getUsers().add(user1);
        party1.getUsers().add(user2);
        party1.getUsers().add(vipUser1);

        user1.setId(1);
        user1.setUsername("Nuno");
        user1.setBalance(30);
        user1.setPassword("nuno1234");
        user1.setOrder(order1);
        loginObj1.setId(1);
        loginObj1.setUsername("nuno18");
        loginObj1.setPassword("nuno1234");

        user2.setId(2);
        user2.setUsername("Goncalo");
        user2.setBalance(77);
        user2.setPassword("goncalo1234");
        user2.setOrder(order2);
        loginObj2.setId(2);
        loginObj2.setUsername("goncFF");
        loginObj2.setPassword("goncalo1234");

        user3.setId(3);
        user3.setUsername("Vasco");
        user3.setBalance(20);
        user3.setPassword("vasco1234");
        user3.setOrder(order1);
        loginObj3.setId(3);
        loginObj3.setUsername("broWolf");
        loginObj3.setPassword("vasco1234");

        user4.setId(4);
        user4.setUsername("Filipa");
        user4.setBalance(6);
        user4.setPassword("filipa1234");
        user4.setOrder(order1);
        loginObj4.setId(4);
        loginObj4.setUsername("coolFilipa");
        loginObj4.setPassword("filipa1234");

        vipUser1.setId(5);
        vipUser1.setUsername("Luis");
        vipUser1.setBalance(500);
        vipUser1.setPassword("luis1234");
        vipUser1.setOrder(order2);
        loginObj5.setId(5);
        loginObj5.setUsername("luisBoss");
        loginObj5.setPassword("luis1234");

        vipUser2.setId(6);
        vipUser2.setUsername("Francisco");
        vipUser2.setBalance(899);
        vipUser2.setPassword("francisco1234");
        vipUser2.setOrder(order3);
        loginObj5.setId(6);
        loginObj5.setUsername("chico");
        loginObj5.setPassword("francisco1234");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(vipUser1);
        users.add(vipUser2);

        loginObjList.add(loginObj1);
        loginObjList.add(loginObj2);
        loginObjList.add(loginObj3);
        loginObjList.add(loginObj4);
        loginObjList.add(loginObj5);
        loginObjList.add(loginObj6);


        parties.add(party1);
    }

    public List<Party> getParties() {
        return parties;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<LoginObj> getLoginObjList() {
        return loginObjList;
    }

    public List<VipSpot> getVipSpots() {
        return vipSpots;
    }
}


