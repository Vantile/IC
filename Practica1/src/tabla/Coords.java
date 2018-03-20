package tabla;

public class Coords {

	public int x;
	public int y;
	
	public Coords(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		Coords c = (Coords)obj;
		return (c.x == this.x && c.y == this.y);
	}
	
	
}
