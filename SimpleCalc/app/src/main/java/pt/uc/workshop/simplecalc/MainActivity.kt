package pt.uc.workshop.simplecalc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import butterknife.ButterKnife
import butterknife.OnClick
// TODO: 09 - Kotlin Android extensions on View Binding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivity
 * This activity is the starting point for the workshop.
 */

class MainActivity : AppCompatActivity() {

    private val calculator = Calculator.newInstance()

    // TODO: 05 - ButterKnife OnClick Single Id
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

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: 03 - Include ButterKnife in Gradle && OnCreate
        ButterKnife.bind(this)

        // TODO: 09 - Kotlin Android extensions on View Binding
        tvOperation.text = calculator.operation
        tvResult.text = calculator.result

        // TODO: 10 - Kotlin class declaration

        // TODO: 11 - Kotlin Null Pointer Free
    }
}
