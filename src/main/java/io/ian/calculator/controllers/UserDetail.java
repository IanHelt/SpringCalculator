package io.ian.calculator.controllers;

import io.ian.calculator.models.CalcUser;
import io.ian.calculator.repositories.CalcUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserDetail {

    @Autowired
    private CalcUserRepository calcUserRepo;

    @RequestMapping(value = "/userdetail/{name}")
    public String userDetail(Model model,
                             @PathVariable("name") String name) {
        CalcUser calcUser = calcUserRepo.findCalcUserByName(name);
        model.addAttribute("calcUser", calcUser);
        return "userdetail";
    }
}
