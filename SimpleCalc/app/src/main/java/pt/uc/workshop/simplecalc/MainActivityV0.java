package pt.uc.workshop.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * MainActivityV0
 * This activity is the starting point for the workshop.
 */

class MainActivityV0 extends AppCompatActivity {

    final CalculatorV0 calculator = CalculatorV0.newInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 01, 02 - Implement the findViewById's and setOnClickListeners

        // TODO: ButterKnife
        // TODO: 03 - Include ButterKnife in Gradle && OnCreate
        // TODO: 04 - BindView
        // TODO: 05 - OnClick with single Id's
        // TODO: 06 - OnClick with multiple Id's

        // TODO: Kotlin
        // TODO: 07 - Java to Kotlin file conversion
        // TODO: 08 - Java and Kotlin interoperation
        // TODO: 09 - Kotlin Android extensions on View Binding
        // TODO: 10 - Kotlin class declaration
        // TODO: 11 - Kotlin extensions
        // TODO: 12 - Kotlin Null Pointer Free
    }
}
