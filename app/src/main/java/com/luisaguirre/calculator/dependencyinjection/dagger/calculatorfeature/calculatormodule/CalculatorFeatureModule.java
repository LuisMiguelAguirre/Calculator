package com.luisaguirre.calculator.dependencyinjection.dagger.calculatorfeature.calculatormodule;

import android.view.LayoutInflater;

import com.luisaguirre.calculator.calculatorfeature.CalculatorActivity;
import com.luisaguirre.calculator.calculatorfeature.model.CalculatorService;
import com.luisaguirre.calculator.calculatorfeature.view.CalculatorView;
import com.luisaguirre.calculator.services.CalculatorServiceImpl;
import com.luisaguirre.calculator.services.CalculatorViewImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class CalculatorFeatureModule {


    @Provides
    static CalculatorView provideCalculatorView(CalculatorActivity calculatorActivity) {
        return new CalculatorViewImpl(LayoutInflater.from(calculatorActivity), null);
    }

    @Provides
    static CalculatorService provideCalculatorServiceImpl() {
        return new CalculatorServiceImpl();
    }
}
