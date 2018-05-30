package kmedias;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Kmedias {
	
	private static final double tolerancia = 0.01;
	private static final int b = 2;

	private List<Muestra> centros;
	private List<Muestra> muestras;
	
	public Kmedias(List<Muestra> centros, List<Muestra> muestras)
	{
		this.centros = centros;
		this.muestras = muestras;
		calcCentros();
	}
	
	public void pertenencia(Muestra muestra)
	{
		List<Double> acumulados = new ArrayList<Double>();
		double acumD = 0.0;
		for(int i = 0; i < centros.size(); i++)
		{
			double acumA = 0.0;
			for(int k = 0; k < muestra.getDatos().size(); k++)
			{
				acumA += Math.pow(muestra.getDatos().get(k) - centros.get(i).getDatos().get(k), 2);
			}
			acumD += 1/acumA;
			acumulados.add(1/acumA);
		}
		double max = 0.0;
		int indMax = -1;
		for(int i = 0; i < acumulados.size(); ++i)
		{
			double d = acumulados.get(i);
			d = d / acumD;
			acumulados.set(i, d);
			if(d > max)
			{
				max = d;
				indMax = i;
			}
		}
		if(indMax != -1)
		{
			System.out.println("La muestra pertenece a la clase " + centros.get(indMax).getClase() + ": " + max);
		}
	}
	
	private boolean updateCentros()
	{
		boolean ready = true;
		double[][] u = new double[centros.size()][muestras.size()];
		Iterator<Muestra> mit = muestras.iterator();
		int mNum = 0;
		while(mit.hasNext())
		{
			Muestra m = mit.next();
			double[] ds = new double[centros.size()];
			double acum = 0.0;
			for(int r = 0; r < centros.size(); ++r)
			{
				Muestra c = centros.get(r);
				double d = 0.0;
				for(int i = 0; i < c.getDatos().size(); ++i)
				{
					d += Math.pow(c.getDatos().get(i) - m.getDatos().get(i), 2);
				}
				ds[r] = Math.pow(1/d, 1/(b-1));
				acum += Math.pow(1/d, 1/(b-1));
			}
			for(int r = 0; r < centros.size(); ++r)
			{
				u[r][mNum] = ds[r]/acum;
			}
			++mNum;
		}
		for(int i = 0; i < centros.size(); ++i)
		{
			ArrayList<Double> values = new ArrayList<Double>();
			for(int j = 0; j < centros.get(i).getDatos().size(); ++j)
			{
				values.add(0.0);
			}
			double acumB = 0.0;
			for(int j = 0; j < muestras.size(); ++j)
			{
				Muestra m = muestras.get(j);
				acumB += Math.pow(u[i][j], b);
				for(int k = 0; k < values.size(); ++k)
				{
					double v = values.get(k);
					v += m.getDatos().get(k) * Math.pow(u[i][j], b);
					values.set(k, v);
				}
			}
			double acumC = 0.0;
			for(int k = 0; k < values.size(); ++k)
			{
				double v = values.get(k);
				v = v/acumB;
				acumC += Math.abs(v - centros.get(i).getDatos().get(k));
				values.set(k, v);
			}
			centros.get(i).setDatos(values);
			if(acumC > tolerancia) ready = false;
		}	
		return ready;
	}
	
	private void calcCentros()
	{
		boolean ready = false;
		while(!ready)
		{
			ready = updateCentros();
		}
		System.out.println("Centros calculados: ");
		for(int i = 0; i < centros.size(); i++)
			System.out.println(centros.get(i).string());
	}
}
