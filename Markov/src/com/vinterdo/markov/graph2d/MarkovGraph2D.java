package com.vinterdo.markov.graph2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vinterdo.markov.IMarkovEdge;
import com.vinterdo.markov.IMarkovGraph;
import com.vinterdo.markov.IMarkovNode;

public class MarkovGraph2D implements IMarkovGraph
{
	MarkovNode2D		startingNode;
						
	MarkovNode2D[][]	nodes;
	List<MarkovEdge2D>	edgesUp;
	List<MarkovEdge2D>	edgesDown;
	List<MarkovEdge2D>	edgesLeft;
	List<MarkovEdge2D>	edgesRight;
						
	public MarkovGraph2D(int sizeX, int sizeY, Coord start)
	{
		nodes = new MarkovNode2D[sizeX][sizeY];
		for (int y = 0; y < sizeY; y++)
		{
			for (int x = 0; x < sizeX; x++)
			{
				nodes[x][y] = new MarkovNode2D();
			}
		}
	}
	
	@Override
	public List<IMarkovEdge> getEdges()
	{
		List<IMarkovEdge> allEdges = new ArrayList<>(edgesUp);
		allEdges.addAll(edgesDown);
		allEdges.addAll(edgesLeft);
		allEdges.addAll(edgesRight);
		return allEdges;
	}
	
	@Override
	public List<IMarkovNode> getNodes()
	{
		return twoDArrayToList(nodes);
	}
	
	@Override
	public IMarkovNode getStartingNode()
	{
		return startingNode;
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
}
