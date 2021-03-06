package es.vsanchezrod.proyectorest.persistencia.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import es.vsanchezrod.proyectorest.persistencia.modelos.auditoria.AbstractAuditable;

@Document(collection= "Usuarios")
public class Usuario extends AbstractAuditable {

	@Id
	private String id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private Date fechaNacimiento;
	private String sexo;
	private Provincia provincia;
	private String avatar;
	private String info;
	private List<ActividadCategoria> intereses;  // id y nombre
	private boolean terminos;
	private Double valoracion;
	private Integer valoracionTotal;
	private Integer numeroValoraciones;
	private List<String> roles; // ROL
	private List<String> amigos; // id

	public Usuario() {
		this.intereses = new ArrayList<>();
		this.roles = new ArrayList<>();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<ActividadCategoria> getIntereses() {
		return intereses;
	}

	public void setIntereses(List<ActividadCategoria> intereses) {
		this.intereses = intereses;
	}

	public boolean getTerminos() {
		return terminos;
	}

	public void setTerminos(boolean terminos) {
		this.terminos = terminos;
	}

	public Double getValoracion() {
		return valoracion;
	}

	public void setValoracion(Double valoracion) {
		this.valoracion = valoracion;
	}
	
	public Integer getValoracionTotal() {
		return valoracionTotal;
	}

	public void setValoracionTotal(Integer valoracionTotal) {
		this.valoracionTotal = valoracionTotal;
	}

	public Integer getNumeroValoraciones() {
		return numeroValoraciones;
	}

	public void setNumeroValoraciones(Integer numeroValoraciones) {
		this.numeroValoraciones = numeroValoraciones;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public List<String> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<String> amigos) {
		this.amigos = amigos;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}