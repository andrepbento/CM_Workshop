package pt.uc.workshop.simplecalc;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Calculator
 * This class represents the calculator itself written in Java. It contains the main logic for the calculator to work.
 * <p>
 * Objectives:
 * - Convert this file to Kotlin.
 */

public class Calculator {

    private static Calculator calculator = null;

    private int numberPos = 0;
    private ArrayList<String> values = new ArrayList<>();

    public static Calculator newInstance() {
        if (calculator == null)
            calculator = new Calculator();
        return calculator;
    }

    private Calculator() {
    }

    public void addNumber(String number) {
        if (values.size() == 0) {
            if (number.equals("."))
                values.add(0 + ".");
            else
                values.add(number);
        } else {
            if (values.size() <= numberPos)
                values.add(number);
            else {
                String currNumber = values.get(numberPos);
                if (number.equals(".")) {
                    if (!currNumber.contains("."))
                        currNumber += number;
                } else
                    currNumber += number;
                values.set(numberPos, currNumber);
            }
        }
    }

    public void addOperation(String operation) {
        if (values.size() == 0) {
            return;
        } else {
            switch (values.get(values.size() - 1)) {
                case "+":
                    return;
                case "-":
                    return;
                case "*":
                    return;
                case "÷":
                    return;
            }
        }
        values.add(operation);
        numberPos += 2;
    }

    public void clear() {
        this.numberPos = 0;
        this.values.clear();
    }

    public String getOperation() {
        StringBuilder totalOperation = new StringBuilder();
        for (String item : values)
            totalOperation.append(item);
        return totalOperation.toString();
    }

    public String getResult() {
        DecimalFormat df = new DecimalFormat("###.#");
        if (values.size() == 0)
            return df.format(Double.parseDouble("0.0"));
        else {
            // Remove symbols from last element in values array
            if (values.indexOf("*") == values.size() - 1 || values.indexOf("÷") == values.size() - 1
                    || values.indexOf("+") == values.size() - 1 || values.indexOf("-") == values.size() - 1)
                values.remove(values.size() - 1);
            // Perform multiplication and division calculations
            while (true) {
                int indicatorMul = values.indexOf("*");
                int indicatorDiv = values.indexOf("÷");
                if (indicatorMul == -1 && indicatorDiv == -1)
                    break;
                else if (indicatorMul != -1) {
                    String val1 = values.get(indicatorMul - 1);
                    String val2 = values.get(indicatorMul + 1);
                    Double aux = Double.valueOf(val1.trim()) * Double.valueOf(val2.trim());
                    values.set(indicatorMul - 1, aux.toString());
                    values.remove(indicatorMul + 1);
                    values.remove(indicatorMul);
                } else if (indicatorDiv != -1) {
                    String val1 = values.get(indicatorDiv - 1);
                    String val2 = values.get(indicatorDiv + 1);
                    Double aux = Double.valueOf(val1.trim()) / Double.valueOf(val2.trim());
                    values.set(indicatorDiv - 1, aux.toString());
                    values.remove(indicatorDiv + 1);
                    values.remove(indicatorDiv);
                }
            }
            // Perform plus and minus calculations
            while (values.size() != 1) {
                String val1 = values.get(0);
                String val2 = values.get(2);
                Double aux = 0.0;
                switch (values.get(1)) {
                    case "+":
                        aux = Double.valueOf(val1.trim()) + Double.valueOf(val2.trim());
                        break;
                    case "-":
                        aux = Double.valueOf(val1.trim()) - Double.valueOf(val2.trim());
                        break;
                }
                values.set(0, aux.toString());
                values.remove(1);
                values.remove(1);
            }
            String result = values.get(0);
            numberPos = 0;
            return df.format(Double.parseDouble(result.trim()));
        }
    }
}
