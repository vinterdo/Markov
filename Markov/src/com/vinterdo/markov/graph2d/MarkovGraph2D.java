package com.vinterdo.markov.graph2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.vinterdo.markov.IMarkovGraph;
import com.vinterdo.markov.IMarkovNode;
import com.vinterdo.markov.MarkovNodeType;

public class MarkovGraph2D implements IMarkovGraph
{
	Coord				startingNode;
	final float			basicReward;
	MarkovNode2D[][]	nodes;
						
	public MarkovGraph2D(int sizeX, int sizeY, float basicReward, Coord start)
	{
		this.basicReward = basicReward;
		
		nodes = new MarkovNode2D[sizeX][sizeY];
		for (int y = 0; y < sizeY; y++)
		{
			for (int x = 0; x < sizeX; x++)
			{
				nodes[x][y] = new MarkovNode2D();
				nodes[x][y].reward = basicReward;
			}
		}
		
		for (int y = 0; y < sizeY; y++)
		{
			for (int x = 0; x < sizeX; x++)
			{
				nodes[x][y].setEdgeUp(0.5f, getNodeOrNull(x, y - 1));
				nodes[x][y].setEdgeDown(0.5f, getNodeOrNull(x, y + 1));
				nodes[x][y].setEdgeRight(0.5f, getNodeOrNull(x + 1, y));
				nodes[x][y].setEdgeLeft(0.5f, getNodeOrNull(x - 1, y));
			}
		}
		nodes.toString();
	}
	
	private MarkovNode2D getNodeOrNull(int x, int y)
	{
		return x >= 0 && y >= 0 && x < nodes.length && y < nodes[0].length ? nodes[x][y] : null;
	}
	
	@Override
	public List<IMarkovNode> getNodes()
	{
		return twoDArrayToList(nodes);
	}
	
	@Override
	public IMarkovNode getStartingNode()
	{
		return nodes[startingNode.x][startingNode.y];
	}
	
	private <T> List<T> twoDArrayToList(T[][] twoDArray)
	{
		List<T> list = new ArrayList<T>();
		for (T[] array : twoDArray)
		{
			list.addAll(Arrays.asList(array));
		}
		return list;
	}
	
	@Override
	public IMarkovGraph clone()
	{
		MarkovGraph2D cloned = new MarkovGraph2D(0, 0, 0, null);
		cloned.nodes = nodes.clone();
		cloned.startingNode = startingNode.clone();
		
		return cloned;
	}
	
	public void setNode(Coord coord, float reward, MarkovNodeType type)
	{
		nodes[coord.x][coord.y].reward = reward;
		nodes[coord.x][coord.y].type = type;
	}
	
	public void printUtilities(Map<IMarkovNode, Double> utils)
	{
		System.out.print("\n");
		for (int y = 0; y < nodes[0].length; y++)
		{
			for (int x = 0; x < nodes.length; x++)
			{
				System.out.print(utils.get(nodes[x][y]) + "     ");
			}
			
			System.out.print("\n");
		}
	}
}
