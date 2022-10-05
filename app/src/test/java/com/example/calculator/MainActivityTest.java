package com.example.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainActivityTest {

    @Test
    void substraction() {
        Assertions.assertEquals(0, MainActivity.substraction(2, 2));
    }

    @Test
    void division() {
        Assertions.assertEquals(2, MainActivity.division(4, 2));
    }

    @Test
    void multiplication() {
        Assertions.assertEquals(4, MainActivity.multiplication(2, 2));
    }

    @Test
    void addition() {
        Assertions.assertEquals(4, MainActivity.addition(2, 2));
    }
}