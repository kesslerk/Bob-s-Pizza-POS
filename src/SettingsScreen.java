import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;


public class SettingsScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingsScreen frame = new SettingsScreen();
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
	public SettingsScreen() {
		setTitle("Bob's Pizza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(6, 6, 117, 29);
		contentPane.add(btnSignOut);
		
		JButton btnOrderScreen = new JButton("Order Screen");
		btnOrderScreen.setBounds(577, 6, 117, 29);
		contentPane.add(btnOrderScreen);
		
		JButton btnChangePrices = new JButton("Change Prices");
		btnChangePrices.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnChangePrices.setBounds(255, 139, 167, 67);
		contentPane.add(btnChangePrices);
		
		JButton btnUserAccouts = new JButton("User Accouts");
		btnUserAccouts.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnUserAccouts.setBounds(255, 235, 167, 67);
		contentPane.add(btnUserAccouts);
	}

}
