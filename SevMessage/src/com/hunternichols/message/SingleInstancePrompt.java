package com.hunternichols.message;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SingleInstancePrompt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleInstancePrompt frame = new SingleInstancePrompt();
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
	public SingleInstancePrompt() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
		setBounds(width / 3 + 100, height / 3 - 100, 460, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Another Instance of SevMessage is running!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 22));
		lblNewLabel.setBounds(0, 11, 444, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Okay");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 19));
		btnNewButton_1.setBounds(177, 149, 84, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblYouCanClose = new JLabel("Please close the open one before starting a new one");
		lblYouCanClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouCanClose.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 19));
		lblYouCanClose.setBounds(0, 44, 444, 24);
		contentPane.add(lblYouCanClose);
		
		JLabel lblHaveYouClosed = new JLabel("Go to your processes and end the task");
		lblHaveYouClosed.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaveYouClosed.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 19));
		lblHaveYouClosed.setBounds(0, 98, 444, 24);
		contentPane.add(lblHaveYouClosed);
		
		JLabel lblOrClickyes = new JLabel("(If one is not open it may be running in the background");
		lblOrClickyes.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrClickyes.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 19));
		lblOrClickyes.setBounds(0, 79, 444, 24);
		contentPane.add(lblOrClickyes);
		
		JLabel lblJavatmPlatformSe = new JLabel("\"Java(TM) Platform SE binary)\"");
		lblJavatmPlatformSe.setHorizontalAlignment(SwingConstants.CENTER);
		lblJavatmPlatformSe.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 19));
		lblJavatmPlatformSe.setBounds(0, 114, 444, 24);
		contentPane.add(lblJavatmPlatformSe);
	}
}
