package test;

import org.eclipse.swt.widgets.Display;

import test.gui.Widget;

public class Form {

	public static void main(String[] args) {
		Display display = new Display();
		new Widget(display);
	}
}
