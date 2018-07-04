package com.project.spring.controller;

import com.project.spring.model.Type;
import com.project.spring.model.User;
import com.project.spring.service.LangService;
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
    private LangService langService;

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

    @Autowired(required = true)
    @Qualifier(value = "langService")
    public void setLangService(LangService langService) {
        this.langService = langService;
    }

    @RequestMapping(value = "/Stamina", method = RequestMethod.GET)
    public String startPage(Model model){
        User current = this.userService.getCurrent();
        if (current != null) {
            model.addAttribute("user", current);
        }
        return "jsp/Stamina";
    }

    @RequestMapping(value = "/Stamina/signIn", method = RequestMethod.GET)
    public String signIn(Model model){
        model.addAttribute("user", new User());
        return "jsp/SignIn";
    }

    @RequestMapping(value = "/Stamina/signUp", method = RequestMethod.GET)
    public String signUp(Model model){
        User current = this.userService.getCurrent();
        if (current != null){
            model.addAttribute("user", current);
        }
        else model.addAttribute("user", new User());
        return "jsp/SignUp";
    }


    @RequestMapping(value = "/Stamina/type/{lang}", method = RequestMethod.GET)
    public String type(Model model, @PathVariable("lang") String lang){
        model.addAttribute("type", new Type(lang));
        model.addAttribute("text", langService.getLangText(lang));
        model.addAttribute("lang", lang);
        User current = this.userService.getCurrent();
        if (current != null){
            model.addAttribute("user", current);
        }
        else model.addAttribute("user", new User());
        //model.addAttribute("listUsers", this.userService.listUsers());
        return "jsp/Type";
    }

    @RequestMapping(value = "/Stamina/edit/{name}", method = RequestMethod.GET)
    public String editUser(Model model){
        model.addAttribute("user", this.userService.getCurrent());
        return "jsp/Edit";
    }


    @RequestMapping(value = "/doSignIn", method = RequestMethod.POST)
    public String signIn(@ModelAttribute("user") User user, Model model){
        if (user.getName().equals("") || user.getPassword().equals("")) {
            return "redirect:/Stamina/signIn";
        }
        User outdated = this.userService.getCurrent();
        if (outdated != null){
            outdated.setCurrent(false);
            this.userService.updateUser(outdated);
        }
        User newCurrent = this.userService.getByNameAndPass(user.getName(), user.getPassword());
        if (newCurrent == null){
            model.addAttribute("errorMess", "Login or password is incorrect!");
            return signIn(model);
        }
        newCurrent.setCurrent(true);
        this.userService.updateUser(newCurrent);

        return "redirect:/Stamina";
    }

    @RequestMapping(value = "/doSignUp", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") User user, Model model){
        for (User u : userService.listUsers()){
            if (u.getEmail().equals(user.getEmail())){
                model.addAttribute("errorEmail", "Email exist already!");
                return signUp(model);
            }
            if (u.getName().equals(user.getName())){
                model.addAttribute("errorName", "Name exists already!");
                return signUp(model);
            }
        }
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

    @RequestMapping(value = "/Stamina/type/{lang}", method = RequestMethod.POST)
    public String dotype(@ModelAttribute("type") Type type, Model model){
        User current = this.userService.getCurrent();
        if (current != null){
            type.setUserId(current.getId());
            if (current.getRecord() < type.getScore()){
                current.setRecord((int) type.getScore());
                this.userService.updateUser(current);
            }
        } else
            type.setUserId(0);
        type.setDate();
        this.typeService.addType(type);
        model.addAttribute("result", "Result: " + (int)type.getScore() + " character per minute");
        return type(model, type.getLanguage());
//        return "redirect:/Stamina/type/" + type.getLanguage();
    }

    @RequestMapping(value = "/user/editEmail", method = RequestMethod.POST)
    public String editEmail(@ModelAttribute("user") User user, Model model) {
        User current = this.userService.getCurrent();
        if (current != null) {
            if (user.getEmail().equals(current.getEmail())){
                model.addAttribute("errorEmail", "You have already using this Email!");
                return editUser(model);
            }
            for (User u : userService.listUsers()) {
                if (user.getEmail().equals(u.getEmail())) {
                    model.addAttribute("errorEmail", "Email is already occupied!");
                    return editUser(model);
                }
            }
            current.setEmail(user.getEmail());
        }
        this.userService.updateUser(current);
        return "redirect:/Stamina/signUp";
    }

    @RequestMapping(value = "/user/editName", method = RequestMethod.POST)
    public String editName(@ModelAttribute("user") User user, Model model){
        User current = this.userService.getCurrent();
        if (current != null) {
            if (user.getName().equals(current.getName())){
                model.addAttribute("errorName", "You have already using this Name!");
                return editUser(model);
            }
            for (User u : userService.listUsers()) {
                if (user.getName().equals(u.getName())) {
                    model.addAttribute("errorName", "Name is already occupied!");
                    return editUser(model);
                }
            }
            current.setName(user.getName());
        }
        this.userService.updateUser(current);
        return "redirect:/Stamina/signUp";
    }

    @RequestMapping(value = "/user/editPass", method = RequestMethod.POST)
    public String editPass(@RequestParam(value="password") String pass, @RequestParam(value="newPass") String newPass){
        User current = this.userService.getCurrent();
        if (current.getPassword().equals(pass)){
            current.setPassword(newPass);
            this.userService.updateUser(current);
        }
        return "redirect:/Stamina/signUp";
    }

    @RequestMapping(value = "/user/logout/{id}")
    public String logOut(@PathVariable("id") int id){
        User user = this.userService.getCurrent();
        user.setCurrent(false);
        this.userService.updateUser(user);
        return "redirect:/Stamina";
    }

    @RequestMapping(value = "/langType", method = RequestMethod.POST)
    public String setType(@RequestParam(value="language") String lang){
        return "redirect:/Stamina/type/" + lang;
    }
}
