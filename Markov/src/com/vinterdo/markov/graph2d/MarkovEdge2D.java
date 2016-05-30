package com.vinterdo.markov.graph2d;

import com.vinterdo.markov.IMarkovEdge;
import com.vinterdo.markov.IMarkovNode;

public class MarkovEdge2D implements IMarkovEdge
{
	MarkovNode2D	source;
	MarkovNode2D	target;
					
	float			probability;
					
	@Override
	public IMarkovNode getTarget()
	{
		return target;
	}
	
	@Override
	public IMarkovNode getSource()
	{
		return source;
	}
	
	@Override
	public float getProbability()
	{
		return probability;
	}
	
}
