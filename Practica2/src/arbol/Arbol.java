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
		if(n.getHijos().isEmpty())
		{
			if(atributos.length > level)
			{
				Nodo hijo = new Nodo(n, valores[level], false);
				n.addHijo(hijo);
				if(valorFinal.equals(TRUE_RESPONSE)) hijo.setAllFalse(false);
				else if(valorFinal.equals(FALSE_RESPONSE)) hijo.setAllTrue(false);
				insert(hijo, atributos, valores, found, level+1, valorFinal);
			}
			else
			{
				Nodo hijo = new Nodo(n, valores[level], true);
				n.addHijo(hijo);
				if(valorFinal.equals(TRUE_RESPONSE)) hijo.setAllFalse(false);
				else if(valorFinal.equals(FALSE_RESPONSE)) hijo.setAllTrue(false);
				found = true;
			}
		}
		else
		{
			Iterator<Nodo> it = n.getHijos().iterator();
			boolean child = false;
			while(it.hasNext())
			{
				Nodo hijo = it.next();
				if(!hijo.getValor().equals(valores[level])) continue;
				insert(hijo, atributos, valores, found, level+1, valorFinal);
				child = true;
			}
			
			if(!child)
			{
				if(atributos.length > level)
				{
					Nodo hijo = new Nodo(n, valores[level], false);
					n.addHijo(hijo);
					if(valorFinal.equals(TRUE_RESPONSE)) hijo.setAllFalse(false);
					else if(valorFinal.equals(FALSE_RESPONSE)) hijo.setAllTrue(false);
					insert(hijo, atributos, valores, found, level+1, valorFinal);
				}
				else
				{
					Nodo hijo = new Nodo(n, valores[level], true);
					n.addHijo(hijo);
					if(valorFinal.equals(TRUE_RESPONSE)) hijo.setAllFalse(false);
					else if(valorFinal.equals(FALSE_RESPONSE)) hijo.setAllTrue(false);
					found = true;
				}
			}
		}
	}
	
	private Nodo search(Nodo n, String[] valor, boolean found, int level)
	{
		if(!found && n.getPadre() != null && n.getPadre().getValor().equals(valor[level]))
		{
			if(level == p_atributos.length && n.getHijos().isEmpty())
			{
				found = true;
				return n;
			}
			else
			{
				return search();
			}
		}
	}
}
