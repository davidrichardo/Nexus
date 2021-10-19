package com.nexus.orderapi.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nexus.orderapi.dto.MercanciaDTO;
import com.nexus.orderapi.entity.Mercancia;

import com.nexus.orderapi.services.MercanciaService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class MercanciaController {
	
	@Autowired
	private MercanciaService mercanciaService;
	
    @Autowired
    private ModelMapper modelMapper;

	
		
	@GetMapping(value="mercancias")
	public List<MercanciaDTO> findAll(){

		
		List<Mercancia> mercancias = mercanciaService.findAll();
		List mercanciasDtos = new ArrayList<MercanciaDTO>();
		for(Mercancia mercancia : mercancias) {
			mercanciasDtos.add(convertToDTO(mercancia));
			
		}
		return mercanciasDtos;
	}
	
	@GetMapping(value="mercancias/{mercanciaId}")
	public MercanciaDTO findById(@PathVariable("mercanciaId") Long mercanciaId) {
		
		Mercancia mercancia = mercanciaService.findById(mercanciaId);
		MercanciaDTO mercanciaDTO = convertToDTO(mercancia);
		
		return mercanciaDTO;
	}
	
	@PostMapping(value="mercancias")
	public MercanciaDTO create(@RequestBody MercanciaDTO mercanciaDTO) {
		Mercancia newMercanciaEntity = convertToEntity(mercanciaDTO);
		Mercancia newMercancia = mercanciaService.create(newMercanciaEntity);
		return convertToDTO(newMercancia);

	}
	
	@PutMapping(value="mercancias")
	public MercanciaDTO update(@RequestBody MercanciaDTO mercanciaDto) {
		
		Mercancia mercanciaUpdate = convertToEntity(mercanciaDto);
		Mercancia mercanciaUpdateEntity = mercanciaService.update(mercanciaUpdate);
		return convertToDTO(mercanciaUpdateEntity);
		
	}
	
	@DeleteMapping(value="mercancias/{mercanciaId}")
	public  void delete(@PathVariable("mercanciaId") Long mercanciaId) {
		
		mercanciaService.delete(mercanciaId);
	
	}
	
    private Mercancia convertToEntity (MercanciaDTO mercanciaDTO)
    {
        log.info("DTO Object = {} ", mercanciaDTO);

        Mercancia order = modelMapper.map(mercanciaDTO, Mercancia.class);

        return order;
    }

    private MercanciaDTO convertToDTO (Mercancia mercancia)
    {
        MercanciaDTO mercanciaDTO = modelMapper.map(mercancia, MercanciaDTO.class);
        return mercanciaDTO;
    }

	

}
	
	

