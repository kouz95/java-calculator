package unit.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class ExpressionTest {
	@Test
	void testTokens() {
		List<Token> invalidTokens = Arrays.asList(new Number("1"), new Operator("+"), new Operator("+"));
		assertThatThrownBy(() -> {
			new Expression(invalidTokens);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("연산자 혹은 숫자의 개수가 너무 많습니다.");

		List<Token> scarceTokens = Arrays.asList(new Number("1"), new Operator("+"));
		assertThatThrownBy(() -> {
			new Expression(scarceTokens);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("식은 최소 3자 이상이어야 합니다.");
	}

	@Test
	void testGetExpression() {
		List<Token> value = Arrays.asList(new Number("1"), new Operator("+"), new Number("2"));
		Expression expression = new Expression(value);
		Stack<Token> actual = expression.getExpression();
		Stack<Token> expected = new Stack<>();
		expected.push(new Number("2"));
		expected.push(new Operator("+"));
		expected.push(new Number("1"));
		assertThat(actual).isEqualTo(expected);
	}
}