package com.desafio.viacep.business.usecases.cep.validators;

import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static com.desafio.viacep.business.usecases.cep.validators.regex.RegexValidations.CEP_REGEX;
import static java.lang.String.format;
import static java.util.regex.Pattern.compile;

@Component
public class CepValidator implements ConsultaCepValidator {

    private static final Pattern CEP_PATTERN = compile(CEP_REGEX);
    private static final String ERRO_CEP_INVALIDO = "CEP %s invalido";

    @Override
    public void validar(String cep) {
        var isCepValido = CEP_PATTERN.matcher(cep).matches();
        if(!isCepValido) throw new ValidationException(format(ERRO_CEP_INVALIDO, cep));
    }
}
