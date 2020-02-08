package unit.domain;

public class Calculator {
	private final Expression expression;

	public Calculator(Expression expression) {
		this.expression = expression;
	}

	public double getResult() {
		return expression.calculate();
	}
}
