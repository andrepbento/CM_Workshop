package pt.uc.workshop.simplecalc;

import java.util.ArrayList;

public class CalculatorJAVA {
    private int numberPos = 0;
    //NEW
    private ArrayList<String> values = new ArrayList<>();

    public void addNumber(String number){
        if (values.size() == 0){
            if (number.equals("."))
                values.add(0 + ".");
            else
                values.add(number);
        }else {
            String currNumber = values.get(numberPos);
            if (number.equals(".")) {
                if (currNumber.contains("."))
                    currNumber = currNumber;
                else
                    currNumber += number;
            } else
                currNumber += number;
            values.set(numberPos, currNumber);
        }
    }

    public void addOperation(String operation){
        if (values.size() == 0){
            return;
        }else{
            switch (values.get(values.size()-1)){
                case "+":
                    return;
                case "-":
                    return;
                case "*":
                    return;
                case "%":
                    return;
                case "":
                    return;
            }
        }
        values.add(operation);
        values.add("");
        numberPos+=2;
    }

    public String getResult() {
        if (values.size() == 0)
            return "0";
        else {
            while (true){
                int indicatorMult = values.indexOf("*");
                int indicatorDiv = values.indexOf("%");
                if (indicatorMult == -1 && indicatorDiv == -1)
                    break;
                else if (indicatorMult != -1){
                    String val1 = values.get(indicatorMult - 1);
                    String val2 = values.get(indicatorMult + 1);
                    Double aux = Double.valueOf(val1.trim()) * Double.valueOf(val2.trim());
                    values.set(indicatorMult-1,aux.toString());
                    values.remove(indicatorMult+1);
                    values.remove(indicatorMult);
                }
                else if (indicatorDiv != -1){
                    String val1 = values.get(indicatorDiv - 1);
                    String val2 = values.get(indicatorDiv + 1);
                    Double aux = Double.valueOf(val1.trim()) / Double.valueOf(val2.trim());
                    values.set(indicatorDiv-1,aux.toString());
                    values.remove(indicatorDiv+1);
                    values.remove(indicatorDiv);
                }
            }
            while (values.size()!=1){
                String val1 = values.get(0);
                String val2 = values.get(2);
                Double aux = 0.0;
                switch (values.get(1)){
                    case "+":
                        aux = Double.valueOf(val1.trim()) + Double.valueOf(val2.trim());
                        break;
                    case "-":
                        aux = Double.valueOf(val1.trim()) - Double.valueOf(val2.trim());
                        break;
                }
                values.set(0,aux.toString());
                values.remove(1);
                values.remove(1);
                //TODO: LER ESTA PIADA DE MAU GOSTO XD
                //values.remove(2);
            }
            String result = values.get(0);
            values.clear();
            numberPos = 0;
            return result.trim();
        }
    }

    public String getOperation(){
        String totalOperation = "";
        for (String item : values) {
            totalOperation += item;
        }
        return totalOperation;
    }

    /*
    public void addNum(String num){
        if(operator == null || operator.isEmpty()){
            if (num.equals(".")) {
                if (this.num1.isEmpty())
                    addNum1(0 + ".");
                if (!this.num1.contains("."))
                        addNum1(num);
            }else
                addNum1(num);
        }else {
            if (num.equals(".")) {
                if (this.num2.isEmpty())
                    addNum2(0 + ".");
                if (!this.num2.contains("."))
                    addNum2(num);
            }else
                addNum2(num);
        }
    }

    private void addNum1(String num){
        this.num1 = this.num1 + num;
    }

    private void addNum2(String num){
        this.num2 = this.num2 + num;
    }

    public void addOperator(String operator){
        this.operator = operator;
    }

    public void clearOperation(){
        num1 = num2 = "";
        operator = null;
    }

    public String getResult(){
        if(num1.isEmpty() || num2.isEmpty())
            return "0.0";
        switch (operator) {
            case "+":  result = Double.valueOf(num1.trim()) + Double.valueOf(num2.trim()); break;
            case "-":  result = (Double.valueOf(num1.trim()) - Double.valueOf(num2.trim())); break;
            case "*":  result = (Double.valueOf(num1.trim()) * Double.valueOf(num2.trim())); break;
            case "%":  result = (Double.valueOf(num1.trim())/Double.valueOf(num2.trim())); break;
        }
        clearOperation();
        return result.toString();
    }

    public String getOperation(){
        return num1 + operator + num2;
    }
    */

}
