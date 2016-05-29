package com.vinterdo.markov;

public interface IMarkovEdge {
	IMarkovNode getTarget();
	IMarkovNode getSource();
	float getProbability();
}
