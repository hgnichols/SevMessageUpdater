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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.UIManager;

import com.hunternichols.database.dataobjects.Message;
import com.hunternichols.database.framework.DatabaseController;

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
		OptionsController oc = new OptionsController();
		frame = new JFrame();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
		frame.setBounds((width / 3) - 200, (height / 3) - 200, 889, 397);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
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
		JTextArea textArea = new JTextArea();
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseController dbc = DatabaseController.getDBController();
				String messageText = textArea.getText().trim();
				if(messageText.length() > 200) {
					
					textArea.setText("ERROR! TOO MANY CHARACTERS: " + messageText);
				} else {
					
					Message message = new Message(dbc.getNumberOfMessages().getNumber() + 1, messageText);
					textArea.setText("CHANGED TOO: " + messageText);
					dbc.addMessage(message);
				}
			}
		});
		
		button_1.setText("Add Message");
		button_1.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		button_1.setBounds(166, 174, 112, 25);
		frame.getContentPane().add(button_1);
		
		textArea.setWrapStyleWord(true);
		textArea.setText("");
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
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setText("Scarcely on striking packages by so property in delicate. Up or well must less rent read walk so be. Easy sold at do hour sing spot. Any meant has cease too the decay. Since party burst am it match. Y");
		textArea_1.setRows(5);
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 14));
		textArea_1.setColumns(20);
		textArea_1.setBounds(484, 77, 333, 84);
		frame.getContentPane().add(textArea_1);
		
		JButton btnSendMessage = new JButton();
		btnSendMessage.setText("Send Message");
		btnSendMessage.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		btnSendMessage.setBounds(598, 174, 123, 25);
		frame.getContentPane().add(btnSendMessage);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("DevMode");
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean selected = chckbxNewCheckBox.isSelected();
				if(selected) {
					
					oc.getProp().setProperty("devMode", "true");
					oc.saveProperties();
					System.exit(0);
				} else {
					
					oc.getProp().setProperty("devMode", "false");
					oc.saveProperties();
					System.exit(0);
				}
				
			}
		});
		
		chckbxNewCheckBox.setBackground(UIManager.getColor("Button.background"));
		chckbxNewCheckBox.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 18));
		chckbxNewCheckBox.setBounds(786, 328, 81, 23);
		chckbxNewCheckBox.setSelected(Boolean.valueOf(oc.getProp().getProperty("devMode")));
		frame.getContentPane().add(chckbxNewCheckBox);
	}
}
