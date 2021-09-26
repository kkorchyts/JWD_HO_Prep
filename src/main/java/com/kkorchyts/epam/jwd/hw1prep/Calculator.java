package com.kkorchyts.epam.jwd.hw1prep;

import java.util.Scanner;


public class Calculator {
    private enum Operation {SUM, DIF, COMP, QUOT, EXIT}

    private static double readDouble(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("You have entered wrong value! Please, try again :");
            scanner.nextLine();
        }
        return scanner.nextDouble();
    }

    private static Operation readNextOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select next operation: +,-,/,* or 0 other to exit");
        while (!scanner.hasNext("[+\\-*/0]")) {
            System.out.println("You have entered wrong value! Please, try again :");
            scanner.nextLine();
        }
        String operation = scanner.nextLine();
        switch (operation) {
            case "+":
                return Operation.SUM;
            case "-":
                return Operation.DIF;
            case "*":
                return Operation.COMP;
            case "/":
                return Operation.QUOT;
            case "0":
                return Operation.EXIT;
            default:
                throw new Error("Wrong operation: '" + operation + "'");
        }
    }

    public static double calculate(double firstOperand, double secondOperand, Operation operation) {
        switch (operation) {
            case SUM:
                return firstOperand + secondOperand;
            case DIF:
                return firstOperand - secondOperand;
            case COMP:
                return firstOperand * secondOperand;
            case QUOT:
                return firstOperand / secondOperand;
            default:
                throw new Error("Wrong operation: '" + operation + "'");
        }
    }

    public static void main(String[] args) {
        Operation operation;
        do {
            operation = readNextOperation();
            if (operation == Operation.EXIT){
                break;
            }
            System.out.println(
                    calculate(readDouble("Please, enter first operand: "),
                            readDouble("Please, enter next operand: "),
                            operation));
        } while (true);
    }
}
