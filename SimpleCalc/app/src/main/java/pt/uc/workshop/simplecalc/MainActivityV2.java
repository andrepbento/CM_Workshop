package pt.uc.workshop.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * MainActivityV2
 * This activity contains the implementation using ButterKnife.
 * It uses @BindView and @OnClick with a single and multiple id's.
 * <p>
 * Objectives:
 * - Show how ButterKnife makes the programmers life easy.
 */

class MainActivityV2 extends AppCompatActivity {

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

    final CalculatorV0 calculator = CalculatorV0.newInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 03 - ButterKnife OnClick Single Id
        ButterKnife.bind(this);

        tvOperation.setText(calculator.getOperation());
        tvResult.setText(calculator.getResult());

        btnEqual.setOnClickListener((v) -> {
            tvOperation.setText(calculator.getOperation());
            tvResult.setText(calculator.getResult());
        });

        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnAdd = findViewById(R.id.btnAdd);

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.addOperation("%");
                tvOperation.setText(calculator.getOperation());
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.addOperation("*");
                tvOperation.setText(calculator.getOperation());
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.addOperation("-");
                tvOperation.setText(calculator.getOperation());
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.addOperation("+");
                tvOperation.setText(calculator.getOperation());
            }
        });
    }

    // TODO: 07 - Java to Kotlin file conversion
}
