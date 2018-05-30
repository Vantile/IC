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
	
	private void calcCentros()
	{
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
				ds[r] = 1/d;
				acum += 1/d;
			}
			for(int r = 0; r < centros.size(); ++r)
			{
				u[r][mNum] = ds[r]/acum;
			}
			++mNum;
		}
		for(int i = 0; i < centros.size(); ++i)
		{
			Muestra newCenter = new Muestra();
			ArrayList<Double> values = new ArrayList<Double>();
			for(int j = 0; j < centros.get(i).getDatos().size(); ++j)
			{
				values.add(0.0);
			}
			double acumB = 0.0;
			for(int j = 0; j < muestras.size(); ++j)
			{
				Muestra m = muestras.get(j);
				acumB += Math.pow(u[i][j], 2);
				for(int k = 0; k < values.size(); ++k)
				{
					double v = values.get(k);
					v += m.getDatos().get(k) * Math.pow(u[i][j], 2);
					values.set(k, v);
				}
			}
		}
	}
}
