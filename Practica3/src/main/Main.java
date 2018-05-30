package main;

import java.util.ArrayList;
import java.util.List;

import kmedias.Kmedias;
import kmedias.Muestra;
import parser.Parser;

public class Main {

	public static void main(String[] args) {
		
		List<Muestra> muestras = Parser.parse("Iris2Clases.txt");
		List<Double> centro1 = new ArrayList<Double>();
		List<Double> centro2 = new ArrayList<Double>();
		centro1.add(4.6);
		centro1.add(3.0);
		centro1.add(4.0);
		centro1.add(0.0);
		centro2.add(6.8);
		centro2.add(3.4);
		centro2.add(4.6);
		centro2.add(0.7);
		Muestra centroClase1 = new Muestra();
		centroClase1.setDatos(centro1);
		centroClase1.setClase(Parser.getClasses().get(0));
		Muestra centroClase2 = new Muestra();
		centroClase2.setDatos(centro2);
		centroClase2.setClase(Parser.getClasses().get(1));
		List<Muestra> centros = new ArrayList<Muestra>();
		centros.add(centroClase1);
		centros.add(centroClase2);
		Kmedias alg = new Kmedias(centros, muestras);
	}

}
