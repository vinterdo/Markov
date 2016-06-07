package com.vinterdo.markov.graph2d;

import java.util.ArrayList;
import java.util.List;

import com.vinterdo.markov.IMarkovEdge;
import com.vinterdo.markov.IMarkovNode;
import com.vinterdo.markov.MarkovNodeType;

public class MarkovNode2D implements IMarkovNode
{
	
	MarkovEdge2D	upOutcoming;
	MarkovEdge2D	downOutcoming;
	MarkovEdge2D	leftOutcoming;
	MarkovEdge2D	rightOutcoming;
					
	float			reward;
	MarkovNodeType	type;
					
	public MarkovNode2D()
	{
	}
	
	@Override
	public List<IMarkovEdge> getOutcomingEdges()
	{
		List<IMarkovEdge> outcoming = new ArrayList<>();
		if (upOutcoming != null) outcoming.add(0, upOutcoming);
		if (downOutcoming != null) outcoming.add(0, downOutcoming);
		if (leftOutcoming != null) outcoming.add(0, leftOutcoming);
		if (rightOutcoming != null) outcoming.add(0, rightOutcoming);
		return outcoming;
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
	
	public void setEdgeUp(float prob, MarkovNode2D target)
	{
		this.upOutcoming = target == null ? null : new MarkovEdge2D(this, target, prob);
	}
	
	public void setEdgeDown(float prob, MarkovNode2D target)
	{
		this.downOutcoming = target == null ? null : new MarkovEdge2D(this, target, prob);
	}
	
	public void setEdgeRight(float prob, MarkovNode2D target)
	{
		this.rightOutcoming = target == null ? null : new MarkovEdge2D(this, target, prob);
	}
	
	public void setEdgeLeft(float prob, MarkovNode2D target)
	{
		this.leftOutcoming = target == null ? null : new MarkovEdge2D(this, target, prob);
	}
}
