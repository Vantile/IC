package nodo;

public class Nodo {
	
	private int p_valor;
	private int p_coste;
	private Nodo p_padre;
	
	public Nodo(int valor, int coste, Nodo padre)
	{
		p_valor = valor;
		p_coste = coste;
		p_padre = padre;
	}

	public int getP_valor() {
		return p_valor;
	}

	public void setP_valor(int p_valor) {
		this.p_valor = p_valor;
	}

	public int getP_coste() {
		return p_coste;
	}

	public void setP_coste(int p_coste) {
		this.p_coste = p_coste;
	}

	public Nodo getP_padre() {
		return p_padre;
	}

	public void setP_padre(Nodo p_padre) {
		this.p_padre = p_padre;
	}
	
	
}
