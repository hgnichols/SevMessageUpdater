package com.hunternichols.message;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DevWindow {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DevWindow window = new DevWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DevWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
		frame.setBounds((width / 3) - 200, (height / 3) - 200, 889, 397);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton();
		button.setText("Update Heading");
		button.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		button.setBounds(155, 248, 123, 25);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setText("Saw yet kindness too replying whatever marianne. O");
		textField.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(82, 210, 276, 30);
		frame.getContentPane().add(textField);
		
		JButton button_1 = new JButton();
		button_1.setText("Add Message");
		button_1.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		button_1.setBounds(166, 174, 103, 25);
		frame.getContentPane().add(button_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setText("Scarcely on striking packages by so property in delicate. Up or well must less rent read walk so be. Easy sold at do hour sing spot. Any meant has cease too the decay. Since party burst am it match. Y");
		textArea.setRows(5);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 14));
		textArea.setColumns(20);
		textArea.setBounds(62, 78, 333, 84);
		frame.getContentPane().add(textArea);
		
		JLabel label = new JLabel();
		label.setText("Ashlee if you somehow find yourself here, just exit out or you Could Fuck Everything Up!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 21));
		label.setBounds(10, 11, 857, 25);
		frame.getContentPane().add(label);
	}

}
