package com.vinterdo.markov.graph2d;

import com.vinterdo.markov.IMarkovEdge;
import com.vinterdo.markov.IMarkovNode;

public class MarkovEdge2D implements IMarkovEdge
{
	MarkovNode2D	source;
	MarkovNode2D	target;
					
	float			probability;
					
	public MarkovEdge2D(MarkovNode2D source, MarkovNode2D target, float probability)
	{
		super();
		this.source = source;
		this.target = target;
		this.probability = probability;
	}
	
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
