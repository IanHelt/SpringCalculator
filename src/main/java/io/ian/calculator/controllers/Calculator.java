package io.ian.calculator.controllers;

import io.ian.calculator.models.CalcUser;
import io.ian.calculator.models.Equation;
import io.ian.calculator.models.OperationClass;
import io.ian.calculator.repositories.CalcUserRepository;
import io.ian.calculator.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {

    @Autowired
    private CalcUserRepository calcUserRepo;

    @Autowired
    private OperationRepository operationRepo;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("calcusers", calcUserRepo.findAll());
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

    @RequestMapping(value = "/save", method = RequestMethod.POST)
            public String saveUser(@RequestParam("firstInputSave") Double firstInput,
                                   @RequestParam("secondInputSave") Double secondInput,
                                   @RequestParam("operandSave") String operand,
                                   @RequestParam("username") String username,
                                   @RequestParam("opname") String opName,
                                   Model model) {
        Double outcome = Equation.doMath(firstInput, secondInput, operand);
        if (calcUserRepo.findAllByName(username).isEmpty()) {
            CalcUser calcUser = new CalcUser();
            OperationClass operation = new OperationClass();
            calcUser.setName(username);
            operation.setName(opName);
            operation.setEquation(String.format("%s %s %s", firstInput, operand, secondInput));
            operation.setCalcUser(calcUser);
            calcUserRepo.save(calcUser);
            operationRepo.save(operation);
        } else {
            CalcUser calcUser = calcUserRepo.findCalcUserByName(username);
            OperationClass operation = new OperationClass();
            operation.setName(opName);
            operation.setEquation(String.format("%s %s %s", firstInput, operand, secondInput));
            operation.setCalcUser(calcUser);
            operationRepo.save(operation);
        }
        model.addAttribute("firstInput", firstInput);
        model.addAttribute("secondInput", secondInput);
        model.addAttribute("operand", operand);
        model.addAttribute("showEquation", String.format("%s %s %s", firstInput, operand, secondInput));
        model.addAttribute("outcome", outcome);
        return "redirect:/";
    }

    @RequestMapping(value = "/toDetails", method = RequestMethod.POST)
    public String toDetails(@RequestParam("toUser") String username) {
        return "redirect:/userdetail/" + username;
    }
}
