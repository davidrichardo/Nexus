package com.nexus.orderapi.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Mercancia {

	private Long id;
	private String nombre;
	private String producto;
	private Integer cantidad;
	private Date fecha_ingreso;
//	private Usuario usuario;

}
