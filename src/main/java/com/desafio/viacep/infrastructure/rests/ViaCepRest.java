package com.desafio.viacep.infrastructure.rests;

import com.desafio.viacep.infrastructure.controller.models.ConsultaCepResponse;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "ViaCepRest", url = "${rests.via-cep.url}")
public interface ViaCepRest {

    @GetMapping(value = "/{cep}/json")
    @Retryable(noRetryFor = { FeignException.NotFound.class })
    Optional<ConsultaCepResponse> procurarCep(@PathVariable("cep") final String cep);
}
