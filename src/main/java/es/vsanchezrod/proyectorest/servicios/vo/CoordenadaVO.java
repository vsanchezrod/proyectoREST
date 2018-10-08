package es.vsanchezrod.proyectorest.servicios.vo;

public class CoordenadaVO {

	private int latitud;
	private int longitud;
	
	public int getLatitud() {
		return latitud;
	}

	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "CoordenadaVO [latitud=" + latitud + ", longitud=" + longitud + "]";
	}
		
}
