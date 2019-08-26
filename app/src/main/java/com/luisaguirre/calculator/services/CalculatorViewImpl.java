package com.luisaguirre.calculator.services;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.luisaguirre.calculator.R;
import com.luisaguirre.calculator.calculatorfeature.view.CalculatorView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CalculatorViewImpl implements View.OnClickListener, CalculatorView {

    private final View rootView;

    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEqual;
    private EditText etResult;

    private List<String> expression = new ArrayList<>(1);
    private List<CalculatorViewListener> listeners = new ArrayList<>(1);

    //todo remove it
    @Inject
    public CalculatorViewImpl(LayoutInflater layoutInflater, ViewGroup parent) {
        rootView = layoutInflater.inflate(R.layout.activity_calculator, parent, false);
        inflateButtons();
        addOnClickListenerToButtons();
    }

    @Override
    public void onClick(View view) {
        savePressedNumber((Button) view);
    }

    private void savePressedNumber(Button view) {
        expression.add(String.valueOf(view.getText()));
    }

    private void computeResult() {
        for (CalculatorViewListener listener : listeners) {
            listener.onEqualButtonPressed(expression);
        }
    }

    //region calculatorView implementation
    @Override
    public void onResult(String result) {
        etResult.setText(result);
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void registerCalculatorViewListener(CalculatorViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterCalculatorViewListener(CalculatorViewListener listener) {
        listeners.remove(listener);
    }
    //endregion

    //region inflating views
    private void inflateButtons() {
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnEqual = findViewById(R.id.btnEqual);
        etResult = findViewById(R.id.etNumberDisplay);
    }

    private void addOnClickListenerToButtons() {
        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeResult();
            }
        });
    }

    private <T extends View> T findViewById(int resource) {
        return rootView.findViewById(resource);
    }
    //endregion
}
