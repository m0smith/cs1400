/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package a03;

/*******************************************************
* Sample Code - do not modify
* Assignment: A03
*******************************************************/

public class Country
{
   // fields
	private String name;
	private int population; 
	private int area; // in square miles
	
	// constructors
	
	// methods
	public String getName()
	{
		return name;
	}
	
	public int getPopulation()
	{
		return population;
	}	
	
	public int getArea()
	{
		return area;
	}	
	
	public void setName(String newName)
	{
		name = newName;
	}

	public void setPopulation(int newPopulation)
	{
		population = newPopulation;
	}

	public void setArea(int newArea)
	{
		area = newArea;
	}
	
	// population per square mile
	public int populationDensity()
	{
		int density;
		density = population / area; // integer division truncates
		return density;
	}
}
