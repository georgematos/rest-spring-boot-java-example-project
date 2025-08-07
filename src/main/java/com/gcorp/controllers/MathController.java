package com.gcorp.controllers;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/math")
public class MathController {
    @PostMapping("/sum/{number1}/{number2}")
    public BigDecimal sum(
            @PathVariable BigDecimal number1,
            @PathVariable BigDecimal number2
    ) {
        return number1.add(number2);
    }

    @PostMapping("/sub/{number1}/{number2}")
    public BigDecimal sub(
            @PathVariable BigDecimal number1,
            @PathVariable BigDecimal number2
    ) {
        return number1.subtract(number2);
    }

    @PostMapping("/mult/{number1}/{number2}")
    public BigDecimal mult(
            @PathVariable BigDecimal number1,
            @PathVariable BigDecimal number2
    ) {
        return number1.multiply(number2);
    }

    @PostMapping(value = "/div/{number1}/{number2}")
    public BigDecimal div(
            @PathVariable BigDecimal number1,
            @PathVariable BigDecimal number2
    ) {
        return number1.divide(number2, 2, RoundingMode.HALF_EVEN);
    }
}
