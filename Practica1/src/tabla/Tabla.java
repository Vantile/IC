package tabla;

import nodo.Nodo;

public class Tabla {
	
	public Nodo[][] p_nodos;
	
	public Tabla(int size)
	{
		p_nodos = new Nodo[size][size];
	}
}
