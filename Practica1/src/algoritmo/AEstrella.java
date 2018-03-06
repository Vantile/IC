package algoritmo;

import java.util.ArrayList;

import nodo.Nodo;
import tabla.Coords;
import tabla.Tabla;

public class AEstrella {

	private Nodo p_nodoInicial;
	private Nodo p_nodoMeta;
	private Tabla p_tablero;
	private ArrayList<Nodo> p_abierta;
	private ArrayList<Nodo> p_cerrada;
	
	public AEstrella(Tabla tablero, Coords ini, Coords fin)
	{
		p_tablero = tablero;
		p_nodoInicial = p_tablero.p_nodos[ini.x][ini.y];
		p_nodoMeta = p_tablero.p_nodos[fin.x][fin.y];
		p_abierta = new ArrayList<Nodo>();
		p_cerrada = new ArrayList<Nodo>();
	}
	
	
}
