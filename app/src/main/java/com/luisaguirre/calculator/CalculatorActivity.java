package com.luisaguirre.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.luisaguirre.calculator.R;
import com.luisaguirre.calculator.view.CalculatorConcreteView;

import java.util.zip.Inflater;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalculatorView calculatorView = new CalculatorConcreteView(LayoutInflater.from(this), null);

        setContentView(calculatorView.getRootView());

    }
}
