package pt.uc.workshop.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * MainActivity
 * This activity is the starting point for the workshop.
 */

public class MainActivity extends AppCompatActivity {

    // TODO: 04 - BindViews with ButterKnife
    @BindView(R.id.btnEqual)
    Button btnEqual;
    @BindView(R.id.tvOperation)
    TextView tvOperation;
    @BindView(R.id.tvResult)
    TextView tvResult;

    final Calculator calculator = Calculator.newInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 03 - Include ButterKnife in Gradle && OnCreate
        ButterKnife.bind(this);

        // TODO: 01 - Implement the findViewById's
        final TextView tvOperation = findViewById(R.id.tvOperation);
        final TextView tvResult = findViewById(R.id.tvResult);
        tvOperation.setText(calculator.getOperation());
        tvResult.setText(calculator.getResult());

        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        // TODO: 02 - Implement the setOnClickListeners
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.addNumber(((Button) v).getText().toString());
                tvOperation.setText(calculator.getOperation());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.addNumber(((Button) v).getText().toString());
                tvOperation.setText(calculator.getOperation());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.addNumber(((Button) v).getText().toString());
                tvOperation.setText(calculator.getOperation());
            }
        });

        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.addNumber(((Button) v).getText().toString());
                tvOperation.setText(calculator.getOperation());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.addNumber(((Button) v).getText().toString());
                tvOperation.setText(calculator.getOperation());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.addNumber(getResources().getString(R.string.six_str));
                tvOperation.setText(calculator.getOperation());
            }
        });

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener((v) -> {
            calculator.addNumber(((Button) v).getText().toString());
            tvOperation.setText(calculator.getOperation());
        });
        btn2.setOnClickListener(v -> {
            calculator.addNumber(((Button) v).getText().toString());
            tvOperation.setText(calculator.getOperation());
        });
        btn3.setOnClickListener(v -> {
            calculator.addNumber(((Button) v).getText().toString());
            tvOperation.setText(calculator.getOperation());
        });

        Button btn0 = findViewById(R.id.btn0);
        Button btnDot = findViewById(R.id.btnDot);
        Button btnEqual = findViewById(R.id.btnEqual);

        btn0.setOnClickListener(v -> {
            calculator.addNumber(((Button) v).getText().toString());
            tvOperation.setText(calculator.getOperation());
        });
        btnDot.setOnClickListener(v -> {
            calculator.addNumber(((Button) v).getText().toString());
            tvOperation.setText(calculator.getOperation());
        });

        btnEqual.setOnClickListener(v -> {
            tvResult.setText(calculator.getResult());
            tvOperation.setText(calculator.getOperation());
        });

        Button btnDel = findViewById(R.id.btnDel);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnAdd = findViewById(R.id.btnAdd);

        btnDel.setOnClickListener(v -> {
            calculator.clear();
            tvResult.setText(calculator.getResult());
            tvOperation.setText(calculator.getOperation());
        });
        btnDiv.setOnClickListener(v -> {
            calculator.addOperation(((Button) v).getText().toString());
            tvOperation.setText(calculator.getOperation());
        });
        btnMul.setOnClickListener(v -> {
            calculator.addOperation(((Button) v).getText().toString());
            tvOperation.setText(calculator.getOperation());
        });
        btnSub.setOnClickListener(v -> {
            calculator.addOperation(((Button) v).getText().toString());
            tvOperation.setText(calculator.getOperation());
        });
        btnAdd.setOnClickListener(v -> {
            calculator.addOperation(((Button) v).getText().toString());
            tvOperation.setText(calculator.getOperation());
        });

        // TODO: 05 - OnClick with single Id's

        // TODO: 06 - OnClick with multiple Id's

        // TODO: 07 - Java to Kotlin file conversion

        // TODO: 08 - Java and Kotlin interoperation

        // TODO: 09 - Kotlin Android extensions on View Binding

        // TODO: 10 - Kotlin class declaration

        // TODO: 11 - Kotlin Null Pointer Free
    }
}
