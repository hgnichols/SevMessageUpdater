package com.hunternichols.message;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hunternichols.database.framework.DatabaseController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PopUpWindow extends JFrame {

	private JPanel contentPane;
	DatabaseController dbc = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpWindow frame = new PopUpWindow();
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
	public PopUpWindow() {
		OptionsController oc = new OptionsController();
		
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			dbc = DatabaseController.getDBController();
		} 
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Message From Your Favorite Person:");
		lblNewLabel.setFont(new Font("Microsoft Yi Baiti", Font.BOLD, 20));
		lblNewLabel.setBounds(70, 11, 304, 37);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel();
		label.setToolTipText("");
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			label.setText("<html><p><center>" + dbc.getSendMessage().getSentMessage() + "</p></center> </html>");
		} //remember do nothing here pop-ups wont work offline
		
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Microsoft Yi Baiti", Font.PLAIN, 20));
		label.setBounds(10, 44, 434, 116);
		contentPane.add(label);
	}
}
