package org.academiadecodigo.thunderstructs.models;

import java.util.List;

public class VipUser extends User{


    private VipSpot vipSpot;
    private List<Bottles> bottles;



    public VipSpot getVipSpot() {
        return vipSpot;
    }

    public void setVipSpot(VipSpot vipSpot) {
        this.vipSpot = vipSpot;
    }

    public List<Bottles> getBottles() {
        return bottles;
    }

    public void setBottles(List<Bottles> bottles) {
        this.bottles = bottles;
    }
}
