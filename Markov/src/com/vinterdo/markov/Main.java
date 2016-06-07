package com.vinterdo.markov;

import java.util.Map;

import com.vinterdo.markov.graph2d.Coord;
import com.vinterdo.markov.graph2d.MarkovGraph2D;

public class Main
{
	
	public static void main(String[] args)
	{
		System.out.print("Markov");
		MarkovGraph2D mg = new MarkovGraph2D(4, 3, 0.04f, new Coord(0, 3));
		mg.setNode(new Coord(3, 0), 1, MarkovNodeType.Terminal);
		mg.setNode(new Coord(3, 1), -1, MarkovNodeType.Terminal);
		
		Map<IMarkovNode, Double> resultUtils = new AlgorithmValueIteration(0.5d).valueIteration(mg, 0.01d);
		
		mg.printUtilities(resultUtils);
		//System.out.print(resultUtils);
		
	}
	
}
