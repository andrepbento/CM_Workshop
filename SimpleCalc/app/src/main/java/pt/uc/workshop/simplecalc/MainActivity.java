package pt.uc.workshop.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    // TODO: 05 - ButterKnife OnClick Single Id
    @OnClick(R.id.btnDel)
    public void btnDelClick() {
        calculator.clear();
        tvResult.setText(calculator.getResult());
        tvOperation.setText(calculator.getOperation());
    }

    // TODO: 06 - ButterKnife OnClick with multiple Id's
    @OnClick({R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn0, R.id.btnDot})
    public void valueBtnClick(Button button) {
        calculator.addNumber(button.getText().toString());
        tvOperation.setText(calculator.getOperation());
    }

    final Calculator calculator = Calculator.Companion.newInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 03 - Include ButterKnife in Gradle && OnCreate
        ButterKnife.bind(this);

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

        // TODO: 08 - Java and Kotlin interoperation

        // TODO: 09 - Kotlin Android extensions on View Binding

        // TODO: 10 - Kotlin class declaration

        // TODO: 11 - Kotlin Null Pointer Free
    }
}
