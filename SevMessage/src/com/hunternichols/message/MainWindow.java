/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hunternichols.message;

import java.awt.event.ActionListener;

import com.hunternichols.database.dataobjects.Message;
import com.hunternichols.database.framework.DatabaseController;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Hunter
 */
@SuppressWarnings("serial")
public class MainWindow extends javax.swing.JFrame {

	public MainWindow window;

	/**
	 * Creates new form MainWindow
	 */
	public MainWindow() {

		initComponents();
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				OptionsController oc = new OptionsController();

				dispose();
				try {
					Thread.sleep(Long.parseLong(oc.getProp().getProperty("messageFrequency").trim()) * 60000);
				} catch (NumberFormatException | InterruptedException e) {
					e.printStackTrace();
				}

				// start new window here
				initWindow();
			}
		});

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	public MainWindow initWindow() {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				window = new MainWindow();
				window.setVisible(true);
			}
		});

		return window;
	}

	public void initComponents() {

		Message messageObj = new Message();
		String message = messageObj.getRandomMessage();
		OptionsController  oc = new OptionsController();
		DatabaseController dbc = null;
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			dbc = DatabaseController.getDBController();
		} else {

		}

		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptionsWindow window = new OptionsWindow();
				window.frame.setVisible(true);

			}
		});
		jButton2 = new javax.swing.JButton();
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String messageUpdate = null;
				if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

					Message messageObjUpdate = new Message();
					messageUpdate = messageObjUpdate.getRandomMessage();
				} else {
					

				}

				jLabel1.setText("<html><p><center>" + messageUpdate + "</p></center> </html>");
			}
		});

		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setTitle("I just plain out love you");
		setBackground(new java.awt.Color(0, 0, 0));
		setLocationByPlatform(true);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		this.setBounds(width / 3, height / 3, 722, 344);

		jLabel1.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 20)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("<html><p><center>" + message + "</p></center> </html>");
		jLabel1.setToolTipText("");
		jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		jButton1.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 15)); // NOI18N
		jButton1.setText("Options");

		jButton2.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 16)); // NOI18N
		jButton2.setText("New Message");

		jLabel2.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		if (!Boolean.parseBoolean(oc.getProp().getProperty("offlineMode"))) {

			jLabel2.setText(dbc.getHeading().getHeading());
		} else {

		}

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jButton1))
								.addGroup(layout.createSequentialGroup().addGap(295).addComponent(jButton2)))
						.addContainerGap(140, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addGap(0, 89, Short.MAX_VALUE)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE).addGap(85))
				.addGroup(Alignment.LEADING,
						layout.createSequentialGroup().addGap(137)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(140, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jButton1).addGap(14)
						.addComponent(jLabel2).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(jButton2).addContainerGap(38, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting
		// code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.
		 * html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainWindow().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	// End of variables declaration//GEN-END:variables
}
