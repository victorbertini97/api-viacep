package com.desafio.viacep.business.usecases.cep;

import com.desafio.viacep.business.exception.ResourceNotFoundException;
import com.desafio.viacep.business.usecases.cep.validators.ConsultaCepValidator;
import com.desafio.viacep.infrastructure.controller.models.ConsultaCepResponse;
import com.desafio.viacep.infrastructure.rests.facade.ConsultaCepRestFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@AllArgsConstructor
public class ConsultaCepUseCase {

    private static final String ERRO_CEP_NAO_ENCONTRADO = "CEP não encontrado '%s'";

    private ConsultaCepValidator consultaCepValidator;
    private ConsultaCepRestFacade consultaCepRestFacade;

    public ConsultaCepResponse buscar(final String cep) {
        consultaCepValidator.validar(cep);
        return buscarCep(cep);
    }

    private ConsultaCepResponse buscarCep(String cep) {
        return consultaCepRestFacade.consultarCep(cep)
                .orElseThrow(() -> new ResourceNotFoundException(format(ERRO_CEP_NAO_ENCONTRADO, cep)));
    }
}
