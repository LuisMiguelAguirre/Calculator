package com.luisaguirre.calculator.calculatorfeature.view;

import android.view.View;

import java.util.List;

public interface CalculatorView {

    interface CalculatorViewListener {
        void onEqualButtonPressed(List<String> expression);
    }

    View getRootView();

    void registerCalculatorViewListener(CalculatorViewListener listener);

    void unregisterCalculatorViewListener(CalculatorViewListener listener);

    void onResult(String s);
}
