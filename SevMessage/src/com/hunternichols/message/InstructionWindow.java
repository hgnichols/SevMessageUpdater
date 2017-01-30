package com.hunternichols.message;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;

@SuppressWarnings("serial")
public class InstructionWindow extends JFrame {

	private JPanel contentPane;
	public JTextArea txtrHelloTheLove;
	public JLabel lblNewLabel;

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
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
		setBounds(width / 3 + 100, height / 3 - 100, 461, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtrHelloTheLove = new JTextArea();
		txtrHelloTheLove.setWrapStyleWord(true);
		txtrHelloTheLove.setText("Hello the Love Of my Life! I have worked a very long time on this project for you, and here are some instructions to help you use this awesome application I have created for you.\r\n\r\nPLEASE READ EVERYTHING BEFORE USING THIS APPLICATION!\r\n1. This program will start on Computer start up unless changed in the settings\r\n2. It will refresh for updates every 1 minute unless changed (**updates are different then Messege frequency refreshes)\r\n3. The only thing refresh controlls is a pop-up message (which is done from the developer console part of the app I have on my computer)\r\n4. The app will also update the message and make the window re-appear after 30 minutes by default (**this is different than the refresh rate)\r\n5. You  may exit the program without incurring any refreshing or reloading of the app (located in the settings)\r\n6. Ignore the command line, is for developer use only\r\n7. If you are getting a window that says an instance already exists. Go to your task manager and end the \"Java(TM) Platform SE binary)\" proccess\r\n8. You may re-read this at anytime by clicking \"Help\" in the settings\r\n9. Please report any errors, bugs, or wierd things directly to me ASAP");
		txtrHelloTheLove.setEditable(false);
		txtrHelloTheLove.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 17));
		txtrHelloTheLove.setBackground(SystemColor.control);
		txtrHelloTheLove.setLineWrap(true);
		txtrHelloTheLove.setBounds(10, 48, 425, 479);
		contentPane.add(txtrHelloTheLove);
		
		lblNewLabel = new JLabel("Important! Must Read this before using this Application");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 19));
		lblNewLabel.setBounds(0, -2, 445, 45);
		contentPane.add(lblNewLabel);
	}
}
