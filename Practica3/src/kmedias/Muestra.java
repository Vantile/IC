package kmedias;

import java.util.List;

public class Muestra {

	private List<Double> datos;
	private String clase;
	
	public List<Double> getDatos() {
		return datos;
	}
	public void setDatos(List<Double> datos) {
		this.datos = datos;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String string()
	{
		String s = "Clase: " + clase + " | Valores: ";
		for(int i = 0; i < datos.size(); ++i) {
			s += datos.get(i);
			if(i+1 < datos.size()) s += " , ";
		}
		return s;
	}
}
