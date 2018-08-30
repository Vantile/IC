package main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
			Nodo raiz = new Nodo(null, "");
			Arbol a = new Arbol(raiz, atributos);
			while(it.hasNext())
			{
				String[] valores = it.next().split(",");
				a.insert(valores);
			}
			Scanner s = new Scanner(System.in);
			String[] search = new String[atributos.length];
			for(int i = 0; i < atributos.length; ++i)
			{
				String prompt = "Introduzca el valor a buscar para el atributo ";
				prompt += atributos[i];
				prompt += ":";
				System.out.println(prompt);
				search[i] = s.nextLine();
			}
			s.close();
			boolean[] result = a.search(search);
			boolean found = result[0];
			boolean valorFinal = result[1];
			if(found)
			{
				System.out.println("Valor encontrado");
				if(valorFinal)
				{
					System.out.println("Valor: " + Arbol.TRUE_RESPONSE);
				}
				else
				{
					System.out.println("Valor: " + Arbol.FALSE_RESPONSE);
				}
			}
			else
			{
				System.out.println("Valor no encontrado");
			}
		} catch (Exception e) {
			System.out.println("Error parsing file.");
			e.printStackTrace();
		}
	}
}
