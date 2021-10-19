package com.nexus.orderapi.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="MERCANCIAS")
public class Mercancia {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="NOMBRE",nullable = false, length = 100,unique = true)
	private String nombre;
	@Column(name="PRODUCTO",nullable = false,length = 200)
	private String producto;
	@Column(name = "CANTIDAD",nullable = false)
	private Integer cantidad;
	@Column(name = "FECHA_REG",nullable = false)
	private LocalDate fecha_ingreso;
	@OneToOne(mappedBy = "mercancia")
	private Usuario usuario;

}
