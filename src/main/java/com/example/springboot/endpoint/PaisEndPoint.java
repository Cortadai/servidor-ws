package com.example.springboot.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.springboot.GetPaisRequest;
import com.example.springboot.GetPaisResponse;
import com.example.springboot.repositorio.PaisRepository;

@Endpoint
public class PaisEndPoint {

	private static final String NAMESPACE_URI = "http://example.com/springboot";
	
	private PaisRepository paisRepository;

	@Autowired
	public PaisEndPoint(PaisRepository paisRepository) {
		super();
		this.paisRepository = paisRepository;
	}

	// @PayloadRoot = El punto de entrada de las peticiones para "getPais"
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaisRequest")
	@ResponsePayload
	public GetPaisResponse getPais(@RequestPayload GetPaisRequest peticion) {
		GetPaisResponse respuesta = new GetPaisResponse();
		respuesta.setPais(paisRepository.buscarPais(peticion.getNombre()));
		return respuesta;
	}
	
	
}
