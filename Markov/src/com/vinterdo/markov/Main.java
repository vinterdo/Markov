package com.vinterdo.markov;

import java.util.ArrayList;
import java.util.List;

import com.vinterdo.markov.graph2d.AlgorithmValueIteration;
import com.vinterdo.markov.graph2d.MarkovGraph2D;
import com.vinterdo.markov.graph2d.MarkovNode2D;

public class Main
{
	
	private static final int	MAX_ITERATIONS	= 50;
	private static final double	EPSILON			= 0.0001;
												
	public static void main(String[] args)
	{
		world4x3();
		
		world4x4();
		
		world5x5();
		
	}
	
	private static void world5x5()
	{
		System.out.print("Markov 5x5\n\n");
		
		List<List<MarkovNode2D>> plan5x5 = new ArrayList<List<MarkovNode2D>>();
		List<MarkovNode2D> row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(90, MarkovNodeType.Terminal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Special));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(-50, MarkovNodeType.Terminal));
		plan5x5.add(row);
		row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Forbidden));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Forbidden));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		plan5x5.add(row);
		row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(-10, MarkovNodeType.Special));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Starting));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(-20, MarkovNodeType.Special));
		plan5x5.add(row);
		row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Forbidden));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Forbidden));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		plan5x5.add(row);
		row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(100, MarkovNodeType.Terminal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(-50, MarkovNodeType.Special));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(100, MarkovNodeType.Terminal));
		plan5x5.add(row);
		
		MarkovGraph2D world5x5 = new MarkovGraph2D(5, 5, 0.7f, 0.1f, 0.1f, 0.99f, -5, plan5x5);
		
		AlgorithmValueIteration calc = new AlgorithmValueIteration(world5x5);
		
		float change = 0;
		
		for (int i = 0; i < 50; i++)
		{
			change = world5x5.startingNode.value;
			world5x5.PrintGraph();
			calc.calculatorIteration();
			System.out.println();
			if (Math.abs(change - world5x5.startingNode.value) < 0.0001 && i > 10)
			{
				System.out.println("Ending after: " + i + " iterations");
				break;
			}
		}
	}
	
	private static void world4x4()
	{
		System.out.print("Markov 4x4\n\n");
		
		List<List<MarkovNode2D>> plan4x4 = new ArrayList<List<MarkovNode2D>>();
		List<MarkovNode2D> row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(0, MarkovNodeType.Starting));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Forbidden));
		row.add(new MarkovNode2D(100, MarkovNodeType.Terminal));
		plan4x4.add(row);
		row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(-20, MarkovNodeType.Special));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		plan4x4.add(row);
		row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		plan4x4.add(row);
		row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		plan4x4.add(row);
		
		MarkovGraph2D world4x4 = new MarkovGraph2D(4, 4, 0.8f, 0.1f, 0.1f, 0.99f, -10, plan4x4);
		
		AlgorithmValueIteration calc = new AlgorithmValueIteration(world4x4);
		
		float change = 0;
		
		for (int i = 0; i < 50; i++)
		{
			change = world4x4.startingNode.value;
			world4x4.PrintGraph();
			calc.calculatorIteration();
			System.out.println();
			if (Math.abs(change - world4x4.startingNode.value) < 0.0001 && i > 10)
			{
				System.out.println("Ending after: " + i + " iterations");
				break;
			}
		}
	}
	
	private static void world4x3()
	{
		System.out.print("Markov 4x3\n\n");
		
		List<List<MarkovNode2D>> plan4x3 = new ArrayList<>();
		List<MarkovNode2D> row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(0, MarkovNodeType.Starting));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		plan4x3.add(row);
		row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Forbidden));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(-1, MarkovNodeType.Terminal));
		plan4x3.add(row);
		row = new ArrayList<MarkovNode2D>();
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(0, MarkovNodeType.Normal));
		row.add(new MarkovNode2D(1, MarkovNodeType.Terminal));
		plan4x3.add(row);
		
		MarkovGraph2D world4x3 = new MarkovGraph2D(4, 3, 0.8f, 0.1f, 0.1f, 1, -0.04f, plan4x3);
		
		AlgorithmValueIteration calc = new AlgorithmValueIteration(world4x3);
		
		float change = 0;
		
		for (int i = 0; i < MAX_ITERATIONS; i++)
		{
			change = world4x3.startingNode.value;
			world4x3.PrintGraph();
			calc.calculatorIteration();
			System.out.println();
			if (Math.abs(change - world4x3.startingNode.value) < EPSILON && i > 10)
			{
				System.out.println("Ending after: " + i + " iterations");
				break;
			}
		}
	}
	
}
