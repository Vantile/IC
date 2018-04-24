package main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import arbol.Arbol;
import arbol.Nodo;

public class Main {

public static void main(String[] args) {
		
		final String atributosFile = "AtributosJuego.txt";
		final String juegoFile = "Juego.txt";
		Path atributosPath = Paths.get(atributosFile);
		Path juegoPath = Paths.get(juegoFile);
		try {
			List<String> lines = Files.readAllLines(atributosPath);
			String[] atributos = lines.get(0).split(",");
			lines = Files.readAllLines(juegoPath);
			Iterator<String> it = lines.iterator();
			Nodo raiz = new Nodo(null, "", false, atributos[0]);
			Arbol a = new Arbol(raiz);
			while(it.hasNext())
			{
				String[] valores = it.next().split(",");
				int i = 0;
				for(i = 0; i + 1 < valores.length; ++i)
				{
					Nodo aux = a.insert(atributos, valores);
//					Nodo aux = a.search(atributos[i], valores[i]);
					/*
					 * Si es null, crear el nodo en su sitio.
					 * Si no lo es, guardarlo para usarlo mas tarde.
					 */
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error parsing file.");
			e.printStackTrace();
		}
	}
}
