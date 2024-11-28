package com.mx.ApiPelis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiPelis.entity.Peliculas;
import com.mx.ApiPelis.repository.PeliculasRepository;

@Service
public class PeliculasServImp {

	@Autowired
	PeliculasRepository repository;
	
	@Transactional(readOnly = true)
	public List<Peliculas> listar(){
		return (List<Peliculas>) repository.findAll();
	}
	
	@Transactional
	public boolean guardar(Peliculas pelicula) {
		boolean bandera = false;
		for(Peliculas p: repository.findAll()) {
			if(p.getNombre().equals(pelicula.getNombre())) {
				bandera = true;
				break;
			}
		}if(bandera == false)
			repository.save(pelicula);
		return bandera;
	}
	
}
