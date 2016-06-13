package com.vinterdo.markov.graph2d;

import com.vinterdo.markov.MarkovNodeType;

public class MarkovNode2D
{
	public float			value;
	private float			reward;
	private MarkovNodeType	type;
							
	public MarkovNode2D(float rew, MarkovNodeType t)
	{
		reward = rew;
		type = t;
		value = 0;
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
