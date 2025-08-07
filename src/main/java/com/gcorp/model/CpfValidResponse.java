package com.gcorp.model;

import org.springframework.http.HttpStatus;

public record CpfValidResponse(String cpf, HttpStatus status) {
}
