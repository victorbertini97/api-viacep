package com.desafio.viacep.infrastructure.rests.facade;

import com.desafio.viacep.adapter.ConsultaCepAdapter;
import com.desafio.viacep.infrastructure.controller.models.ConsultaCepResponse;
import com.desafio.viacep.infrastructure.rests.ViaCepRest;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.lang.String.format;
import static java.util.Optional.empty;

@Slf4j
@Component
@AllArgsConstructor
public class ConsultaCepRestFacade implements ConsultaCepAdapter {

    private static final String ERRO_AO_CONSULTAR_CEP = "Ocorreu um erro ao consultar cep %s";

    private ViaCepRest viaCepRest;

    @Override
    public Optional<ConsultaCepResponse> consultarCep(String cep) {
        try {
            return viaCepRest.procurarCep(cep);
        } catch (FeignException e) {
            log.error(format(ERRO_AO_CONSULTAR_CEP, cep), e);
            return empty();
        }
    }
}
