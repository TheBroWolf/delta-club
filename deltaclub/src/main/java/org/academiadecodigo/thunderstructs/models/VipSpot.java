package org.academiadecodigo.thunderstructs.models;

public enum VipSpot {

    ROOM1(100, false, 1),
    ROOM2(150, true, 2),
    ROOM3(200, true, 3),
    ROOM4( 150, true, 4);

    private double price;
    private boolean available;
    private int id;


    VipSpot(double price, boolean available, int id) {
        this.price = price;
        this.available = available;
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }
}
