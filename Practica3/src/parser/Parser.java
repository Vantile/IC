package parser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kmedias.Muestra;

public class Parser {
	
	private static List<String> classes = new ArrayList<String>();
	
	public Parser() {}
	
	public static List<Muestra> parse(String file)
	{
		classes = new ArrayList<String>();
		Path filePath = Paths.get(file);
		try
		{
			List<String> lines = Files.readAllLines(filePath);
			Iterator<String> it = lines.iterator();
			List<Muestra> list = new ArrayList<Muestra>();
			while(it.hasNext())
			{
				String[] valores = it.next().split(",");
				Muestra m = new Muestra();
				List<Double> valoresList = new ArrayList<Double>();
				for(int i = 0; i < valores.length - 1; ++i)
				{
					valoresList.add(Double.parseDouble(valores[i]));
				}
				String clase = valores[valores.length-1];
				if(!classes.contains(clase)) classes.add(clase);
				m.setClase(clase);
				m.setDatos(valoresList);
				list.add(m);
			}
			return list;
		} 
		catch(Exception e) 
		{
			System.out.println("Error parsing file.");
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<String> getClasses()
	{
		return classes;
	}

}
