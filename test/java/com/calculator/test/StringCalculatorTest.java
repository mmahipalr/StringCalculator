package com.calculator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.calculator.StringCalculator;

class StringCalculatorTest {

	@Test
    void canAddEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    void canAddSingleNumberReturnsNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void canAddTwoNumbersReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,5"));
    }

    @Test
    void canAddNewLineDelimiterReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void canAddCustomDelimiterReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    void canAddNegativeNumbersThrowsException() {
        StringCalculator calculator = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
    }

    @Test
    void canAddSpaceAndCustomDelimiterReturnsSum() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(62, calculator.add("//;\n1;2,3;5 6"));
    }
}
