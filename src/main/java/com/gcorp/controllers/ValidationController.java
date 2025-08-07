package com.gcorp.controllers;

import com.gcorp.exception.InvalidCPFException;
import com.gcorp.model.CpfValidResponse;
import com.gcorp.validators.CpfValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

    @RequestMapping("cpfvalidator/{cpf}")
    public ResponseEntity<CpfValidResponse> cpfValidator(@PathVariable String cpf) {
        if (!CpfValidator.isValidCPF(cpf)) {
            throw new InvalidCPFException("CPF inválido");
        }

        return new ResponseEntity<>(new CpfValidResponse(cpf, HttpStatus.OK), HttpStatus.OK);
    }

}
