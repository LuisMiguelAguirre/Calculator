package com.luisaguirre.calculator.dependencyinjection.dagger.calculatorfeature;

import com.luisaguirre.calculator.MyApplication;
import com.luisaguirre.calculator.dependencyinjection.dagger.calculatorfeature.calculatormodule.CalculatorFeatureModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {AndroidInjectionModule.class, MyApplicationModule.class, CalculatorFeatureModule.class})
public interface MyApplicationComponent extends AndroidInjector<MyApplication>{
}
