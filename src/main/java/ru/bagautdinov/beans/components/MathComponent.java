package ru.bagautdinov.beans.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ru.bagautdinov.beans.model.MathOperation;

@Component
public class MathComponent {

	private List<Double> history;
	private List<MathOperation> memory;
	
	public MathComponent() {
		this.history = new ArrayList<>();
		this.memory = new ArrayList<>();
	}
	
	public List<Double> getHistory() {
		return history;
	}
	public void setHistory(List<Double> history) {
		this.history = history;
	}

	public List<MathOperation> getMemory() {
		return memory;
	}
	public void setMemory(List<MathOperation> memory) {
		this.memory = memory;
	}
	
	public void proceed(MathOperation op) {
		memory.add(op);
		if (memory.size() == 2) {
			MathOperation prevOp = memory.get(0);
			MathOperation currOp = memory.get(1);
			memory.clear();
			switch (prevOp.getFunction().charAt(0)) {
				case '+':
					add(prevOp, currOp);
					break;
				case '-':
					sub(prevOp, currOp);
					break;
				case '*':
					mul(prevOp, currOp);
					break;
				case '/':
					div(prevOp, currOp);
					break;
				case '=':
					memory.add(currOp);
					history.clear();
					break;
			}
		}
	}
	private void add(MathOperation prev, MathOperation curr) {
		Double result;
		result = Double.parseDouble(prev.getNumber()) + Double.parseDouble(curr.getNumber());
		curr.setNumber(String.valueOf(result));
		history.add(result);
		memory.add(curr);
	}
	private void sub(MathOperation prev, MathOperation curr) {
		Double result;
		result = Double.parseDouble(prev.getNumber()) - Double.parseDouble(curr.getNumber());
		curr.setNumber(String.valueOf(result));
		history.add(result);
		memory.add(curr);
	}
	private void div(MathOperation prev, MathOperation curr) {
		Double result;
		result = Double.parseDouble(prev.getNumber()) / Double.parseDouble(curr.getNumber());
		curr.setNumber(String.valueOf(result));
		history.add(result);
		memory.add(curr);
	}
	private void mul(MathOperation prev, MathOperation curr) {
		Double result;
		result = Double.parseDouble(prev.getNumber()) * Double.parseDouble(curr.getNumber());
		curr.setNumber(String.valueOf(result));
		history.add(result);
		memory.add(curr);
	}
}
