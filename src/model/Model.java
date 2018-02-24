package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class serves as a model in the MVC pattern. It updates the string displayed
 *  to the user in the input bar based on the buttons that were pressed.
 * @author Nicolae Turcan
 *
 */
public class Model {

	// String that is displayed in the input bar
	private String expression;

	/**
	 * Initializes the expression to the empty string.
	 */
	public Model() {
		expression = "";
	}

	/**
	 * Updates the expression.
	 * @param element string (the content of the pressed button) that is to be added to the expression
	 */
	public void updateExpression(String element){
		expression = expression + element;
		notifyListeners();
	}

	/**
	 * Clears the expression.
	 */
	public void clearExpression(){
		expression = "";
		notifyListeners();
	}

	/**
	 * Deletes the last token.
	 */
	public void deleteToken(){
		if (expression.length()>0){
			expression = expression.substring(0, expression.length()-1);
		}
		notifyListeners();
	}

	/**
	 * Evaluates the expression. The order of operation is respected by using a technique with involving four stacks.
	 */
	public void evaluateExpression(){
		// Initializes the stacks, two for operators and two for values
		Stack<Integer> operators = new Stack<Integer>();
		Stack<Integer> operatorsTemp = new Stack<Integer>();
		Stack<Float> values = new Stack<Float>();
		Stack<Float> valuesTemp = new Stack<Float>();
		String expr = expression;

		// Adds a 0 to the front if the first character is the minus sign
		if (expr.charAt(0) == '-'){
			expr = "0" + expr;
		}
		//Replaces the minus sign with the +- sign
		expr = expr.replaceAll("-", "+-");
		String tmp = "";
		// Pushes the operators and the values to the respective stacks.
		for (int i = 0; i < expr.length(); i++){
			char character = expr.charAt(i);
			if (character == '+' || character == 'x' || character == '÷' || character == '^'){
				values.push(Float.parseFloat(tmp));
				operators.push((int)character);
				tmp = "";
			}
			else if (character == '-'){
				tmp = "-" + tmp;
			}
			else {
				tmp = tmp + character;
			}
		}
		values.push(Float.parseFloat(tmp));
		// Sets up and populates an integer array to store all supported operation types
		int[] ops = new int[4];
		ops[0] = (int)'^';
		ops[1] = (int)'x';
		ops[2] = (int)'÷';
		ops[3] = (int)'+';

		// For each operation type
		for (int i = 0; i < ops.length; i++){
			// Enforces the order of operations
			while(!operators.isEmpty()){
				int operator = operators.pop();
				float firstValue = values.pop();
				float secondValue = values.pop();
				if(operator == ops[i]){
					// Performs the operations
					if (i==0){
						valuesTemp.push((float)Math.pow(secondValue, firstValue));
						i--;
						break;
					}
					else if (i==1){
						valuesTemp.push(secondValue * firstValue);
						i--;
						break;
					}
					else if(i==2){
						valuesTemp.push(secondValue / firstValue);
						i--;
						break;
					}
					else if(i==3){
						valuesTemp.push(secondValue + firstValue);
						i--;
						break;
					}
				}
				// If not an operation
				else {
					valuesTemp.push(firstValue);
					values.push(secondValue);
					operatorsTemp.push(operator);
				}
			}
			// Push the remaining values
			while(!valuesTemp.isEmpty()){
				values.push(valuesTemp.pop());
			}
			// Push the remaining operators
			while(!operatorsTemp.isEmpty()){
				operators.push(operatorsTemp.pop());
			}
		}
		// Gets the result
		float result = values.pop();
		// Removes the trailing zeroes if result is integer
		if (result - (int)result == 0){
			expression = (String.valueOf((int)result));
		}
		else{
			expression = (String.valueOf(result));
		}
		// Notifies the listener about the change
		notifyListeners();
	}
	/**
	 * Returns the expression.
	 * @return returns the expression
	 */
	public String getExpression(){
		return expression;
	}
	private List<Listener> listeners = new ArrayList<Listener>();

	/**
	 * Sets up a listener.
	 * @param listener listens for input
	 */
	public void addListener( final Listener listener )
	{
		listeners.add(listener);
	}

	/**
	 * Notifies the listener about an update.
	 */
	private void notifyListeners()
	{
		for( final Listener listener : listeners ) {
			listener.updated();
		}
	}
}
