package com.gcorp.validators;

import org.springframework.stereotype.Component;

@Component
public class CpfValidator {
    public static boolean isValidCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // CPF precisa ter 11 dígitos
        if (cpf.length() != 11) return false;

        // Elimina CPFs com todos os dígitos iguais (ex: 11111111111)
        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            // Calcula o primeiro dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }

            int digito1 = 11 - (soma % 11);
            if (digito1 >= 10) digito1 = 0;

            // Calcula o segundo dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }

            int digito2 = 11 - (soma % 11);
            if (digito2 >= 10) digito2 = 0;

            // Verifica se os dígitos calculados conferem com os do CPF informado
            return (cpf.charAt(9) - '0' == digito1) && (cpf.charAt(10) - '0' == digito2);

        } catch (Exception e) {
            return false;
        }
    }
}
