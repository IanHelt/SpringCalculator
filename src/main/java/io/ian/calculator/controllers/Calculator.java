package io.ian.calculator.controllers;

import io.ian.calculator.models.Equation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
            public String index(@RequestParam("firstInput") Double firstInput,
                                  @RequestParam("secondInput") Double secondInput,
                                  @RequestParam("operand") String operand,
                                    Model model) {
        Double outcome = Equation.doMath(firstInput, secondInput, operand);
        model.addAttribute("firstInput", firstInput);
        model.addAttribute("secondInput", secondInput);
        model.addAttribute("operand", operand);
        model.addAttribute("showEquation", String.format("%s %s %s", firstInput, operand, secondInput));
        model.addAttribute("outcome", outcome);
        return "index";
    }

}
