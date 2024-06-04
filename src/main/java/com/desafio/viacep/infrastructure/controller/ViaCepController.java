package com.desafio.viacep.infrastructure.controller;

import com.desafio.viacep.adapter.CepAdapter;
import com.desafio.viacep.business.usecases.cep.ConsultaCepUseCase;
import com.desafio.viacep.infrastructure.controller.models.ConsultaCepResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ViaCepController implements CepAdapter {

	private ConsultaCepUseCase consultaCepUseCase;

	@GetMapping(value = "/{cep}")
	public ConsultaCepResponse get(@PathVariable String cep) {
        return consultaCepUseCase.buscar(cep);
	}
}