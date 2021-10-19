package com.nexus.orderapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.nexus.orderapi.entity.Mercancia;
import com.nexus.orderapi.repository.MercanciaRepository;


@Service
public class MercanciaService {
	
	@Autowired
	private MercanciaRepository mercanciaRepo;
	

	public List<Mercancia> findAll(){

		List<Mercancia> mercancias = mercanciaRepo.findAll();
		return mercancias;
	}
	
	public Mercancia findById(Long mercanciaId) {
		
		Mercancia mercancia = mercanciaRepo.findById(mercanciaId).orElseThrow(()-> new RuntimeException("No existe la mercancia"));
		
		return mercancia;
	}
	

	public Mercancia create(Mercancia mercancia) {
		Mercancia newMercancia = mercanciaRepo.save(mercancia);

		return newMercancia;
	}
	

	public Mercancia update(Mercancia mercancia) {
		
		Mercancia mercanciaUpdate = mercanciaRepo.findById(mercancia.getId()).orElseThrow(() -> new RuntimeException("No existe la mercancia"));
		
		mercanciaUpdate.setNombre(mercancia.getNombre());
		mercanciaUpdate.setProducto(mercancia.getProducto());
		mercanciaUpdate.setCantidad(mercancia.getCantidad());
		
		mercanciaRepo.save(mercanciaUpdate);
		
		return mercanciaUpdate;
	}
	

	@Transactional
	public void delete( Long mercanciaId) {
		
		Mercancia deleteMercancia= mercanciaRepo.findById(mercanciaId).orElseThrow(() -> new RuntimeException("No Existe la Mercancia"));
		
		mercanciaRepo.delete(deleteMercancia);
		
	}
	
	

}
