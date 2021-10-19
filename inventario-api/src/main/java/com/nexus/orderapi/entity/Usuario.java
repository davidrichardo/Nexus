package com.nexus.orderapi.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USUARIOS")
public class Usuario {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@Column(name = "EDAD",nullable = false)
	private Integer edad;
	@Enumerated(EnumType.STRING)
	@Column(name = "CARGO",nullable = false,length = 20)
	private Cargo cargo;
	@Column(name = "FECHA_INGRESO", nullable = false)
	private LocalDate fecha_ingreso;
	@OneToOne
	@JoinColumn(name = "fk_mercancia",nullable = false)
	private Mercancia mercancia;

}
