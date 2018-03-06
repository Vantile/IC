package main;

import algoritmo.AEstrella;
import nodo.Nodo;
import tabla.Coords;
import tabla.Tabla;

public class Main {

	public static void main(String[] args) {
		Tabla tabla = new Tabla(5);
		Nodo[][] tablero = tabla.p_nodos;
		tablero[0][0] = new Nodo(false);
		tablero[0][1] = new Nodo(true);
		tablero[0][2] = new Nodo(true);
		tablero[0][3] = new Nodo(true);
		tablero[0][4] = new Nodo(true);
		tablero[1][0] = new Nodo(true);
		tablero[1][1] = new Nodo(false);
		tablero[1][2] = new Nodo(true);
		tablero[1][3] = new Nodo(true);
		tablero[1][4] = new Nodo(true);
		tablero[2][0] = new Nodo(true);
		tablero[2][1] = new Nodo(false);
		tablero[2][2] = new Nodo(true);
		tablero[2][3] = new Nodo(true);
		tablero[2][4] = new Nodo(true);
		tablero[3][0] = new Nodo(true);
		tablero[3][1] = new Nodo(false);
		tablero[3][2] = new Nodo(true);
		tablero[3][3] = new Nodo(true);
		tablero[3][4] = new Nodo(true);
		tablero[4][0] = new Nodo(true);
		tablero[4][1] = new Nodo(false);
		tablero[4][2] = new Nodo(true);
		tablero[4][3] = new Nodo(true);
		tablero[4][4] = new Nodo(true);
		Coords ini = new Coords(4, 0);
		Coords fin = new Coords(3, 4);
		AEstrella alg = new AEstrella(tabla, ini, fin);
	}

}
