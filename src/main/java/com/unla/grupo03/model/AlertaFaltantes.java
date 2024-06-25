package com.unla.grupo03.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "AlertaFaltantes")
public class AlertaFaltantes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="producto", nullable=false, length=45)
	private String producto;
	
	@Column(name="fecha", nullable=false)
	private LocalDate fecha;
	
	@Column(name="hora", nullable=false)
	private LocalTime hora;
	
	@Column(name="alta", nullable=false)
	private boolean alta;

	@Override
	public String toString() {
		return "AlertaFaltantes [producto=" + producto + ", fecha=" + fecha + ", hora=" + hora + ", alta=" + alta + "]";
	}
}
