package com.vinterdo.markov.graph2d;

import com.vinterdo.markov.MarkovNodeType;

public class MarkovNode2D
{
	public float			value	= 0;
	private float			reward	= 0;
	private MarkovNodeType	type	= MarkovNodeType.Normal;
									
	public MarkovNode2D()
	{
	}
	
	public MarkovNode2D(float rew)
	{
		reward = rew;
	}
	
	public MarkovNode2D(float rew, MarkovNodeType t)
	{
		reward = rew;
		type = t;
	}
	
	public float getReward()
	{
		return reward;
	}
	
	public MarkovNodeType getNodeType()
	{
		return type;
	}
	
	public void setReward(float rew)
	{
		reward = rew;
	}
	
	public void setType(MarkovNodeType newType)
	{
		type = newType;
	}
}
