package com.vinterdo.markov.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vinterdo.markov.IMarkovNode;

public class Covergence
{
	List<Map<IMarkovNode, Double>> covergenceList;
	
	public Covergence()
	{
		covergenceList = new ArrayList<>();
	}
	
	public void addNew(Map<IMarkovNode, Double> values)
	{
		covergenceList.add(values);
	}
	
	public void printFor(IMarkovNode node)
	{
		for (Map<IMarkovNode, Double> value : covergenceList)
		{
			System.out.println(value.get(node));
		}
	}
}
