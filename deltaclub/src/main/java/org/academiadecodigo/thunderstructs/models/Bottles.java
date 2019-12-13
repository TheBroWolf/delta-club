package org.academiadecodigo.thunderstructs.models;

public enum Bottles {

    GOOD_WHISKEY(60),
    REGULAR_WHISKEY(40),
    VODKA(30),
    TEQUILA(30),
    RUM(35),
    BEER_BARREL(50);

    private double price;

    Bottles(double price) {
        this.price = price;
    }
}
