package view;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import controller.Controller;
import model.Model;

/**
 * This class serves as a view in the MVC pattern. It displays the information
 * to the user using the Standard Widget Toolkit (SWT).
 * @author Nicolae Turcan
 *
 */
public class View{

	private final Model model;
	private final Display display;
	private final Shell shell;
	/**
	 * Triggers the creation of the UI connected to model and controller.
	 * @param model reference to the Model object
	 * @param controller reference to the Controller object
	 */
	public View( final Model model, final Controller controller )
	{
		this.model = model;
		display = Display.getDefault();
		shell = new Shell(display);
		shell.setLayout(new GridLayout(1, true));
		init( controller );
	}
	/**
	 * Initializes the UI.
	 * @param controller reference to the controller object
	 */
	private void init( final Controller controller )
	{
		// Creates the grid
		Composite inputRow = new Composite(shell, SWT.NONE);
		inputRow.setLayout(new GridLayout(1, true));

		inputRow.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the input bar
		InputOutputLabel expression = new InputOutputLabel(model, inputRow);
		expression.setOrientation(SWT.LEFT_TO_RIGHT);
		expression.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the fifth row of the grid
		Composite fifthRow = new Composite(shell, SWT.NONE);
		fifthRow.setLayout(new GridLayout(4, true));
		fifthRow.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the buttons
		Button squared = new Button(fifthRow, SWT.PUSH);
		squared.setText("X^2");
		squared.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button power = new Button(fifthRow, SWT.PUSH);
		power.setText("^");
		power.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button clear = new Button(fifthRow, SWT.PUSH);
		clear.setText("C");
		clear.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button delete = new Button(fifthRow, SWT.PUSH);
		delete.setText("<-");
		delete.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the first row of the grid
		Composite firstRow = new Composite(shell, SWT.NONE);
		firstRow.setLayout(new GridLayout(4, true));

		firstRow.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the button
		Button seven = new Button(firstRow, SWT.PUSH);
		seven.setText("7");
		seven.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button eight = new Button(firstRow, SWT.PUSH);
		eight.setText("8");
		eight.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button nine = new Button(firstRow, SWT.PUSH);
		nine.setText("9");
		nine.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button division = new Button(firstRow, SWT.PUSH);
		division.setText("÷");
		division.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the second row
		Composite secondRow = new Composite(shell, SWT.NONE);
		secondRow.setLayout(new GridLayout(4, true));

		secondRow.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the buttons
		Button four = new Button(secondRow, SWT.PUSH);
		four.setText("4");
		four.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button five = new Button(secondRow, SWT.PUSH);
		five.setText("5");
		five.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button six = new Button(secondRow, SWT.PUSH);
		six.setText("6");
		six.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button multiplication = new Button(secondRow, SWT.PUSH);
		multiplication.setText("x");
		multiplication.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the third row
		Composite thirdRow = new Composite(shell, SWT.NONE);
		thirdRow.setLayout(new GridLayout(4, true));
		thirdRow.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the buttons
		Button one = new Button(thirdRow, SWT.PUSH);
		one.setText("1");
		one.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button two = new Button(thirdRow, SWT.PUSH);
		two.setText("2");
		two.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button three = new Button(thirdRow, SWT.PUSH);
		three.setText("3");
		three.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button minus = new Button(thirdRow, SWT.PUSH);
		minus.setText("-");
		minus.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the fourth row
		Composite fourthRow = new Composite(shell, SWT.NONE);
		fourthRow.setLayout(new GridLayout(4, true));
		fourthRow.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Sets the buttons
		Button zero = new Button(fourthRow, SWT.PUSH);
		zero.setText("0");
		zero.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button point = new Button(fourthRow, SWT.PUSH);
		point.setText(".");
		point.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button plus = new Button(fourthRow, SWT.PUSH);
		plus.setText("+");
		plus.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Button equals = new Button(fourthRow, SWT.PUSH);
		equals.setText("=");
		equals.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Connects the view with the listener via controller
		squared.addListener(SWT.Selection, controller);
		power.addListener(SWT.Selection, controller);
		clear.addListener(SWT.Selection, controller);
		delete.addListener(SWT.Selection, controller);
		zero.addListener(SWT.Selection, controller);
		one.addListener(SWT.Selection, controller);
		two.addListener(SWT.Selection, controller);
		three.addListener(SWT.Selection, controller);
		four.addListener(SWT.Selection, controller);
		five.addListener(SWT.Selection, controller);
		six.addListener(SWT.Selection, controller);
		seven.addListener(SWT.Selection, controller);
		eight.addListener(SWT.Selection, controller);
		nine.addListener(SWT.Selection, controller);
		plus.addListener(SWT.Selection, controller);
		minus.addListener(SWT.Selection, controller);
		multiplication.addListener(SWT.Selection, controller);
		division.addListener(SWT.Selection, controller);
		point.addListener(SWT.Selection, controller);
		equals.addListener(SWT.Selection, controller);

		// Packs all the elements from above.
		shell.pack();
		shell.setText("Calculator");
		shell.setSize(400, 400);
		// Displays the view.
		shell.open();

		// Keeps the shell open
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
