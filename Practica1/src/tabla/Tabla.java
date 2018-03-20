package tabla;

import nodo.Nodo;

public class Tabla {
	
	public Nodo[][] p_nodos;
	public int p_size;
	
	public Tabla(int size)
	{
		p_nodos = new Nodo[size][size];
		p_size = size;
	}
	
	public int getSize()
	{
		return p_size;
	}
}
