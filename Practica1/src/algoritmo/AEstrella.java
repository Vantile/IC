package algoritmo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import nodo.Nodo;
import tabla.Coords;
import tabla.Tabla;

public class AEstrella {

	private Nodo p_nodoInicial;
	private Nodo p_nodoMeta;
	private Tabla p_tablero;
	private PriorityQueue<Nodo> p_abierta;
	private ArrayList<Nodo> p_cerrada;
	private double p_coste;
	private Coords p_ini;
	private Coords p_fin;
	
	public AEstrella(Tabla tablero, Coords ini, Coords fin)
	{
		p_tablero = tablero;
		p_nodoInicial = p_tablero.p_nodos[ini.x][ini.y];
		p_nodoMeta = p_tablero.p_nodos[fin.x][fin.y];
		p_abierta = new PriorityQueue<Nodo>();
		p_cerrada = new ArrayList<Nodo>();
		p_ini = ini;
		p_fin = fin;
		p_coste = 0;
		calcCosts();
	}
	
	public void start()
	{
		Nodo nodoActual = p_nodoInicial;
		p_cerrada.add(nodoActual);
		System.out.println("El camino comienza en: " + nodoActual.toString());
		System.out.println();
		System.out.println();
		while(!nodoActual.equals(p_nodoMeta))
		{
			addAdjacent(nodoActual);
			Nodo nodoNuevo = p_abierta.poll();
			p_cerrada.add(nodoNuevo);
			p_coste += coste(nodoActual.getCoords(), nodoNuevo.getCoords());
			nodoActual = nodoNuevo;
			System.out.println("Siguiente punto elegido: " + nodoActual.toString());
			System.out.println("Camino actual: " + p_cerrada.toString());
			System.out.println("Coste actual: " + p_coste);
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Camino finalizado: " + p_cerrada.toString());
		System.out.println("Coste total: " + p_coste);
	}
	
	private void addAdjacent(Nodo nodoActual)
	{
		int min_x = nodoActual.getCoords().x - 1;
		int max_x = nodoActual.getCoords().x + 1;
		int min_y = nodoActual.getCoords().y - 1;
		int max_y = nodoActual.getCoords().y + 1;
		for(int i = min_x; i <= max_x; ++i)
		{
			for(int j = min_y; j <= max_y; ++j)
			{
				if(i >= 0 && i < p_tablero.getSize() && j >= 0 && j < p_tablero.getSize())
				{
					Nodo aux = p_tablero.p_nodos[i][j];
					if(aux.isActivo() && !nodoActual.getCoords().equals(aux.getCoords()) && !p_abierta.contains(aux) && !p_cerrada.contains(aux))
						p_abierta.add(p_tablero.p_nodos[i][j]);
				}
			}
		}
	}
	
	private void calcCosts()
	{
		for(int i = 0; i < p_tablero.getSize(); ++i)
		{
			for(int j = 0; j < p_tablero.getSize(); ++j)
			{
				double coste = coste(new Coords(i, j), p_fin);
				p_tablero.p_nodos[i][j].setCoste(coste);
			}
		}
	}
	
	private double coste(Coords ini, Coords fin)
	{
		return Math.sqrt(Math.pow(fin.x - ini.x, 2) + Math.pow(fin.y - ini.y, 2));
	}
	
	
}
