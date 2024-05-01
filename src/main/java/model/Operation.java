package model;

import java.util.Objects;

public class Operation
{

	double num1;
	double num2;
	
	String op;
	double result;
	public Operation(double num1, String op, double num2,double result)
	{
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.op = op;
		this.result = result;
	}
	@Override
	public String toString()
	{
		return num1 + op+ num2+" = "+ result;
	}
	@Override
	public int hashCode()
	{
		return Objects.hash(num1, num2, op, result);
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operation other = (Operation) obj;
		return almostequal(num1,other.num1)
				&& almostequal(num2,other.num2) && Objects.equals(op, other.op)
				&& almostequal(result,other.result);
	}
	private boolean almostequal(double a, double b) 
	{
		double dif = a - b;
		dif = Math.abs(dif);
		if (dif < 0.00001) {return true;}
		return false;
	}
	
	
	
	
	
}
