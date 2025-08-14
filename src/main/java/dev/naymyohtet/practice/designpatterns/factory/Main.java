package dev.naymyohtet.practice.designpatterns.factory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1. Additon(+)\n2. Subtraction(-) \n3. Multiplication(*)\n4. Division(/)");

        try {
            // getting choice from user
            System.out.println("\n\nSelect your operation (1j-4): ");
            int choice = scanner.nextInt();

            // getting 2 operands from user
            System.out.println("\nEnter first operand: ");
            double operand1 = scanner.nextDouble();
            System.out.println("\nEnter second operand: ");
            double operand2 = scanner.nextDouble();

            // create operation instance based on user choice
            OperationFactory operationFactory = new OperationFactoryImpl();
            Operation operation = operationFactory.getInstance(choice);

            // printing result
            System.out.println("\nThis result is " + operation.calculate(operand1, operand2) + ".");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type!");
        } catch (InvalidOperation | ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();

    }
}
