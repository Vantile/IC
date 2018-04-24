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
			Nodo raiz = new Nodo(null, "", false);
			Arbol a = new Arbol(raiz, atributos);
			while(it.hasNext())
			{
				String[] valores = it.next().split(",");
				a.insert(valores);
			}
			System.out.println("B R U H");
		} catch (Exception e) {
			System.out.println("Error parsing file.");
			e.printStackTrace();
		}
	}
}
