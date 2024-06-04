package com.desafio.viacep.infrastructure.controller.models;

import lombok.Data;

@Data
public class ConsultaCepResponse {

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String numero;
	private String localidade;
	private String uf;
}