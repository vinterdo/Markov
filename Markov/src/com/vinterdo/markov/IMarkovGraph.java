package com.vinterdo.markov;

import java.util.List;

public interface IMarkovGraph
{
	List<IMarkovNode> getNodes();
	
	IMarkovNode getStartingNode();
	
	IMarkovGraph clone();
	
}
