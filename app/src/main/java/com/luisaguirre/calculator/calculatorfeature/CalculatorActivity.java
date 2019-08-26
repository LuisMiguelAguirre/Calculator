package com.luisaguirre.calculator.calculatorfeature;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.luisaguirre.calculator.calculatorfeature.model.CalculatorService;
import com.luisaguirre.calculator.services.CalculatorServiceImpl;
import com.luisaguirre.calculator.services.CalculatorViewImpl;
import com.luisaguirre.calculator.calculatorfeature.view.CalculatorView;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView.CalculatorViewListener {


    @Inject
    CalculatorView calculatorView;

    @Inject
    CalculatorService calculatorService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        calculatorView.registerCalculatorViewListener(this);
        setContentView(calculatorView.getRootView());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        calculatorView.unregisterCalculatorViewListener(this);
    }

    @Override
    public void onEqualButtonPressed(List<String> expression) {
        calculatorView.onResult(computeResult(expression));
    }

    @NonNull
    private String computeResult(List<String> expression) {
        String result = calculatorService.calculateResult(expression);

        //todo remove it
        result = expression.toString() + " = " + "final result: " + result;
        return result;
    }
}
