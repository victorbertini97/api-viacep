package com.desafio.viacep.adapter;

import com.desafio.viacep.infrastructure.controller.models.ConsultaCepResponse;

import java.util.Optional;

public interface ConsultaCepAdapter {

    Optional<ConsultaCepResponse> consultarCep(String cep);
}
