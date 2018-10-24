package pt.uc.workshop.simplecalc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import butterknife.ButterKnife
import butterknife.OnClick
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivityV3
 * This activity contains the implementation using Kotlin Android Extensions.
 *
 * Objectives:
 * - Show how Kotlin Extensions and ButterKnife makes the programmers life easy.
 */

internal class MainActivity : AppCompatActivity() {

    // TODO: 08 - Java and Kotlin interoperation
    private val calculator = Calculator.newInstance()

    @OnClick(R.id.btnDel)
    fun btnDelClick() {
        calculator.clear()
        tvResult.text = calculator.result
        tvOperation.text = calculator.operation
    }

    @OnClick(R.id.btnEqual)
    fun btnEqualClick() {
        tvOperation.text = calculator.operation
        tvResult.text = calculator.result
    }

    @OnClick(
        R.id.btn7, R.id.btn8, R.id.btn9,
        R.id.btn4, R.id.btn5, R.id.btn6,
        R.id.btn1, R.id.btn2, R.id.btn3,
        R.id.btn0, R.id.btnDot
    )
    fun valueBtnClick(button: Button) {
        calculator.addNumber(button.text.toString())
        tvOperation.text = calculator.operation
    }

    @OnClick(R.id.btnDiv, R.id.btnMul, R.id.btnSub, R.id.btnAdd)
    fun operationBtnClick(button: Button) {
        calculator.addOperation(button.text.toString())
        tvOperation.text = calculator.operation
    }

    // TODO: 11 - Kotlin Null Pointer Free
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        // TODO: 09 - Kotlin Android extensions on View Binding
        tvOperation.text = calculator.operation
        tvResult.text = calculator.result
    }
}
