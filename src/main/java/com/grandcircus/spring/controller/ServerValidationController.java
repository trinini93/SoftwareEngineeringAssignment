package com.grandcircus.spring.controller;
import com.test.models.RegisFormEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping("/registration")
@SessionAttributes("fName")
public class ServerValidationController {

    RegisFormEntity firstName = new RegisFormEntity();


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView RegisFormEntity() {
        return new ModelAndView("registration", "command", new RegisFormEntity());
    }

    @RequestMapping(value = "/confirmation", method = RequestMethod.POST)
public ModelAndView addUser(@RequestParam("firstName") String fName, BindingResult result, SessionStatus status) {


        //Validation code start
        boolean wrong = false;

        System.out.println(fName); //Verifying if information is same as input by user

        if (firstName.getFirstName().isEmpty()) {
            result.rejectValue("firstName", "error.firstName");
            wrong = true;
        }
      if (wrong) {
          System.out.println("test");
      }

            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sessionFact = cfg.buildSessionFactory();
            Session session = sessionFact.openSession();

            Transaction tx = session.beginTransaction();

            RegisFormEntity serverValid = new RegisFormEntity();
            serverValid.setFirstName(fName);

            session.save(serverValid);
            tx.commit();
            session.close();


            return new ModelAndView("confirmation", "user", serverValid);


        }
    }









//    @RequestMapping(method = RequestMethod.POST)
//    public String submitForm(@ModelAttribute("fName") RegisFormEntity fName,
//                             BindingResult result, SessionStatus status)
//    {
//        //Store the employee information in database
//        firstName.setFirstName("fName");
//
//        //Mark Session Complete
//        status.setComplete();
//        return "redirect:addNew/success";
//    }
//
//    @RequestMapping(value = "/success", method = RequestMethod.GET)
//    public String success(Model model)
//    {
//        return "confirmation";
//    }

