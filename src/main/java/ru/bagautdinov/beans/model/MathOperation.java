package ru.bagautdinov.beans.model;

public class MathOperation {

	private String number;
	private String function;
	
	public void setFunction(String function) {
		this.function = function;
	}
	public String getFunction() {
		return function;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "(" + number + ", " + function + ")";
	}
	
}
