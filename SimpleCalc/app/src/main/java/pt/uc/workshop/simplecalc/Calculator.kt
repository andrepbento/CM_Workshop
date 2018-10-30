package pt.uc.workshop.simplecalc

import java.text.DecimalFormat
import java.util.*

/**
 * Calculator
 * This class represents the calculator itself written in Java. It contains the main logic for the calculator to work.
 *
 *
 * Objectives:
 * - Convert this file to Kotlin.
 */

// TODO: 07 - Java to Kotlin file conversion
// TODO: 08 - Java and Kotlin interoperation
// TODO: 10 - Kotlin class declaration
class Calculator(var numberPos: Int = 0, val values: ArrayList<String> = arrayListOf()) {

    private object Holder {
        val INSTANCE = Calculator()
    }

    companion object {
        val instance: Calculator by lazy { Holder.INSTANCE }
    }

    var operation: String = ""
        get() {
            val totalOperation = StringBuilder()
            for (item in values)
                totalOperation.append(item)
            return totalOperation.toString()
        }

    var result: String = ""
        get() {
            val df = DecimalFormat("###.#")
            if (values.size == 0)
                return df.format(java.lang.Double.parseDouble("0.0"))
            else {
                if (values.indexOf("*") == values.size - 1 || values.indexOf("÷") == values.size - 1
                    || values.indexOf("+") == values.size - 1 || values.indexOf("-") == values.size - 1
                )
                    values.removeAt(values.size - 1)
                while (true) {
                    val indicatorMul = values.indexOf("*")
                    val indicatorDiv = values.indexOf("÷")
                    if (indicatorMul == -1 && indicatorDiv == -1)
                        break
                    else if (indicatorMul != -1) {
                        val val1 = values[indicatorMul - 1]
                        val val2 = values[indicatorMul + 1]
                        val aux =
                            java.lang.Double.valueOf(val1.trim { it <= ' ' }) * java.lang.Double.valueOf(val2.trim { it <= ' ' })
                        values[indicatorMul - 1] = aux.toString()
                        values.removeAt(indicatorMul + 1)
                        values.removeAt(indicatorMul)
                    } else if (indicatorDiv != -1) {
                        val val1 = values[indicatorDiv - 1]
                        val val2 = values[indicatorDiv + 1]
                        val aux =
                            java.lang.Double.valueOf(val1.trim { it <= ' ' }) / java.lang.Double.valueOf(val2.trim { it <= ' ' })
                        values[indicatorDiv - 1] = aux.toString()
                        values.removeAt(indicatorDiv + 1)
                        values.removeAt(indicatorDiv)
                    }
                }
                while (values.size != 1) {
                    val val1 = values[0]
                    val val2 = values[2]
                    var aux: Double? = 0.0
                    when (values[1]) {
                        "+" -> aux = java.lang.Double.valueOf(val1.trim { it <= ' ' }) +
                                java.lang.Double.valueOf(val2.trim { it <= ' ' })
                        "-" -> aux = java.lang.Double.valueOf(val1.trim { it <= ' ' }) -
                                java.lang.Double.valueOf(val2.trim { it <= ' ' })
                    }
                    values[0] = aux!!.toString()
                    values.removeAt(1)
                    values.removeAt(1)
                }
                val result = values[0]
                numberPos = 0
                return df.format(java.lang.Double.parseDouble(result.trim { it <= ' ' }))
            }
        }
}

fun Calculator.addNumber(number: String) {
    if (values.size == 0) {
        if (number == ".")
            values.add(0.toString() + ".")
        else
            values.add(number)
    } else {
        if (values.size <= numberPos)
            values.add(number)
        else {
            var currNumber = values[numberPos]
            if (number == ".") {
                if (!currNumber.contains("."))
                    currNumber += number
            } else
                currNumber += number
            values[numberPos] = currNumber
        }
    }
}

fun Calculator.addOperation(operation: String) {
    if (values.size == 0) return else {
        when (values[values.size - 1]) {
            "+", "-", "*", "÷" -> return
        }
    }
    values.add(operation)
    numberPos += 2
}

fun Calculator.clear() {
    this.numberPos = 0
    this.values.clear()
}
