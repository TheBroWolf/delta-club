package org.academiadecodigo.thunderstructs.controllers;

import org.academiadecodigo.thunderstructs.models.User;
import org.academiadecodigo.thunderstructs.models.VipSpot;
import org.academiadecodigo.thunderstructs.models.VipUser;
import org.academiadecodigo.thunderstructs.services.VipUserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
public class VipUserController {

    private VipUserServiceImp vipUserServiceImp;


    @RequestMapping(method = RequestMethod.GET, value = "/reserveRoom")
    public ResponseEntity<List<VipSpot>> ListRooms() {

        List<VipSpot> spotList = new LinkedList<>();
        spotList.addAll(Arrays.asList(VipSpot.values()));
        return new ResponseEntity<>(spotList, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST ,value = "/reserveRoom/{id}")
    public ResponseEntity<?> chooseRoom(@PathVariable int id, int vipUserId){

        User user = vipUserServiceImp.getUser(vipUserId);

        if(!(user instanceof VipUser)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<VipSpot> spotList = new LinkedList<>();
        spotList.addAll(Arrays.asList(VipSpot.values()));

        vipUserServiceImp.reserveRoom(vipUserId -1, spotList.get(id -1));

        return new ResponseEntity<>(HttpStatus.OK);

    }


    public VipUserServiceImp getVipUserServiceImp() {
        return vipUserServiceImp;
    }

    @Autowired
    public void setVipUserServiceImp(VipUserServiceImp vipUserServiceImp) {
        this.vipUserServiceImp = vipUserServiceImp;
    }


}
