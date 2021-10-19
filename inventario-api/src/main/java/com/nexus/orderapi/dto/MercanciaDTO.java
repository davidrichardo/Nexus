package com.nexus.orderapi.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MercanciaDTO {

	private Long id;

	private String nombre;

	private String producto;

	private Integer cantidad;
	
	private LocalDate fecha_ingreso;

}
