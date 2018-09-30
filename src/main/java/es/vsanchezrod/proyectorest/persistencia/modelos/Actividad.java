package es.vsanchezrod.proyectorest.persistencia.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Actividad {

	@Id
	private String id;
	private String nombre;
	private List<Categoria> categorias;
	private String descripcion;
	private int nivel;
	private int distancia;
	private Date fechaInicio;
	private String imagen;
	private Coordenada coordenadas;
	private String idUsuarioCreacion;
	
	public Actividad() {}
	
	public Actividad(
			String id, String nombre, List<Categoria> categorias, String descripcion, 
			int nivel, int distancia, Date fechaInicio, String imagen,
			Coordenada coordenadas, String idUsuarioCreacion) {
		
		this.id = id;
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

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
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

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", nombre=" + nombre + ", categorias=" + categorias + ", descripcion="
				+ descripcion + ", nivel=" + nivel + ", distancia=" + distancia + ", fechaInicio=" + fechaInicio
				+ ", imagen=" + imagen + ", coordenadas=" + coordenadas + ", idUsuarioCreacion=" + idUsuarioCreacion
				+ "]";
	}
	
}
