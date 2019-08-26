package com.luisaguirre.calculator.dependencyinjection.dagger.calculatorfeature;

import com.luisaguirre.calculator.calculatorfeature.CalculatorActivity;
import com.luisaguirre.calculator.dependencyinjection.dagger.calculatorfeature.calculatormodule.CalculatorFeatureModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MyApplicationModule {

    @ContributesAndroidInjector(modules = CalculatorFeatureModule.class)
    abstract CalculatorActivity contributeActivityInjector();
}
