package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;
import java.util.List;

import es.vsanchezrod.proyectorest.persistencia.modelos.Rol;

public class UsuarioVO {

	private String id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private Date fechaNacimiento;
	private String sexo;
	private ProvinciaVO provincia;
	private String avatar;
	private String info;
	private List<InteresVO> intereses;
	private boolean terminos;
	private int valoracion;
	private List<Rol> roles;
	
	public UsuarioVO() {}
	
	public UsuarioVO(String id, String nombre, String apellido, String email, String password, Date fechaNacimiento, String sexo, 
					 ProvinciaVO provincia, String avatar, String info, List<InteresVO> intereses, boolean terminos, int valoracion, List<Rol> roles) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.provincia = provincia;
		this.avatar = avatar;
		this.info = info;
		this.intereses = intereses;
		this.terminos = terminos;
		this.valoracion = valoracion;
		this.roles = roles;
				
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
	
	public ProvinciaVO getProvincia() {
		return provincia;
	}
	
	public void setProvincia(ProvinciaVO provincia) {
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
	
	public List<InteresVO> getIntereses() {
		return intereses;
	}
	
	public void setIntereses(List<InteresVO> intereses) {
		this.intereses = intereses;
	}
	
	public boolean getTerminos() {
		return terminos;
	}
	
	public void setTerminos(boolean terminos) {
		this.terminos = terminos;
	}
	
	public int getValoracion() {
		return valoracion;
	}
	
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	public List<Rol> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UsuarioVO [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", password=" + password + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", provincia="
				+ provincia + ", avatar=" + avatar + ", info=" + info + ", intereses=" + intereses + ", terminos="
				+ terminos + ", valoracion=" + valoracion + ", roles=" + roles + "]";
	}
	
}
