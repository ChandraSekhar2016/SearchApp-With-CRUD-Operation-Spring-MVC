/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.SpringMaven.Controller;

import com.leapfrog.SpringMaven.DAO.UserDAO;
import com.leapfrog.SpringMaven.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

    //@ResponseBody
    /*public String index(){
     return "<h1>Hello from Spring</h1>";
     }
    */
    
     @RequestMapping(method = RequestMethod.GET)
     public String index(Model model) {
         
     return "index";
     }
     
   @Autowired
    private UserDAO userDAO;

    @RequestMapping(value="/search", method = RequestMethod.GET)
    public String search(Model model,@RequestParam("pattern") String pattern) {
        try {
            if (pattern == null) {
                model.addAttribute("users", userDAO.getAll());
            } else {
                model.addAttribute("users", userDAO.Search(pattern));
            }
        } catch (Exception ex) {

        }
        return "index";
    }

    //while edit query string value comes so pathVariable
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") int id) {

        try {

            model.addAttribute("user", userDAO.getById(id));

        } catch (Exception ex) {

        }

        return "edit";
    }

    //while save form parameter comes(

    @RequestMapping(value = "/save")
    public String save(User user) {
        try {
            if (user.getId() == 0) {
                userDAO.insert(user);
            } else {
                userDAO.update(user);
            }
        } catch (Exception ex) {

        }
        return "redirect:/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "addUser";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        try {
            userDAO.delete(id);
        } catch (Exception ex) {

        }
        return "redirect:/";
    }

}
