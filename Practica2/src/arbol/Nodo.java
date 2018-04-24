package arbol;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

	private Nodo p_padre;
	private List<Nodo> p_hijos;
	private String p_valor;
	private String p_atributo;
	private boolean p_esHoja;
	
	public Nodo() {}
	
	public Nodo(Nodo padre, String valor, boolean hoja, String atributo)
	{
		this.p_padre = padre;
		this.p_hijos = new ArrayList<Nodo>();
		this.p_valor = valor;
		this.setHoja(hoja);
		this.setAtributo(atributo);
	}

	public Nodo getPadre() {
		return p_padre;
	}

	public void setPadre(Nodo padre) {
		this.p_padre = padre;
	}

	public List<Nodo> getHijos() {
		return p_hijos;
	}

	public void setHijos(List<Nodo> hijos) {
		this.p_hijos = hijos;
	}
	
	public void addHijo(Nodo hijo) {
		this.p_hijos.add(hijo);
	}

	public String getValor() {
		return p_valor;
	}

	public void setValor(String valor) {
		this.p_valor = valor;
	}

	public String getAtributo() {
		return p_atributo;
	}

	public void setAtributo(String p_atributo) {
		this.p_atributo = p_atributo;
	}

	public boolean isHoja() {
		return p_esHoja;
	}

	public void setHoja(boolean p_esHoja) {
		this.p_esHoja = p_esHoja;
	}
	
	
	
}
