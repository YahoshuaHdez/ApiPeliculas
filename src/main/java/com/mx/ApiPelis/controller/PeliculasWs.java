package com.mx.ApiPelis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiPelis.entity.Peliculas;
import com.mx.ApiPelis.service.PeliculasServImp;

@RestController
@RequestMapping("PeliculasWs")
@CrossOrigin
public class PeliculasWs {

	@Autowired
	PeliculasServImp imp;
	
	//http://localhost:9000/PeliculasWs/listar
	@GetMapping("listar")
	public List<Peliculas> listar(){
		return imp.listar();
	}
	
	//http://localhost:9000/PeliculasWs/guardar
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Peliculas pelicula){
		boolean response = imp.guardar(pelicula);
		
		if(response == true)
			return new ResponseEntity<>("ESE NOMBRE DE PELICULA YA EXISTE",HttpStatus.OK);
		else
			return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
	}
	
}
