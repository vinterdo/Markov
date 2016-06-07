package com.vinterdo.markov;

import java.util.List;

public interface IMarkovNode
{
	List<IMarkovEdge> getOutcomingEdges();
	
	float getReward();
	
	MarkovNodeType getNodeType();
}