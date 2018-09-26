package es.vsanchezrod.proyectorest.persistencia.modelos;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Opiniones")
public class Opinion {

	// private String id;
	private Object actividad;
	private String titulo;
	private String detalle;
	private int organizacionValoracion;
	private int ambienteValoracion;
	private int recorridoValoracion;
	
	// private Usuario usuarioCreacion;
	// private Date fechaCreacion; 
	
	public Opinion() {}
	
	public Opinion(Object actividad, String titulo, String detalle, int organizacion, int ambiente, int recorrido) {
		this.actividad = actividad;
		this.titulo = titulo;
		this.detalle = detalle;
		this.organizacionValoracion = organizacion;
		this.ambienteValoracion = ambiente;
		this.recorridoValoracion = recorrido;
	}
	
	public Object getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getOrganizacionValoracion() {
		return organizacionValoracion;
	}
	public void setOrganizacionValoracion(int organizacionValoracion) {
		this.organizacionValoracion = organizacionValoracion;
	}
	public int getAmbienteValoracion() {
		return ambienteValoracion;
	}
	public void setAmbienteValoracion(int ambienteValoracion) {
		this.ambienteValoracion = ambienteValoracion;
	}
	public int getRecorridoValoracion() {
		return recorridoValoracion;
	}
	public void setRecorridoValoracion(int recorridoValoracion) {
		this.recorridoValoracion = recorridoValoracion;
	}

	@Override
	public String toString() {
		return "OpinionVO [actividad=" + actividad + ", titulo=" + titulo + ", detalle=" + detalle
				+ ", organizacionValoracion=" + organizacionValoracion + ", ambienteValoracion=" + ambienteValoracion
				+ ", recorridoValoracion=" + recorridoValoracion + "]";
	}
	
}


