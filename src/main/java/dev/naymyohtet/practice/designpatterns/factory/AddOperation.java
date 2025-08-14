package dev.naymyohtet.practice.designpatterns.factory;

public class AddOperation implements Operation {

    @Override
    public double calculate(double number1, double number2) {
        return number1 + number2;
    }

}
