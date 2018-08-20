package arbol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Arbol {
	
	private static final String FALSE_RESPONSE = "no";
	private static final String TRUE_RESPONSE = "si";

	private Nodo p_raiz;
	private String[] p_atributos;
	
	public Arbol()
	{
		p_raiz = new Nodo();
	}
	
	public Arbol(Nodo n, String[] atributos)
	{
		p_raiz = n;
		p_atributos = atributos;
	}
	
	public void insert(String[] valores)
	{
		boolean found = false;
		int level = 0;
		
		insert(p_raiz, p_atributos, valores, found, level, valores[p_atributos.length]);
	}
	
	public Nodo search(String[] valor)
	{
		boolean found = false;
		int level = 0;
		return search(p_raiz, valor, found, level);
	}

	public Nodo getRaiz() {
		return p_raiz;
	}
	
	private void insert(Nodo n, String[] atributos, String[] valores, boolean found, int level, String valorFinal)
	{
		if(level < atributos.length)
		{
			if(n.getHijos().isEmpty())
			{
				Nodo newNode = new Nodo(n, valores[level]);
				n.addHijo(newNode);
				insert(newNode, atributos, valores, found, level+1, valorFinal);
			}
			else
			{
				if(containsValue(n, valores[level]))
				{
					Nodo child = returnChild(n, valores[level]);
					insert(child, atributos, valores, found, level+1, valorFinal);
				}
				else
				{
					Nodo newNode = new Nodo(n, valores[level]);
					n.addHijo(newNode);
					insert(newNode, atributos, valores, found, level+1, valorFinal);
				}
			}
			
			if(valorFinal == FALSE_RESPONSE && allChildFalse(n))
			{
				n.setAllFalse(true);
			}
			else
			{
				n.setAllFalse(false);
			}
			
			if(valorFinal == TRUE_RESPONSE && allChildTrue(n))
			{
				n.setAllTrue(true);
			}
			else
			{
				n.setAllTrue(false);
			}
		}
		else
		{
			if(valorFinal == FALSE_RESPONSE)
			{
				n.setAllFalse(true);
			}
			else
			{
				n.setAllFalse(false);
			}
			
			if(valorFinal == TRUE_RESPONSE)
			{
				n.setAllTrue(true);
			}
			else
			{
				n.setAllTrue(false);
			}
		}
	}
	
	private boolean allChildFalse(Nodo n)
	{
		if(n.getHijos().isEmpty()) return true;
		Iterator<Nodo> it = n.getHijos().iterator();
		boolean check = true;
		while(it.hasNext() && check)
		{
			Nodo auxNode = it.next();
			if(!auxNode.isAllFalse()) check = false;
		}
		return check;
	}
	
	private boolean allChildTrue(Nodo n)
	{
		if(n.getHijos().isEmpty()) return true;
		Iterator<Nodo> it = n.getHijos().iterator();
		boolean check = true;
		while(it.hasNext() && check)
		{
			Nodo auxNode = it.next();
			if(!auxNode.isAllTrue()) check = false;
		}
		return check;
	}
	
	private boolean containsValue(Nodo n, String value)
	{
		Iterator<Nodo> it = n.getHijos().iterator();
		boolean check = false;
		while(it.hasNext() && !check)
		{
			Nodo aux = it.next();
			if(aux.getValor().equals(value)) check = true;
		}
		return check;
	}
	
	private Nodo returnChild(Nodo n, String value)
	{
		Iterator<Nodo> it = n.getHijos().iterator();
		boolean check = false;
		Nodo ret = n;
		while(it.hasNext() && !check)
		{
			Nodo aux = it.next();
			if(aux.getValor().equals(value))
			{
				ret = aux;
				check = true;
			}
		}
		return ret;
	}
	
	private Nodo search(Nodo n, String[] valor, boolean found, int level)
	{
//		if(!found && n.getPadre() != null && n.getPadre().getValor().equals(valor[level]))
//		{
//			if(level == p_atributos.length && n.getHijos().isEmpty())
//			{
//				found = true;
//				return n;
//			}
//			else
//			{
//				return search();
//			}
//		}
	}
}
