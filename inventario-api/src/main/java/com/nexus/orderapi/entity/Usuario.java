package com.nexus.orderapi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Usuario {
	private Long id;
	private String nombre;
	private Integer edad;
	private Cargo cargo;
	private String fecha_ingreso;
}
