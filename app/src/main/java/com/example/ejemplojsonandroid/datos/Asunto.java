package com.example.ejemplojsonandroid.datos;

import java.io.Serializable;
import java.util.Date;

public class Asunto implements Serializable {
	private static final long serialVersionUID = -5951574143898646914L;
	private Date fecha;
	private String tema;
	private Integer tareas;
		
	public Asunto(Date fecha, String tema, Integer tareas) {
		super();
		this.fecha = fecha;
		this.tema = tema;
		this.tareas = tareas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Integer getTareas() {
		return tareas;
	}

	public void setTareas(Integer tareas) {
		this.tareas = tareas;
	}
	
}
