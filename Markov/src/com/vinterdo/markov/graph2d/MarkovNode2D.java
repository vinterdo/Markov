package com.vinterdo.markov.graph2d;

import java.util.ArrayList;
import java.util.List;

import com.vinterdo.markov.IMarkovEdge;
import com.vinterdo.markov.IMarkovNode;
import com.vinterdo.markov.MarkovNodeType;

public class MarkovNode2D implements IMarkovNode
{
	MarkovEdge2D	upIncoming;
	MarkovEdge2D	downIncoming;
	MarkovEdge2D	leftIncoming;
	MarkovEdge2D	rightIncoming;
					
	MarkovEdge2D	upOutcoming;
	MarkovEdge2D	downOutcoming;
	MarkovEdge2D	leftOutcoming;
	MarkovEdge2D	rightOutcoming;
					
	float			reward;
	MarkovNodeType	type;
					
	@Override
	public List<IMarkovEdge> getOutcomingEdges()
	{
		List<IMarkovEdge> outcoming = new ArrayList<>();
		outcoming.add(0, upOutcoming);
		outcoming.add(0, downOutcoming);
		outcoming.add(0, leftOutcoming);
		outcoming.add(0, rightOutcoming);
		return outcoming;
	}
	
	@Override
	public List<IMarkovEdge> getIncomingEdges()
	{
		List<IMarkovEdge> incoming = new ArrayList<>();
		incoming.add(0, upIncoming);
		incoming.add(0, downIncoming);
		incoming.add(0, leftIncoming);
		incoming.add(0, rightIncoming);
		return incoming;
	}
	
	@Override
	public float getReward()
	{
		return reward;
	}
	
	@Override
	public MarkovNodeType getNodeType()
	{
		return type;
	}
	
}
