package com.vinterdo.markov;

import java.util.List;

public interface IMarkovNode
{
	List<IMarkovEdge> getOutcomingEdges();
	
	List<IMarkovEdge> getIncomingEdges();
	
	float getReward();
	
	MarkovNodeType getNodeType();
}