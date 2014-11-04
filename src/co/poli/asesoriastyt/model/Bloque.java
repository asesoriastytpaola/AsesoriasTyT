package co.poli.asesoriastyt.model;

public class Bloque {


	private String idbloque;
	private String nombrebloque;
	
	
	public String getIdBloque() {
		return idbloque;
	}
	public void setIdBloque(String idbloque) {
		this.idbloque = idbloque;
	}
	public String getNombreBloque() {
		return nombrebloque;
	}
	public void setNombreBloque(String nombrebloque) {
		this.nombrebloque = nombrebloque;
	}
	
	@Override
	public String toString() {
		return "Bloque [idbloque=" + idbloque + ", nombrebloque=" + nombrebloque+ "]";
	}

}
