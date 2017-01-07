package com.hunternichols.message;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class InstructionWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructionWindow frame = new InstructionWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InstructionWindow() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 461, 293);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
		setBounds(width / 3 + 100, height / 3 - 100, 461, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrHelloTheLove = new JTextArea();
		txtrHelloTheLove.setWrapStyleWord(true);
		txtrHelloTheLove.setText("Hello the Love Of my Life! I have worked a very long time on this project for you, and here are some instructions to help you use this awesome application I have created for you.\r\n\r\nPLEASE READ EVERYTHING BEFORE USING THIS APPLICATION!\r\n1. This program will start on Computer start up unless changed in the settings\r\n2. It will refresh for updates every 30 minutes unless changed (**updates are different then Messege requency refreshes)\r\n3. Updates include: Me sending you a direct pop-up message, a change in the heading, if I want to force update the message, or if I want to update where in my database messages can come from (all of which is done from the developer console part of the app I have on my computer)\r\n4. The app will also update the message and make the window re-appear after 30 minutes by default (**this is different than the refresh rate)\r\n5. You  may exit the program without incurring any refreshing or reloading of the app (located in the settings)\r\n6. Ignore the command line, is for developer use only\r\n7. You may re-read this at anytime by clicking \"Help\" in the settings\r\n8. Please report any errors, bugs, or wierd things directly to me ASAP");
		txtrHelloTheLove.setEditable(false);
		txtrHelloTheLove.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 17));
		txtrHelloTheLove.setBackground(SystemColor.control);
		txtrHelloTheLove.setLineWrap(true);
		txtrHelloTheLove.setBounds(10, 48, 425, 467);
		contentPane.add(txtrHelloTheLove);
		
		JLabel lblNewLabel = new JLabel("Important! Must Read this before using this Application");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 19));
		lblNewLabel.setBounds(0, -2, 445, 45);
		contentPane.add(lblNewLabel);
	}
}
