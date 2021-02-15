package test.gui;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import management.Result;
import management.ValidateAndCorrect;

public class Widget  {
	
	private Shell shell;

	public Widget(final Display display) {

		shell = new Shell(display, SWT.CLOSE);

		shell.setText("South african number tester");

		GridLayout gl_shell = new GridLayout(2, false);
		shell.setLayout(gl_shell);

		Composite mainComp = new Composite(shell, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		mainComp.setLayout(gridLayout);
		
		Label tip = new Label(mainComp,  SWT.NONE);
		tip.setText("Insert the input number than press TEST to proceed");
		GridData gridDataTip = new GridData(SWT.FILL, SWT.NONE, true, false);
		gridDataTip.horizontalSpan = 2;
		tip.setLayoutData(gridDataTip);
		
		
		Composite dataComp = new Composite(mainComp, SWT.NONE);
		dataComp.setLayout(new GridLayout(2, false));
		
		Composite btnComp = new Composite(mainComp, SWT.NONE);
		btnComp.setLayout(new GridLayout(1, true));
		
		
		Label userInputLabel = new Label(dataComp, SWT.NONE);
		userInputLabel.setText("User input: ");
		Text input = new Text(dataComp, SWT.BORDER);
		GridData textboxGridData = new GridData(100, 15);
		input.setLayoutData(textboxGridData);
		Label resultNumber = new Label(dataComp,  SWT.NONE);
		resultNumber.setText("Result number: ");
		Text number = new Text(dataComp, SWT.BORDER);
		number.setLayoutData(textboxGridData);
		number.setEditable(false);
		Text reason = new Text(dataComp,SWT.BORDER | SWT.MULTI | SWT.WRAP);
		reason.setEditable(false);
		GridData gridData_1 = new GridData();
		gridData_1.verticalAlignment = SWT.CENTER;
		gridData_1.horizontalAlignment = SWT.RIGHT;
		gridData_1.widthHint = 300;
		gridData_1.heightHint = 50;
		gridData_1.horizontalSpan = 2;
		reason.setLayoutData(gridData_1);
		
		Button btnTest = new Button(btnComp, SWT.PUSH);
		btnTest.setText("  TEST  ");
		btnTest.addSelectionListener(testerSelection(input, number, reason));
		
		Button btnClose = new Button(btnComp, SWT.PUSH | SWT.BOTTOM);
		btnClose.addSelectionListener(shellClose());
		btnClose.setText("  CLOSE  ");

		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private SelectionListener shellClose() {
		return new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		};
	}

	private SelectionListener testerSelection(Text input, Text number, Text reason) {
		return new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String inputContent = input.getText().trim();
				if(inputContent== null || "".equals(inputContent)) {
					reason.setText("ERROR - Input number not inserted");
				}else{
					ValidateAndCorrect vc = new ValidateAndCorrect();
					Result result = vc.validatorDetailed(inputContent);
					if(result!=null) {
						number.setText(result.getNumber());
						reason.setText(result.getResult());
					}
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		};
	}

}
