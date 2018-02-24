package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import model.Listener;
import model.Model;

public class InputOutputLabel extends Text
implements Listener
{
	
private final Model model;
	
	public InputOutputLabel( final Model model, Composite inputRow ) {
		super(inputRow, SWT.FILL);
		this.model = model;
		
		model.addListener( this );
	}
	@Override
	public void updated() {
		setText(model.getExpression());
	}
	
	@Override
	protected void checkSubclass() {
	    // Disable the check that prevents subclassing of SWT components
	}

}
