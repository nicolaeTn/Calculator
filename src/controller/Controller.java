package controller;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import model.Model;
/**
 * This class serves as a controller in the MVC pattern. It updates the model when changes occur.
 * @author Nicolae Turcan
 *
 */
public class Controller
implements Listener
{
	private final Model model;	// local reference to the model
	/**
	 * Sets up a local reference to the model for the controller.
	 * @param model model of the program
	 */
	public Controller( final Model model )
	{
		this.model = model;
	}

	/**
	 * Updates the model when changes occur due to user input (buttons pressed).
	 */
	@Override
	public void handleEvent(Event event) {
		//Gets the button that was pressed by the user
		Button button = (Button) event.widget;

		// Updates the model based on the button that was pressed
		if (button.getText() != "=" && button.getText() != "X^2" && button.getText() != "^" && button.getText() != "C" && button.getText() != "<-") {
			model.updateExpression(button.getText());
		}
		else if (button.getText() == "X^2"){
			model.updateExpression("^2");
		}
		else if (button.getText() == "^"){
			model.updateExpression("^");
		}
		else if (button.getText() == "C"){
			model.clearExpression();
		}
		else if (button.getText() == "<-"){
			model.deleteToken();
		}
		else if (button.getText() == "="){
			model.evaluateExpression();
		}
	}
}
