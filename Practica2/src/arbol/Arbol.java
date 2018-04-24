package arbol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Arbol {

	private Nodo p_raiz;
	
	public Arbol()
	{
		p_raiz = new Nodo();
	}
	
	public Arbol(Nodo n)
	{
		p_raiz = n;
	}
	
	public Nodo insert(String[] atributos, String[] valores)
	{
		boolean found = false;
		int level = 0;
		Queue<String> atributosList = new LinkedList();
		
		return insert(p_raiz, atributos, valores, found, level);
	}
	
	public Nodo search(String atributo, String valor)
	{
		return search(p_raiz, atributo, valor, false);
	}

	public Nodo getRaiz() {
		return p_raiz;
	}
	
	private Nodo insert(Nodo n, String[] atributos, String[] valores, boolean found, int level)
	{
		if(n.getHijos().isEmpty() && !n.isHoja())
		{
			if(level == atributos.length)
			{
				Nodo hijo = new Nodo(n, valores[level], true, atributos[level+1]);
			}
			
			
		}
	}
	
	private Nodo search(Nodo n, String atributo, String valor, boolean found)
	{
		if(!found && n.getPadre() != null && n.getPadre().getAtributo().equals(atributo) && n.getValor().equals(valor))
		{
			found = true;
			return n;
		}
		else
		{
			Iterator<Nodo> it = n.getHijos().iterator();
			Nodo aux = null;
			while(it.hasNext())
			{
				aux = search(it.next(), atributo, valor, found);
			}
			return aux;
		}
	}
}
