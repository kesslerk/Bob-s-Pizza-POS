import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


public class PricesScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PricesScreen frame = new PricesScreen();
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
	public PricesScreen() {
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
		
		JLabel lblPizza = new JLabel("Pizza Price");
		lblPizza.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPizza.setBounds(6, 65, 97, 16);
		contentPane.add(lblPizza);
		
		JLabel lblSmall = new JLabel("Small");
		lblSmall.setBounds(16, 93, 61, 16);
		contentPane.add(lblSmall);
		
		textField = new JTextField();
		textField.setBounds(89, 93, 61, 16);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblMedium = new JLabel("Medium");
		lblMedium.setBounds(201, 93, 61, 16);
		contentPane.add(lblMedium);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(274, 93, 61, 16);
		contentPane.add(textField_1);
		
		JLabel lblLarge = new JLabel("Large");
		lblLarge.setBounds(416, 93, 61, 16);
		contentPane.add(lblLarge);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(478, 93, 61, 16);
		contentPane.add(textField_2);
		
		JLabel lblToppingPrice = new JLabel("Topping Price");
		lblToppingPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblToppingPrice.setBounds(6, 168, 117, 19);
		contentPane.add(lblToppingPrice);
		
		JLabel label = new JLabel("Small");
		label.setBounds(16, 199, 61, 16);
		contentPane.add(label);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(89, 199, 61, 16);
		contentPane.add(textField_3);
		
		JLabel label_1 = new JLabel("Medium");
		label_1.setBounds(201, 199, 61, 16);
		contentPane.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(274, 199, 61, 16);
		contentPane.add(textField_4);
		
		JLabel label_2 = new JLabel("Large");
		label_2.setBounds(416, 199, 61, 16);
		contentPane.add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(478, 199, 61, 16);
		contentPane.add(textField_5);
		
		JLabel lblSodaPrice = new JLabel("Soda Price");
		lblSodaPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSodaPrice.setBounds(6, 273, 97, 16);
		contentPane.add(lblSodaPrice);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(16, 301, 61, 16);
		contentPane.add(textField_6);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTax.setBounds(6, 367, 61, 16);
		contentPane.add(lblTax);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(16, 395, 61, 16);
		contentPane.add(textField_7);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnClear.setBounds(145, 425, 117, 29);
		contentPane.add(btnClear);
		
		JButton btnApplyChanges = new JButton("Apply Changes");
		btnApplyChanges.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnApplyChanges.setBounds(328, 426, 168, 29);
		contentPane.add(btnApplyChanges);
	}
}
