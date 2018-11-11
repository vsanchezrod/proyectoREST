package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import es.vsanchezrod.proyectorest.persistencia.modelos.Coordenada;

public class ActividadVO {

	private String id;
	private String nombre;
	private List<ActividadCategoriaVO> categorias; // id y nombre
	private String descripcion;
	private Integer nivel;
	private Integer distancia;
	private Date fechaInicio;
	private String imagen;
	private Coordenada coordenadas;
	private String idUsuarioCreacion;  // solo la id
	private List<String> listaParticipantes; // id de los usuarios
	private Integer puntuacion;
		
	public ActividadVO () {
		this.categorias = new ArrayList<>();
		this.listaParticipantes = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ActividadCategoriaVO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<ActividadCategoriaVO> categorias) {
		this.categorias = categorias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(String idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	public List<String> getListaParticipantes() {
		return listaParticipantes;
	}

	public void setListaParticipantes(List<String> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
