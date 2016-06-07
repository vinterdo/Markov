package com.vinterdo.markov;

import java.util.List;
import java.util.Map;

public class AlgorithmValueIteration
{
	private double discount;
	
	public AlgorithmValueIteration(double discount)
	{
		if (discount > 1.0 || discount <= 0.0)
		{
			throw new IllegalArgumentException("Discount must be between 0 and 1");
		}
		this.discount = discount;
	}
	
	public Map<IMarkovNode, Double> valueIteration(IMarkovGraph mdp, double epsilon)
	{
		Map<IMarkovNode, Double> utilities = Util.create(mdp.getNodes(), new Double(0));
		Map<IMarkovNode, Double> deltaUtilities = Util.create(mdp.getNodes(), new Double(0));
		double delta = 0;
		double minDelta = epsilon * (1 - discount) / discount;
		
		do
		{
			utilities.putAll(deltaUtilities);
			delta = 0;
			for (IMarkovNode s : mdp.getNodes())
			{
				List<IMarkovEdge> actions = s.getOutcomingEdges();
				double aMax = 0;
				if (actions.size() > 0)
				{
					aMax = Double.NEGATIVE_INFINITY;
				}
				for (IMarkovEdge a : actions)
				{
					double aSum = 0;
					for (IMarkovEdge edge : s.getOutcomingEdges())
					{
						aSum += edge.getProbability() * utilities.get(edge.getTarget());
					}
					
					if (aSum > aMax)
					{
						aMax = aSum;
					}
				}
				deltaUtilities.put(s, s.getReward() + discount * aMax);
				double aDiff = Math.abs(deltaUtilities.get(s) - utilities.get(s));
				if (aDiff > delta)
				{
					delta = aDiff;
				}
			}
		}
		while (delta > minDelta);
		
		return utilities;
	}
}
