package com.example.springboot.repositorio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.springboot.Moneda;
import com.example.springboot.Pais;

@Component	// Registra la clase como un componente de Springboot
public class PaisRepository {

	private static final Map<String, Pais> paises = new HashMap<>();
	
	public PaisRepository() {

		Pais francia = new Pais();
		francia.setNombre("francia");
		francia.setCapital("paris");
		francia.setPoblacion(99999);
		francia.setMoneda(Moneda.EUR);
		
		Pais alemania = new Pais();
		alemania.setNombre("alemania");
		alemania.setCapital("berlin");
		alemania.setPoblacion(99999);
		alemania.setMoneda(Moneda.EUR);
		
		Pais inglaterra = new Pais();
		inglaterra.setNombre("inglaterra");
		inglaterra.setCapital("londres");
		inglaterra.setPoblacion(99999);
		inglaterra.setMoneda(Moneda.GBP);

		paises.put(francia.getNombre(), francia);
		paises.put(alemania.getNombre(), alemania);
		paises.put(inglaterra.getNombre(), inglaterra);
		
	}
	
	
	public Pais buscarPais(String nombre) {
		return paises.get(nombre);
	}
	
	
}
