package pt.uc.workshop.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


class MainActivity extends AppCompatActivity {

    //TODO: 00X - BIND WITH BUTTERKNIFE
    @BindView(R.id.btnEqual) Button equal;
    @BindView(R.id.tvOperation) TextView tvOperation;
    @BindView(R.id.tvResult) TextView tvResult;


    //TODO: 00X - SUBSTITUE THIS FOR THE KOTLIN CLASS
    final CalculatorJAVA calculatorJAVA = new CalculatorJAVA();
    //TODO: 00X - CONVERT THE CALCULATORJAVA FOR THIS KOTLIN CLASS
    final Calculator calaculator = new Calculator();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        final TextView tvOperation = findViewById(R.id.tvOperation);
        final TextView tvResult = findViewById(R.id.tvResult);
        tvOperation.setText("");
        tvResult.setText("0.0");

        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber("7");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber("8");
                tvOperation.setText(calculatorJAVA.getOperation());

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber("9");
                tvOperation.setText(calculatorJAVA.getOperation());

            }
        });

        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber("4");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber("5");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber("6");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber("1");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber("2");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber("3");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });

        Button btn0 = findViewById(R.id.btn0);
        Button btnDot = findViewById(R.id.btnDot);
        Button btnEqual = findViewById(R.id.btnEqual);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber("0");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addNumber(".");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });

        /*btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOperation.setText("");
                tvResult.setText(calculatorJAVA.getResult().toString());
            }
        });*/

        Button btnDel = findViewById(R.id.btnDel);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnAdd = findViewById(R.id.btnAdd);

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(calculatorJAVA.getResult());
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addOperation("%");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addOperation("*");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addOperation("-");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorJAVA.addOperation("+");
                tvOperation.setText(calculatorJAVA.getOperation());
            }
        });
    }
    //TODO: 00X - ONE BUTTON WITH BUTTERKNIFE
    @OnClick(R.id.btnEqual)
    public void setTvResult(Button button) {
        tvOperation.setText("");
        tvResult.setText(calculatorJAVA.getResult().toString());
    }
}
