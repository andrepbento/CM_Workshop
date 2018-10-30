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
class Calculator private constructor() {

    private var numberPos = 0
    private val values = ArrayList<String>()

    val operation: String
        get() {
            val totalOperation = StringBuilder()
            for (item in values)
                totalOperation.append(item)
            return totalOperation.toString()
        }

    // Remove symbols from last element in values array
    // Perform multiplication and division calculations
    // Perform plus and minus calculations
    val result: String
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

    fun addNumber(number: String) {
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

    fun addOperation(operation: String) {
        if (values.size == 0) {
            return
        } else {
            when (values[values.size - 1]) {
                "+" -> return
                "-" -> return
                "*" -> return
                "÷" -> return
            }
        }
        values.add(operation)
        numberPos += 2
    }

    fun clear() {
        this.numberPos = 0
        this.values.clear()
    }

    companion object {

        private var calculator: Calculator? = null

        fun newInstance(): Calculator {
            if (calculator == null)
                calculator = Calculator()
            return calculator as Calculator
        }
    }
}
