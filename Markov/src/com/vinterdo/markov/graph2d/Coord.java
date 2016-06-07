package com.vinterdo.markov.graph2d;

public class Coord
{
	public int	x;
	public int	y;
				
	public Coord(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public Coord clone()
	{
		return new Coord(x, y);
	}
}
