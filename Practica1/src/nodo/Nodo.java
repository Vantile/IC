package nodo;

public class Nodo {
	
	private int p_valor;
	private int p_coste;
	private Nodo p_padre;
	private boolean p_activo;
	
	public Nodo(boolean activo)
	{
		p_activo = activo;
	}
	
	public Nodo(int valor, int coste, Nodo padre, boolean activo)
	{
		p_valor = valor;
		p_coste = coste;
		p_padre = padre;
		setActivo(activo);
	}

	public int getValor() {
		return p_valor;
	}

	public void setValor(int p_valor) {
		this.p_valor = p_valor;
	}

	public int getCoste() {
		return p_coste;
	}

	public void setCoste(int p_coste) {
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
	
	
}
