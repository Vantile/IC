package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		System.out.println("Algoritmo preparado, escoge muestra a analizar: ");
		System.out.println("1. Test 1");
		System.out.println("2. Test 2");
		System.out.println("3. Test 3");
		System.out.println("4. Otro archivo");
		System.out.print("-> ");
		int opt = -1;
		try 
		{
			Scanner s = new Scanner(System.in);
			opt = s.nextInt();
			switch(opt)
			{
			case 1:
			{
				List<Muestra> test = Parser.parse("TestIris01.txt");
				Muestra m = test.get(0);
				alg.pertenencia(m);
			}
			break;
			case 2:
			{
				List<Muestra> test = Parser.parse("TestIris02.txt");
				Muestra m = test.get(0);
				alg.pertenencia(m);
			}
			break;
			case 3:
			{
				List<Muestra> test = Parser.parse("TestIris03.txt");
				Muestra m = test.get(0);
				alg.pertenencia(m);
			}
			break;
			case 4:
			{
				System.out.println("Escribe el nombre del archivo: ");
				System.out.print("-> ");
				s.reset();
				String file = s.next();
				List<Muestra> test = Parser.parse(file);
				Muestra m = test.get(0);
				alg.pertenencia(m);
			}
			break;
			default:
			{
				throw new Exception("Opcion incorrecta.");
			}
			}
		} catch (Exception e) 
		{
			System.out.println("El algoritmo no pudo completarse.");
		}
	}

}
