import controller.Controller;
import model.Model;
import view.View;

/**
 * This class sets up the model, view, and controller according to the MVC pattern
 * and runs the calculator.
 * @author Nicolae Turcan
 *
 */
public class Driver {

	public static void main(String[] args) {
		Model model = new Model(); // Sets up the model
		Controller c = new Controller( model ); // Sets up the controller
		@SuppressWarnings("unused")
		View v = new View( model, c ); // Sets up the view
	}

}
