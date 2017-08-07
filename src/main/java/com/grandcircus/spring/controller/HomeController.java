package com.grandcircus.spring.controller;


import com.test.models.RegisFormEntity;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.*;



import java.sql.Timestamp;

/**
 * Created by trina2 on 8/4/17.
 */


@Controller
public class HomeController {


    @RequestMapping("/")
    public ModelAndView helloWorld() {

        return new ModelAndView("registration", "result", "");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView RegisFormEntity() {
        return new ModelAndView("registration", "command", new RegisFormEntity());
    }

    @RequestMapping(value = "/confirmation", method = RequestMethod.POST)

//    public ModelAndView addUser(@RequestParam("fName") String fName,
    public ModelAndView addUser(@RequestParam("fName") String fName,
                                @RequestParam("lName") String lName,
                                @RequestParam("add1") String add1,
                                @RequestParam("add2") String add2,
                                @RequestParam("city") String city,
                                @RequestParam("state") String state,
                                @RequestParam("zCode") int zCode,
                                @RequestParam("country") String country) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session session = sessionFact.openSession();

        Transaction tx = session.beginTransaction();

        RegisFormEntity newCust = new RegisFormEntity();

        newCust.setFirstName(fName);
        newCust.setLastName(lName);
        newCust.setAddress1(add1);
        newCust.setAddress2(add2);
        newCust.setCity(city);
        newCust.setState(state);
        newCust.setZipCode(zCode);
        newCust.setCountry(country);

        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);

        newCust.setDate(Timestamp.valueOf(currentTime));


        session.save(newCust);
        tx.commit();
        session.close();


        return new ModelAndView("confirmation", "user", newCust);


    }

    @RequestMapping(value = "/adminreport")
    public ModelAndView listItems() {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFact = cfg.buildSessionFactory();
        Session session = sessionFact.openSession();

        session.beginTransaction();

        Criteria c = session.createCriteria(RegisFormEntity.class);

        ArrayList<RegisFormEntity> userList = (ArrayList<RegisFormEntity>) c.addOrder(Order.desc("date")).list();

        return new ModelAndView("adminreport", "list", userList);

    }

}









