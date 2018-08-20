package arbol;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

	private Nodo p_padre;
	private List<Nodo> p_hijos;
	private String p_valor;
	private String p_atributo;
	private boolean p_esHoja;
	private boolean allTrue;
	private boolean allFalse;
	
	public Nodo() {}
	
	public Nodo(Nodo padre, String valor)
	{
		this.p_padre = padre;
		this.p_hijos = new ArrayList<Nodo>();
		this.p_valor = valor;
		setAllTrue(true);
		setAllFalse(true);
	}
	
	

	@Override
	public String toString() {
		return "Nodo [p_padre=" + p_padre + ", p_hijos=" + p_hijos + ", p_valor=" + p_valor + ", p_atributo="
				+ p_atributo + ", p_esHoja=" + p_esHoja + "]";
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

	public boolean isAllTrue() {
		return allTrue;
	}

	public void setAllTrue(boolean allTrue) {
		this.allTrue = allTrue;
	}

	public boolean isAllFalse() {
		return allFalse;
	}

	public void setAllFalse(boolean allFalse) {
		this.allFalse = allFalse;
	}
	
	
	
}
