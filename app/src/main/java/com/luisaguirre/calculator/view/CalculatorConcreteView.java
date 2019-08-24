package com.luisaguirre.calculator.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisaguirre.calculator.CalculatorView;
import com.luisaguirre.calculator.R;

public class CalculatorConcreteView implements CalculatorView{

    private final View rootView;

    public CalculatorConcreteView(LayoutInflater layoutInflater, ViewGroup parent) {
        rootView = layoutInflater.inflate(R.layout.activity_calculator, parent, false);
    }

    @Override
    public View getRootView() {
        return rootView;
    }
}
