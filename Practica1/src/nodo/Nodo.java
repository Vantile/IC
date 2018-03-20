package nodo;

import tabla.Coords;

public class Nodo implements Comparable<Nodo> {
	
	private int p_valor;
	private double p_coste;
	private Nodo p_padre;
	private boolean p_activo;
	private Coords p_coords;
	
	public Nodo(boolean activo, Coords coords)
	{
		p_activo = activo;
		p_coords = coords;
	}
	
	public Nodo(int valor, int coste, Nodo padre, boolean activo, Coords coords)
	{
		p_valor = valor;
		p_coste = coste;
		p_padre = padre;
		p_coords = coords;
		setActivo(activo);
	}

	public int getValor() {
		return p_valor;
	}

	public void setValor(int p_valor) {
		this.p_valor = p_valor;
	}

	public double getCoste() {
		return p_coste;
	}

	public void setCoste(double p_coste) {
		this.p_coste = p_coste;
	}

	public Nodo getPadre() {
		return p_padre;
	}

	public void setPadre(Nodo p_padre) {
		this.p_padre = p_padre;
	}

	public boolean isActivo() {
		return p_activo;
	}

	public void setActivo(boolean p_activo) {
		this.p_activo = p_activo;
	}
	
	public Coords getCoords() {
		return p_coords;
	}
	
	public void setCoords(Coords c) {
		this.p_coords = c;
	}

	@Override
	public int compareTo(Nodo arg0) {
		int res;
		if (this.p_coste < arg0.p_coste) res = -1;
		else if (this.p_coste == arg0.p_coste) res = 0;
		else res = 1;
		return res;
	}
	
	@Override
	public String toString()
	{
		return "(" + this.p_coords.x + ", " + this.p_coords.y + ")";
	}
}
