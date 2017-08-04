package com.grandcircus.spring.controller;

import com.test.models.RegisFormEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

/**
 * Created by trina2 on 8/4/17.
 */


@Controller
public class HomeController {

    private final Dao customersDAO = new Dao();

    @RequestMapping("/")
    public ModelAndView helloWorld() {

        ArrayList<RegisFormEntity> items = Dao.listItems(); //created a method

        System.out.println(items);

        return new ModelAndView("welcome", "result", items);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView RegisFormEntity() {
        return new ModelAndView("registration", "command", new RegisFormEntity());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(RegisFormEntity registration, Model model) {
        model.addAttribute("fName", registration.getFirstName());
        model.addAttribute("lName", registration.getLastName());
        model.addAttribute("add1", registration.getAddress1());
        model.addAttribute("add2", registration.getAddress2());
        model.addAttribute("city", registration.getCity());
        model.addAttribute("state", registration.getState());
        model.addAttribute("zCode", registration.getZipCode());
        model.addAttribute("country", registration.getCountry());


        Dao dao = new Dao(); //creating an object

        dao.addUser(registration);
        return "summary";

    }
//
//    @RequestMapping("/adminreport")
//    public ModelAndView showItems() {
//        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//        SessionFactory sessionFact = cfg.buildSessionFactory();
//        Session selectCustomers = sessionFact.openSession();
//        selectCustomers.beginTransaction();
//        Criteria c = selectCustomers.createCriteria(RegisFormEntity.class);
//
//
//        ArrayList<RegisFormEntity> itemsList = (ArrayList<RegisFormEntity>) c.list();
//        return new ModelAndView("adminreport", "items", itemsList);
//
//    }


}


