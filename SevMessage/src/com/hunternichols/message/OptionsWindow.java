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
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;

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
		frame.setBounds(width / 3, height / 3, 461, 248);
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
		textField.setBounds(10, 167, 430, 31);
		frame.getContentPane().add(textField);
		
		JLabel label = new JLabel();
		label.setText("Command Line (Dev Use Only)");
		label.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 17));
		label.setBounds(10, 145, 204, 17);
		frame.getContentPane().add(label);
		
		OptionsController oc = new OptionsController();
		
		JSlider slider = new JSlider();
		slider.setBounds(10, 101, 430, 33);
		slider.setPaintTicks(true);
		slider.setMaximum(300);
		slider.setMinimum(1);
		slider.setValue(Integer.parseInt(oc.getProp().getProperty("refreshRate")));
		frame.getContentPane().add(slider);
		
		JLabel lblBackgroundRefreshRate = new JLabel();
		lblBackgroundRefreshRate.setText("Background Refresh Rate");
		lblBackgroundRefreshRate.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 17));
		lblBackgroundRefreshRate.setBounds(10, 73, 158, 17);
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
		lblNewLabel.setBounds(337, 54, 98, 25);
		lblNewLabel.setText(oc.getProp().getProperty("messageFrequency") + " minute(s)");
		
		lblNewLabel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				oc.getProp().setProperty("messageFrequency", lblNewLabel.getText().substring(0, 3).trim());
				oc.saveProperties();
			}
		});
		
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel(oc.getProp().getProperty("refreshRate"));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		label_1.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 17));
		label_1.setBounds(337, 125, 98, 25);
		label_1.setText(oc.getProp().getProperty("refreshRate") + " minute(s)");
		
		label_1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				oc.getProp().setProperty("refreshRate", label_1.getText().substring(0, 3).trim());
				oc.saveProperties();
			}
		});
		
		frame.getContentPane().add(label_1);
		
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				lblNewLabel.setText(Integer.toString(slider_1.getValue())  + " minute(s)");
			}
		});
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				label_1.setText(Integer.toString(slider.getValue())  + " minute(s)");
			}
		});
	}
}
