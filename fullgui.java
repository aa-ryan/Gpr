import java.awt.*;
import java.awt.event.*;

class Demo {
	private Frame mainframe;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public Demo() {
		makeGUI();
	}

	public static void main(String[] args) {
		Demo awtDemo = new Demo();
		awtDemo.showEventDemo();
	}

	/*
	 * setting up positions for all the elements
	 */

	private void makeGUI() {
		mainframe = new Frame("AWT Usage Example");
		mainframe.setSize(400, 400);
		mainframe.setLayout(new GridLayout(3, 1));
		mainframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350, 100);

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		mainframe.add(headerLabel);
		mainframe.add(controlPanel);
		mainframe.add(statusLabel);
		mainframe.setVisible(true);
	}

	/*
	 * Making Buttons and using "addActionListener" to get "setActionCommand" to "ButtonClickListener" class
	 */
	private void showEventDemo() {
		headerLabel.setText("Control in action: Button");
		Button okButton = new Button("ok");
		Button submitButton = new Button("Submit");
		Button cancelButton = new Button("Cancel");

		okButton.setActionCommand("OK");
		okButton.addActionListener(new ButtonClickListener());
		submitButton.setActionCommand("Submit");
		submitButton.addActionListener(new ButtonClickListener());
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(new ButtonClickListener());

		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);
		
		mainframe.setVisible(true);
	}

	/* 
	 * this class takes command from "setActionCommand"  using "ActionEvent.getActionCommand" 
	 */
	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("OK")) {
				statusLabel.setText("OK button clicked");
			} else if (command.equals("Submit")) {
				statusLabel.setText("Submit button clicked");
			} else {
				statusLabel.setText("Cancel by default");
			}
		}
	}
}
