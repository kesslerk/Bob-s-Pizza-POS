import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;


public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setTitle("Bob's Pizza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBobsPizza = new JLabel("Bob's Pizza");
		lblBobsPizza.setFont(new Font("Lucida Grande", Font.BOLD, 38));
		lblBobsPizza.setBounds(237, 6, 243, 53);
		contentPane.add(lblBobsPizza);
		
		JLabel logo = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/pizzaHeart.jpg")).getImage();
		logo.setIcon(new ImageIcon(img)); //Set's Login Screen Logo
		logo.setBounds(101, 58, 422, 352);
		contentPane.add(logo);
		
		JLabel lblEnterPin = new JLabel("Enter PIN");
		lblEnterPin.setBounds(279, 412, 61, 16);
		contentPane.add(lblEnterPin);
		
		textField = new JTextField();
		textField.setBounds(365, 412, 97, 16);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(302, 440, 117, 29);
		contentPane.add(btnLogin);
	}
}
