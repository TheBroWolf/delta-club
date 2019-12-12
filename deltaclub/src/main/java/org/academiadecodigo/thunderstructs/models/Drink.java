package org.academiadecodigo.thunderstructs.models;

public enum Drink {

    TEQUILA(3),
    VODKA(3),
    WHISKEY(3.5),
    BEER(1),
    SHOT(1.5),
    LONG_DRINK(4.5),
    RUM(3),
    ARTISAN_BEER(2.5),
    WATER(1);

    private double price;

    Drink(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
