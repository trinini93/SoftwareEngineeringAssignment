package com.grandcircus.spring.controller;


import com.test.models.RegisFormEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.hibernate.cfg.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by trina2 on 8/4/17.
 */


@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView helloWorld() {

//        ArrayList<RegisFormEntity> items = Dao.listItems(); //created a method
//
//        System.out.println(items);

        return new ModelAndView("registration", "result", "");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView RegisFormEntity() {
        return new ModelAndView("registration", "command", new RegisFormEntity());
    }

    @RequestMapping(value = "/confirmation", method = RequestMethod.POST)
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

        newCust.setFirstName("fName");
        newCust.setLastName("lName");
        newCust.setAddress1("add1");
        newCust.setAddress2("add2");
        newCust.setCity("city");
        newCust.setState("state");
        newCust.setZipCode(zCode);
        newCust.setCountry("country");

        session.save(newCust);
        tx.commit();
        session.close();



        return new ModelAndView("confirmation", "user", newCust);



    }

}

//    public String addUser(RegisFormEntity registration, Model model) {
//        model.addAttribute("fName", registration.getFirstName());
//        model.addAttribute("lName", registration.getLastName());
//        model.addAttribute("add1", registration.getAddress1());
//        model.addAttribute("add2", registration.getAddress2());
//        model.addAttribute("city", registration.getCity());
//        model.addAttribute("state", registration.getState());
//        model.addAttribute("zCode", registration.getZipCode());
//        model.addAttribute("country", registration.getCountry());
//
//
//    }
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





