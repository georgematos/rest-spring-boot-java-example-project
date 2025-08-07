package com.gcorp;

import com.gcorp.controllers.MathController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MathControllerTests {
    @Autowired
    MathController controller;

    @Test
    void sum() {
        BigDecimal result = controller.sum(new BigDecimal("10"), new BigDecimal("5"));
        assertEquals(new BigDecimal("15"), result);
    }

    @Test
    void sub(){
        BigDecimal result = controller.sub(new BigDecimal("10"), new BigDecimal("5"));
        assertEquals(new BigDecimal("5"), result);
    }

    @Test
    void mult() {
        BigDecimal result = controller.mult(new BigDecimal("2"), new BigDecimal("5"));
        assertEquals(new BigDecimal("10"), result);
    }

    @Test
    void div() {
        BigDecimal result = controller.div(new BigDecimal("4"), new BigDecimal("5.4"));
        assertEquals(new BigDecimal("0.74"), result);
    }
}
