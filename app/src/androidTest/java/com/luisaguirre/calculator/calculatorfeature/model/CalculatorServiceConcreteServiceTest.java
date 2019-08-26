package com.luisaguirre.calculator.calculatorfeature.model;

import com.luisaguirre.calculator.services.CalculatorServiceImpl;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalculatorServiceConcreteServiceTest {

    private CalculatorService calculatorService;
    private List<String> expression;
    @Before
    public void setUp() throws Exception {
        expression = new ArrayList<>(1);
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void calculateResult() {
        expression.add("1");
        expression.add("+");
        expression.add("1");

        String result = calculatorService.calculateResult(expression);
        String expectedValue = "2";

        assertEquals(result, expectedValue);
    }
}