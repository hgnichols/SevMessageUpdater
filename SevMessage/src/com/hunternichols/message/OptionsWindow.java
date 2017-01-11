package com.hunternichols.message;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class OptionsWindow {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionsWindow window = new OptionsWindow();
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
	public OptionsWindow() {
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
		frame.setBounds(width / 3, height / 3, 461, 321);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				textField.setText("");
				if(text.trim().equalsIgnoreCase("devwindow")) {
					
					DevWindow window = new DevWindow();
					window.frame.setVisible(true);
				}
			}
		});
		textField.setBounds(10, 240, 430, 31);
		frame.getContentPane().add(textField);
		
		JLabel label = new JLabel();
		label.setText("Command Line (Dev Use Only)");
		label.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 17));
		label.setBounds(10, 220, 204, 17);
		frame.getContentPane().add(label);
		
		OptionsController oc = new OptionsController();
		
		JSlider slider = new JSlider();
		slider.setBounds(10, 113, 430, 31);
		slider.setPaintTicks(true);
		slider.setMaximum(600);
		slider.setMinimum(1);
		slider.setValue(Integer.parseInt(oc.getProp().getProperty("refreshRate")));
		frame.getContentPane().add(slider);
		
		JLabel lblBackgroundRefreshRate = new JLabel();
		lblBackgroundRefreshRate.setText("Background Refresh Rate");
		lblBackgroundRefreshRate.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 17));
		lblBackgroundRefreshRate.setBounds(10, 91, 158, 17);
		frame.getContentPane().add(lblBackgroundRefreshRate);
		
		JSlider slider_1 = new JSlider();
		slider_1.setToolTipText("");	
		slider_1.setBounds(10, 30, 430, 33);
		slider_1.setMaximum(300);
		slider_1.setMinimum(1);
		slider_1.setValue(Integer.parseInt(oc.getProp().getProperty("messageFrequency")));
		frame.getContentPane().add(slider_1);	
		
		JLabel label_2 = new JLabel();
		label_2.setText("New Message Frequency");
		label_2.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 17));
		label_2.setBounds(10, 11, 158, 17);
		frame.getContentPane().add(label_2);
		
		JLabel lblNewLabel = new JLabel("New label");	
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 17));
		lblNewLabel.setBounds(317, 54, 123, 25);
		lblNewLabel.setText(oc.getProp().getProperty("messageFrequency") + "   minute(s)");
		
		lblNewLabel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				oc.getProp().setProperty("messageFrequency", lblNewLabel.getText().substring(0, 3).trim());
				oc.saveProperties();
			}
		});
		
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_3 = new JLabel("115  second(s) or 1.92 minute(s)");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 17));
		label_3.setBounds(291, 155, 149, 25);
		frame.getContentPane().add(label_3);
		
		JLabel label_1 = new JLabel(oc.getProp().getProperty("refreshRate"));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		label_1.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 17));
		label_1.setBounds(291, 135, 149, 25);
		DecimalFormat df = new DecimalFormat("#.##");
		label_1.setText(oc.getProp().getProperty("refreshRate") + "   second(s)");
		label_3.setText(df.format(Long.parseLong(oc.getProp().getProperty("refreshRate").trim()) / 60.0) + "   minute(s)");
		
		label_1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				oc.getProp().setProperty("refreshRate", label_1.getText().substring(0, 4).trim());
				oc.saveProperties();
			}
		});
		
		frame.getContentPane().add(label_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Start On Start Up");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean selected = chckbxNewCheckBox.isSelected();
				
				oc.getProp().setProperty("startOnStartUp", Boolean.toString(selected));
				oc.saveProperties();
				
				if(selected) {
					
					if(!StartUp.exists()) {
						
						StartUp.create();
					}
				} else {
					
					StartUp.delete();
				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(317, 186, 123, 23);
		chckbxNewCheckBox.setSelected(Boolean.valueOf(oc.getProp().getProperty("startOnStartUp")));
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Exit Without Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 186, 143, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InstructionWindow iWindow = new InstructionWindow();
				iWindow.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(201, 186, 65, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				lblNewLabel.setText(Integer.toString(slider_1.getValue())  + "   minute(s)");
			}
		});
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				DecimalFormat df = new DecimalFormat("#.##");
				label_1.setText(Integer.toString(slider.getValue())  + "   second(s)");
				label_3.setText(df.format(Long.parseLong(oc.getProp().getProperty("refreshRate").trim()) / 60.0) + "   minute(s)");
			}
		});
	}
}
