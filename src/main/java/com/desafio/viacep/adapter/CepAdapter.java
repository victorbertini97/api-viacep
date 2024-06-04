package com.desafio.viacep.adapter;

import com.desafio.viacep.infrastructure.controller.models.ConsultaCepResponse;

public interface CepAdapter {

    ConsultaCepResponse get(String cep);
}
