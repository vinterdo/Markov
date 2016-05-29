package com.vinterdo.markov;

import java.util.List;

public interface IMarkovGraph
{
	List<IMarkovEdge> getEdges();
	
	List<IMarkovNode> getNodes();
	
	IMarkovNode getStartingNode();
}
