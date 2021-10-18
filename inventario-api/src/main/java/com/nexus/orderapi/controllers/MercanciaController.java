package com.nexus.orderapi.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nexus.orderapi.entity.Mercancia;

@RestController
public class MercanciaController {

	private List<Mercancia> mercancias = new ArrayList<>();
	
	public MercanciaController() {
		
		for(int c=0;c<10;c++) {
			mercancias.add(Mercancia.builder()
					.id(c+1L)
					.nombre("Nombre"+(c+1))
					.producto("producto"+(c+1))
					.cantidad(1)
//					.fecha_ingreso(new Date())
					.build()
					);
			}
	}
		
	@GetMapping(value="mercancias")
	public List<Mercancia> findAll(){
		return this.mercancias;
	}
	
	@GetMapping(value="mercancias/{mercanciaId}")
	public Mercancia findById(@PathVariable("mercanciaId") Long mercanciaId) {
		for(Mercancia mercancia : mercancias) {
			if(mercancia.getId().longValue() == mercanciaId.longValue()) {
				return mercancia;
			}
			
		}
		return null;
	}
	
	@PostMapping(value="mercancias")
	public Mercancia create(@RequestBody Mercancia mercancia) {
		mercancias.add(mercancia);
		return mercancia; 
	}
	
	@PutMapping(value="mercancias")
	public Mercancia update(@RequestBody Mercancia mercancia) {
		for(Mercancia mercan : this.mercancias) {
			if(mercan.getId().longValue()==mercancia.getId().longValue()) {
				mercan.setCantidad(mercancia.getCantidad());
				mercan.setNombre(mercancia.getNombre());
				mercan.setProducto(mercancia.getProducto());
				return mercan;
			}
		}
		throw new RuntimeException("No existe Productos");	
	}
	
	@DeleteMapping(value="mercancias/{mercanciaId}")
	public void delete(@PathVariable("mercanciaId") Long mercancia) {
		
		Mercancia deleteMercancia = null;
		
		for(Mercancia mercan: this.mercancias) {
			if(mercancia.longValue()==mercan.getId().longValue()) {
				deleteMercancia = mercan;
				break;
			}
		}
		if(deleteMercancia == null) throw new RuntimeException("No existe el id");
			
		this.mercancias.remove(deleteMercancia);
		
	}

	

}
	
	

