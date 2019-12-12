package org.academiadecodigo.thunderstructs.models;

import java.util.LinkedList;
import java.util.List;

public class Party {

    private int partyID;
    private int entryPrice;
    private List<User> users;
    private String description;

    public Party () {

        this.users = new LinkedList<>();
    }

    public int getPartyID() {
        return partyID;
    }

    public void setPartyID(int partyID) {
        this.partyID = partyID;
    }

    public int getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(int entryPrice) {
        this.entryPrice = entryPrice;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
