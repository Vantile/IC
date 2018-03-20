package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import algoritmo.AEstrella;
import nodo.Nodo;
import tabla.Coords;
import tabla.Tabla;

public class Main {

	public static void main(String[] args) {
		
		final String boardFile = "board.txt";
		Path file = Paths.get(boardFile);
		try {
			List<String> lines = Files.readAllLines(file);
			Iterator<String> it = lines.iterator();
			int size = Integer.parseInt(it.next());
			Tabla tabla = new Tabla(size);
			Nodo[][] tablero = tabla.p_nodos;
			for(int i = 0; i < size; ++i)
			{
				for(int j = 0; j < size; ++j)
				{
					tablero[i][j] = new Nodo(Integer.parseInt(it.next())==1, new Coords(i,j));
				}
			}
			String coords = it.next();
			String[] aux = coords.split(" ");
			Coords ini = new Coords(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));
			coords = it.next();
			aux = coords.split(" ");
			Coords fin = new Coords(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]));
			AEstrella alg = new AEstrella(tabla, ini, fin);
			alg.start();
		} catch (Exception e) {
			System.out.println("Error parsing board file " + boardFile);
			e.printStackTrace();
		}
	}

}
