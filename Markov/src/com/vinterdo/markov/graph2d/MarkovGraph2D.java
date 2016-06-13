package com.vinterdo.markov.graph2d;

import java.util.List;

import com.vinterdo.markov.MarkovNodeType;

public class MarkovGraph2D
{
	public MarkovNode2D		startingNode;
	public MarkovNode2D[][]	nodes;
	int						width, height;
							
	public float			prob1, prob2, prob3, prob4;
	public float			discounting;
	public float			defaultReward;
							
	public MarkovGraph2D(int sizeX, int sizeY, float p1, float p2, float p3, float disc, float defrew,
			List<List<MarkovNode2D>> plan)
	{
		width = sizeX;
		height = sizeY;
		prob1 = p1;
		prob2 = p2;
		prob3 = p3;
		prob4 = 1 - p1 - p2 - p3;
		discounting = disc;
		defaultReward = defrew;
		
		nodes = new MarkovNode2D[sizeX][sizeY];
		List<MarkovNode2D> row;
		
		for (int y = 0; y < sizeY; y++)
		{
			row = plan.get(y);
			for (int x = 0; x < sizeX; x++)
			{
				nodes[x][y] = row.get(x);
				if (nodes[x][y].getNodeType() == MarkovNodeType.Starting) startingNode = nodes[x][y];
			}
		}
	}
	
	public void printGraph()
	{
		for (int i = height - 1; i >= 0; i--)
		{
			for (int j = 0; j < width; j++)
			{
				switch (nodes[j][i].getNodeType())
				{
					case Forbidden:
						System.out.print("FORBIDDEN\t");
						break;
					case Normal:
						System.out.print(nodes[j][i].value + "     \t");
						break;
					case Special:
						System.out.print(nodes[j][i].value + "     \t");
						break;
					case Starting:
						System.out.print(nodes[j][i].value + "     \t");
						break;
					case Terminal:
						System.out.print("TERMINAL\t");
						break;
					default:
						break;
				}
			}
			System.out.println();
		}
		
	}
	
}
