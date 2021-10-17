package com.SpringDemo.bank.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllers {

    @Autowired
    bank b;

    @RequestMapping(value = "/bankinfo")
    public String bank() throws Exception {
//        return b.displayInfo();
        return "hai this is just working i dono how to return the whole databasse or the data from hasmap here";
    }

}
