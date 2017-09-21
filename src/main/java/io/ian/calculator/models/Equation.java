package io.ian.calculator.models;

public class Equation {
    public static Double doMath(Double firstInput, Double secondInput, String operand) {
        Double outcome = 0.0;
        if (operand.equals("+")){
           outcome = firstInput + secondInput;
        } else if (operand.equals("-")) {
            outcome = firstInput - secondInput;
        } else if (operand.equals("/")){
            outcome = firstInput / secondInput;
        } else if (operand.equals("*")){
            outcome = firstInput * secondInput;
        }
        return outcome;
    }
}
