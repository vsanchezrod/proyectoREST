package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;
import java.util.List;

import es.vsanchezrod.proyectorest.persistencia.modelos.Categoria;

public class ActividadVO {

	private String nombre;
	private List<Categoria> categorias;
	private String descripcion;
	private String nivel;
	private String distancia;
	private Date fechaInicio;
	private String imagen;
	private List<String> coordenadas;
	private String idUsuarioCreacion;
		
	public ActividadVO() {}
	
	public ActividadVO(
			String nombre, List<Categoria> categorias, String descripcion, 
			String nivel, String distancia, Date fechaInicio, String imagen,
			List<String> coordenadas, String idUsuarioCreacion) {
		
		this.nombre = nombre;
		this.categorias = categorias;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.distancia = distancia;
		this.fechaInicio = fechaInicio;
		this.imagen = imagen;
		this.coordenadas = coordenadas;
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
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

	public List<String> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<String> coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(String idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}
	
	@Override
	public String toString() {
		return "ActividadVO [nombre=" + nombre + ", categorias=" + categorias + ", descripcion=" + descripcion
				+ ", nivel=" + nivel + ", distancia=" + distancia + ", fechaInicio=" + fechaInicio + ", imagen="
				+ imagen + ", coordenadas=" + coordenadas + ", idUsuarioCreacion=" + idUsuarioCreacion + "]";
	}
}
