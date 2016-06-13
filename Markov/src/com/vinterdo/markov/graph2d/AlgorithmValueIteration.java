package com.vinterdo.markov.graph2d;

import com.vinterdo.markov.MarkovNodeType;

public class AlgorithmValueIteration
{
	MarkovGraph2D world;
	
	public AlgorithmValueIteration(MarkovGraph2D w)
	{
		world = w;
	}
	
	float optionValue(MarkovNode2D source, int destx, int desty)
	{
		MarkovNode2D dest;
		//Moving out of the world
		if (destx < 0 || destx >= world.width || desty < 0 || desty >= world.height)
			return source.value + source.getReward();
		dest = world.nodes[destx][desty];
		if (dest.getNodeType() == MarkovNodeType.Forbidden)
			return source.value + source.getReward();
		else
			return dest.value + dest.getReward();
			
	}
	
	void updateValue(MarkovNode2D node, int x, int y)
	{
		//Right, left, up, down
		float usability[] =
		{ 0, 0, 0, 0 };
		float computedUsability[] =
		{ 0, 0, 0, 0 };
		usability[0] = optionValue(node, x + 1, y);
		usability[1] = optionValue(node, x - 1, y);
		usability[2] = optionValue(node, x, y + 1);
		usability[3] = optionValue(node, x, y - 1);
		
		computedUsability[0] = world.defaultReward + world.prob1 * usability[0] + world.prob2 * usability[2]
				+ world.prob3 * usability[3] + world.prob4 * usability[1];
		float max = computedUsability[0];
		
		computedUsability[1] = world.defaultReward + world.prob1 * usability[1] + world.prob2 * usability[3]
				+ world.prob3 * usability[2] + world.prob4 * usability[0];
		if (computedUsability[1] > max) max = computedUsability[1];
		
		computedUsability[2] = world.defaultReward + world.prob1 * usability[2] + world.prob2 * usability[1]
				+ world.prob3 * usability[0] + world.prob4 * usability[3];
		if (computedUsability[2] > max) max = computedUsability[2];
		
		computedUsability[3] = world.defaultReward + world.prob1 * usability[3] + world.prob2 * usability[0]
				+ world.prob3 * usability[1] + world.prob4 * usability[2];
		if (computedUsability[3] > max) max = computedUsability[3];
		
		node.value = max * world.discounting + node.getReward();
	}
	
	public void calculatorIteration()
	{
		for (int i = 0; i < world.width; i++)
		{
			for (int j = 0; j < world.height; j++)
			{
				MarkovNode2D node = world.nodes[i][j];
				if (node.getNodeType() != MarkovNodeType.Forbidden && node.getNodeType() != MarkovNodeType.Terminal)
				{
					updateValue(node, i, j);
				}
			}
			
		}
		
	}
	
}
