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
import java.util.Arrays;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

import com.hunternichols.database.dataobjects.Heading;
import com.hunternichols.database.dataobjects.MessPoolSeed;
import com.hunternichols.database.dataobjects.Message;
import com.hunternichols.database.dataobjects.SendMessage;
import com.hunternichols.database.dataobjects.Update;
import com.hunternichols.database.framework.DatabaseController;
import java.util.List;
import java.awt.Color;

public class DevWindow {

	JFrame frame;
	private JTextField textField;
	private JTextField txtend;
	public DatabaseController dbc = null;

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
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			dbc = DatabaseController.getDBController();
		}

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

				String heading = textField.getText().trim();

				if (heading.length() > 50) {

					textField.setText("ERROR TOO MANY CHARACTERS! " + heading);
				} else {

					textField.setText("CHANGED TOO: " + heading);
					if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

						dbc.updateHeading(new Heading(heading));
					} else {

						textField.setText("ERROR! You are offline check server status!");
					}

				}
			}
		});

		button.setText("Update Heading");
		button.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		button.setBounds(166, 269, 123, 25);
		frame.getContentPane().add(button);

		textField = new JTextField();
		textField.setText("");
		textField.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(22, 228, 411, 30);
		frame.getContentPane().add(textField);

		JButton button_1 = new JButton();
		JTextArea textArea = new JTextArea();

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

					dbc = DatabaseController.getDBController();
				}

				String messageText = textArea.getText().trim();
				if (messageText.length() > 200) {

					textArea.setText("ERROR! TOO MANY CHARACTERS: " + messageText);
				} else {

					if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

						Message message = new Message(dbc.getNumberOfMessages().getNumber() + 1, messageText);
						textArea.setText("ADDED TO MESSAGE BANK: " + messageText);
						dbc.addMessage(message);
					} else {

						textArea.setText("ERROR! You are offline check server status!");
					}

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
		textArea_1.setText("");
		textArea_1.setRows(5);
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 14));
		textArea_1.setColumns(20);
		textArea_1.setBounds(484, 77, 333, 84);
		frame.getContentPane().add(textArea_1);

		JButton btnSendMessage = new JButton();

		btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {
					String sentMessage = textArea_1.getText().trim();

					if (sentMessage.length() > 200) {

						textArea_1.setText("ERROR TOO MANY CHARACTERS! " + sentMessage);
					} else {

						textArea_1.setText("SENT SUCESSFULLY! " + sentMessage);
						dbc.updateSendMessage(new SendMessage(sentMessage));
						Update update = dbc.getUpdate();
						dbc.updateUpdate(new Update(1, update.getUpdateMessages(), update.getHeadingUpdate()));

					}

				} else {

					textArea_1.setText("ERROR! You are offline check server status!");
				}

			}
		});

		btnSendMessage.setText("Send Message");
		btnSendMessage.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		btnSendMessage.setBounds(598, 174, 123, 25);
		frame.getContentPane().add(btnSendMessage);

		JCheckBox chckbxNewCheckBox = new JCheckBox("DevMode");

		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean selected = chckbxNewCheckBox.isSelected();
				if (selected) {

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

		txtend = new JTextField();
		txtend.setText("");
		txtend.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		txtend.setBounds(482, 228, 151, 30);
		frame.getContentPane().add(txtend);
		txtend.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		JButton btnNewButton_1 = new JButton("Update Message Pool");

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

					String seed = txtend.getText().trim();
					List<String> list = Arrays.asList(seed.split(","));
					String start = "broken";
					String ending = "broken";
					if(list.size() > 1) {
						
						start = list.get(0).trim();
						ending = list.get(1).trim();
					}
					boolean isTooBig = false;
					
					try {
						
						int localEnding = Integer.parseInt(ending);
						int bankSize = dbc.getNumberOfMessages().getNumber();
						if(localEnding > bankSize) {
							
							isTooBig = true;
						}
					} catch(NumberFormatException ex) {
						try {
							
							int localStart = Integer.parseInt(start);
							int bankSize = dbc.getNumberOfMessages().getNumber();
							if(localStart > bankSize) {
								
								isTooBig = true;
							}
						} catch(NumberFormatException ex2) {
							
							
						}
					}
					
					if (((Pattern.matches("[0-9]+", start)) && (Pattern.matches("[0-9]+", ending) || ending.equals("end"))) && Integer.parseInt(start) > 0 && !isTooBig) {

							txtend.setText(seed + " Success!");
							dbc.updateMessPoolSeed(new MessPoolSeed(Integer.parseInt(start), ending));
							lblNewLabel_1.setText("Current MessPoolSeed: " + dbc.getMessPoolSeed().getStart() + "," + dbc.getMessPoolSeed().getEnding());

					} else {

						txtend.setText(seed + " BAD FORMAT!");
					}
				} else {

					txtend.setText("ERROR! OFFLINE!");
				}

			}
		});

		btnNewButton_1.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		btnNewButton_1.setBounds(484, 270, 149, 23);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("(\"end\" for last message, ex. 1,end)");
		lblNewLabel.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		lblNewLabel.setBounds(633, 234, 205, 17);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("Drop Nukes");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

					Update updater = dbc.getUpdate();
					updater.setUpdateMessages(1);
					dbc.updateUpdate(updater);

					textArea.setText("NUKES HAS BEEN DROPPED! ENGAGE PLAN OF ACTION!");
					textArea_1.setText("NUKES HAS BEEN DROPPED! ENGAGE PLAN OF ACTION!");
					textField.setText("NUKES HAS BEEN DROPPED! ENGAGE PLAN OF ACTION!");
					txtend.setText("NUKES HAS BEEN DROPPED! ENGAGE PLAN OF ACTION!");
				} else {

					textArea.setText("ERROR! You are offline check server status!");
					textArea_1.setText("ERROR! You are offline check server status!");
					textField.setText("ERROR! You are offline check server status!");
					txtend.setText("ERROR! You are offline check server status!");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBounds(677, 329, 103, 23);
		frame.getContentPane().add(btnNewButton_2);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("initBoot");
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean selected = chckbxNewCheckBox_1.isSelected();
				if (selected) {

					oc.getProp().setProperty("initBoot", "true");
					oc.saveProperties();
				} else {

					oc.getProp().setProperty("initBoot", "false");
					oc.saveProperties();
				}
			}
		});
		chckbxNewCheckBox_1.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		chckbxNewCheckBox_1.setBounds(10, 328, 75, 23);
		chckbxNewCheckBox_1.setSelected(Boolean.valueOf(oc.getProp().getProperty("initBoot")));
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		lblNewLabel_1.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {
			
			lblNewLabel_1.setText("Current MessPoolSeed: " + dbc.getMessPoolSeed().getStart() + "," + dbc.getMessPoolSeed().getEnding());
		} else {
			
			lblNewLabel_1.setText("OFFLINE! N/A" );
		}
		
		lblNewLabel_1.setBounds(484, 297, 383, 21);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
