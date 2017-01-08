package MathLogic;

import java.io.Serializable;

public class Map implements Serializable{
	private static final long serialVersionUID = 1L;
	private double[][] value;
	private Noise n;

	Map(int width, int height, Noise n)
	{
		this.n = n;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				double nx = x/width - 0.5, ny = y/height - 0.5;
				value[y][x] = noise(nx, ny);
			}
		}
	}
	double noise(double nx, double ny) 
	{
		return n.noise(nx, ny) / 2.0 + 0.5;
		//values are permitted to shift;
	}
	
	public double[][] getValue()
	{
		return value;
	}

}
