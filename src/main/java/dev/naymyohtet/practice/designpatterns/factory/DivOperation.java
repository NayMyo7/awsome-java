package dev.naymyohtet.practice.designpatterns.factory;

public class DivOperation implements Operation {

    @Override
    public double calculate(double number1, double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return number1 / number2;
    }

}
