package com.hunternichols.message;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hunternichols.database.dataobjects.Update;
import com.hunternichols.database.framework.DatabaseController;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TheNukeWindow extends JFrame {

	private JPanel contentPane;
	public DatabaseController dbc = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheNukeWindow frame = new TheNukeWindow();
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
	public TheNukeWindow() {
		OptionsController oc = new OptionsController();
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			dbc = DatabaseController.getDBController();
			Update updater = dbc.getUpdate();
			updater.setUpdateMessages(0);
			dbc.updateUpdate(updater);
		} //nothing to do here, nuke window will not appear when offline
		
		setTitle("DO NOT CLOSE ME!");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        this.setBounds(width / 3, height / 3, 489, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrAshleeNicoleHill = new JTextArea();
		txtrAshleeNicoleHill.setText("Ashlee Nicole Hill, I love you so much that no matter what you could ever do to me I would never leave you. Its not that I would not want to leave you but I physically and emotionally could not. You make me feel happy. You make me feel something that nothing in this world has or will ever be able to. No matter how angry I am at you or at anything, all you have to do is smile at me with your cute face and my anger just melts away. I want to have babys with you, and I want to see those babys grow old with you, and when the babys are all gone I want to grow old with you.");
		txtrAshleeNicoleHill.setEditable(false);
		txtrAshleeNicoleHill.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 18));
		txtrAshleeNicoleHill.setWrapStyleWord(true);
		txtrAshleeNicoleHill.setLineWrap(true);
		txtrAshleeNicoleHill.setBounds(10, 55, 453, 191);
		contentPane.add(txtrAshleeNicoleHill);
		
		JButton btnNewButton = new JButton("Accept");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TheNukeWindow n1 = new TheNukeWindow();
				n1.setBounds(width / 3 + 200, height / 3 + 200, 489, 355);
				n1.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n2 = new TheNukeWindow();
				n2.setBounds(width / 3 + 200, height / 3 + 50, 489, 355);
				n2.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n3 = new TheNukeWindow();
				n3.setBounds(width / 3 + 400, height / 3 + 400, 489, 355);
				n3.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n4 = new TheNukeWindow();
				n4.setBounds(width / 3 + 600, height / 3 + 600, 489, 355);
				n4.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n5 = new TheNukeWindow();
				n5.setBounds(width / 3 + 400, height / 3 - 200, 489, 355);
				n5.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n6 = new TheNukeWindow();
				n6.setBounds(width / 3 - 200, height / 3 - 200, 489, 355);
				n6.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n7 = new TheNukeWindow();
				n7.setBounds(width / 3 - 400, height / 3 - 400, 489, 355);
				n7.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n8 = new TheNukeWindow();
				n8.setBounds(width / 3 - 600, height / 3 - 600, 489, 355);
				n8.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n9 = new TheNukeWindow();
				n9.setBounds(width / 3 - 200, height / 3 - 50, 489, 355);
				n9.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n10 = new TheNukeWindow();
				n10.setBounds(width / 3 - 400, height / 3 - 100, 489, 355);
				n10.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n11 = new TheNukeWindow();
				n11.setBounds(width / 3 - 469, height / 3 - 801, 489, 355);
				n11.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n12 = new TheNukeWindow();
				n12.setBounds(width / 3 + 600, height / 3 + 400, 489, 355);
				n12.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n13 = new TheNukeWindow();
				n13.setBounds(width / 3 - 647, height / 3 + 299, 489, 355);
				n13.setVisible(true);
				
				try {
					Thread.sleep((long) 500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				TheNukeWindow n14 = new TheNukeWindow();
				n14.setBounds(width / 3 + 74, height / 3 - 500, 489, 355);
				n14.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 15));
		btnNewButton.setBounds(66, 282, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDecline = new JButton("Decline");
		btnDecline.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 15));
		btnDecline.setBounds(291, 282, 89, 23);
		contentPane.add(btnDecline);
		
		JLabel lblNewLabel = new JLabel("Do you accept the terms of the Marriage License Agreement (MLA)?");
		lblNewLabel.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 473, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Will you accept the MLA and Marry Me?");
		lblNewLabel_1.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 241, 473, 30);
		contentPane.add(lblNewLabel_1);
	}
}
