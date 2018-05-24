package com.project.spring.controller;

import com.project.spring.model.Type;
import com.project.spring.model.User;
import com.project.spring.service.TypeService;
import com.project.spring.service.TypeServiceImpl;
import com.project.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Controllers {

    private UserService userService;
    private TypeService typeService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired(required = true)
    @Qualifier(value = "typeService")
    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String currentUser(Model model){
        model.addAttribute("user", new User());
        //model.addAttribute("listUsers", this.userService.listUsers());
        return "jsp/SignIn";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(Model model){
        User current = this.userService.getCurrent();
        if (current != null){
            model.addAttribute("user", current);
        }
        else model.addAttribute("user", new User());
        //model.addAttribute("listUsers", this.userService.listUsers());
        return "jsp/SignUp";
    }

    @RequestMapping(value = "/Stamina", method = RequestMethod.GET)
    public String startPage(Model model){
//        User current = this.userService.getCurrent();
//        if (current != null) {
//            model.addAttribute("user", current);
            model.addAttribute("user", new User());
//        }
        return "jsp/Stamina";
    }

    @RequestMapping(value = "/type/{lang}", method = RequestMethod.GET)
    public String type(Model model, @PathVariable("lang") String lang){
        model.addAttribute("type", new Type(lang));
        model.addAttribute("text", typeService.getLangText(lang));
        User current = this.userService.getCurrent();
        if (current != null){
            model.addAttribute("user", current);
        }
        else model.addAttribute("user", new User());
        //model.addAttribute("listUsers", this.userService.listUsers());
        return "jsp/Type";
    }


    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@ModelAttribute("user") User user){
        if (user.getName().equals("") || user.getPassword().equals("")) {
            return "redirect:/signIn";
        }
        User outdated = this.userService.getCurrent();
        if (outdated != null){
            outdated.setCurrent(false);
            this.userService.updateUser(outdated);
        }
        User newCurrent = this.userService.getByNameAndPass(user.getName(), user.getPassword());
        newCurrent.setCurrent(true);
        this.userService.updateUser(newCurrent);
        if (user.getName().equals("") || user.getPassword().equals("")) {
            return "redirect:/signIn";
        }

        return "redirect:/Stamina";
    }

    @RequestMapping(value = "/signIn/signUp", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") User user){
        if (user.getId() == 0){
            for (User u : this.userService.listUsers()){
                if (u != user) {
                    u.setCurrent(false);
                    this.userService.updateUser(u);
                }
            }
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }
        return "redirect:/Stamina";
    }

    @RequestMapping(value = "/signIn/signUp/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("user") User user){
        User current = this.userService.getCurrent();
        current.setName(user.getName());
        current.setEmail(user.getEmail());
        this.userService.updateUser(current);
        return "redirect:/signUp";
    }

    @RequestMapping(value = "/signIn/signUp/editPass", method = RequestMethod.POST)
    public String editPass(@RequestParam(value="password") String pass, @RequestParam(value="newPass") String newPass){
        User current = this.userService.getCurrent();
        if (current.getPassword().equals(pass)){
            current.setPassword(newPass);
            this.userService.updateUser(current);
        }
        return "redirect:/signUp";
    }

    @RequestMapping(value = "/stype", method = RequestMethod.POST)
    public String setType(@RequestParam(value="language") String lang){
        return "redirect:/type/" + lang;
    }

    @RequestMapping("/logout/{id}")
    public String logOut(@PathVariable("id") int id){
        User user = this.userService.getCurrent();
        user.setCurrent(false);
        this.userService.updateUser(user);
        return "redirect:/Stamina";
    }

    @RequestMapping(value = "edit/{name}", method = RequestMethod.GET)
    public String editUser(Model model){
        model.addAttribute("user", this.userService.getCurrent());
        return "jsp/Edit";
    }
}
