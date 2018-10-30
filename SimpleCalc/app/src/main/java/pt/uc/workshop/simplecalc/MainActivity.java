package pt.uc.workshop.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * MainActivity
 * This activity is the starting point for the workshop.
 */

public class MainActivity extends AppCompatActivity {

    final Calculator calculator = Calculator.newInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 01 - Implement the findViewById's
        final TextView tvOperation = findViewById(R.id.tvOperation);
        final TextView tvResult = findViewById(R.id.tvResult);
        tvOperation.setText(calculator.getOperation());
        tvResult.setText(calculator.getResult());

        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);

        Button btn0 = findViewById(R.id.btn0);
        Button btnDot = findViewById(R.id.btnDot);
        Button btnEqual = findViewById(R.id.btnEqual);

        Button btnDel = findViewById(R.id.btnDel);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnAdd = findViewById(R.id.btnAdd);

        // TODO: 02 - Implement the setOnClickListeners

        // TODO: 03 - Include ButterKnife in Gradle && OnCreate

        // TODO: 04 - BindView

        // TODO: 05 - OnClick with single Id's

        // TODO: 06 - OnClick with multiple Id's

        // TODO: 07 - Java to Kotlin file conversion

        // TODO: 08 - Java and Kotlin interoperation

        // TODO: 09 - Kotlin Android extensions on View Binding

        // TODO: 10 - Kotlin class declaration

        // TODO: 11 - Kotlin Null Pointer Free
    }
}
