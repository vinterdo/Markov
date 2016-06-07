package com.vinterdo.markov;

import java.util.Map;

import com.vinterdo.markov.graph2d.Coord;
import com.vinterdo.markov.graph2d.MarkovGraph2D;

public class Main
{
	
	public static void main(String[] args)
	{
		System.out.print("Markov");
		MarkovGraph2D mg = new MarkovGraph2D(4, 4, 0f, new Coord(0, 3));
		mg.setNode(new Coord(3, 3), 100, MarkovNodeType.Terminal);
		mg.setNode(new Coord(2, 2), -20, MarkovNodeType.Special);
		
		AlgorithmValueIteration algo = new AlgorithmValueIteration(0.1d);
		Map<IMarkovNode, Double> resultUtils = algo.valueIteration(mg, 0.000000001d);
		
		mg.printUtilities(resultUtils);
		//System.out.print(resultUtils);
		algo.covergence.printFor(mg.getNodes().get(0));
		
	}
	
}
