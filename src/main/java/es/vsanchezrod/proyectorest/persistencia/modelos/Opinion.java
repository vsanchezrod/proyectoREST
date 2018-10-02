package es.vsanchezrod.proyectorest.persistencia.modelos;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Opiniones")
public class Opinion {

	private String id;
	private Object actividad;
	private String titulo;
	private String detalle;
	private Date fecha;
	private int organizacionValoracion;
	private int ambienteValoracion;
	private int recorridoValoracion;	
	private Usuario usuario;
	
	public Opinion() {}
	
	public Opinion(String id, Object actividad, String titulo, String detalle, Date fecha, int organizacion, int ambiente, int recorrido, Usuario usuario) {
		this.id = id;
		this.actividad = actividad;
		this.titulo = titulo;
		this.detalle = detalle;
		this.fecha = new Date();
		this.organizacionValoracion = organizacion;
		this.ambienteValoracion = ambiente;
		this.recorridoValoracion = recorrido;
		this.usuario = usuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Opinion [id=" + id + ", actividad=" + actividad + ", titulo=" + titulo + ", detalle=" + detalle
				+ ", fecha=" + fecha + ", organizacionValoracion=" + organizacionValoracion + ", ambienteValoracion="
				+ ambienteValoracion + ", recorridoValoracion=" + recorridoValoracion + ", usuario=" + usuario + "]";
	}

}


