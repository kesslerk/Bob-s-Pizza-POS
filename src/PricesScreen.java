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
	private JTextField pizzaSmall;
	private JTextField pizzaMedium;
	private JTextField pizzaLarge;
	private JTextField toppingSmall;
	private JTextField toppingMedium;
	private JTextField toppingLarge;
	private JTextField sodaPrice;
	private JTextField tax;

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
		
		JLabel lblPizzaPrice = new JLabel("Pizza Price");
		lblPizzaPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPizzaPrice.setBounds(6, 65, 97, 16);
		contentPane.add(lblPizzaPrice);
		
		JLabel lblpizzaSmall = new JLabel("Small");
		lblpizzaSmall.setBounds(16, 93, 61, 16);
		contentPane.add(lblpizzaSmall);
		
		pizzaSmall = new JTextField();
		lblpizzaSmall.setLabelFor(pizzaSmall);
		pizzaSmall.setBounds(89, 93, 61, 16);
		contentPane.add(pizzaSmall);
		pizzaSmall.setColumns(10);
		
		JLabel lblpizzaMedium = new JLabel("Medium");
		lblpizzaMedium.setBounds(201, 93, 61, 16);
		contentPane.add(lblpizzaMedium);
		
		pizzaMedium = new JTextField();
		lblpizzaMedium.setLabelFor(pizzaMedium);
		pizzaMedium.setColumns(10);
		pizzaMedium.setBounds(274, 93, 61, 16);
		contentPane.add(pizzaMedium);
		
		JLabel lblpizzaLarge = new JLabel("Large");
		lblpizzaLarge.setBounds(416, 93, 61, 16);
		contentPane.add(lblpizzaLarge);
		
		pizzaLarge = new JTextField();
		lblpizzaLarge.setLabelFor(pizzaLarge);
		pizzaLarge.setColumns(10);
		pizzaLarge.setBounds(478, 93, 61, 16);
		contentPane.add(pizzaLarge);
		
		JLabel lblToppingPrice = new JLabel("Topping Price");
		lblToppingPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblToppingPrice.setBounds(6, 168, 117, 19);
		contentPane.add(lblToppingPrice);
		
		JLabel lbltoppingSmall = new JLabel("Small");
		lbltoppingSmall.setBounds(16, 199, 61, 16);
		contentPane.add(lbltoppingSmall);
		
		toppingSmall = new JTextField();
		lbltoppingSmall.setLabelFor(toppingSmall);
		toppingSmall.setColumns(10);
		toppingSmall.setBounds(89, 199, 61, 16);
		contentPane.add(toppingSmall);
		
		JLabel lbltoppingMedium = new JLabel("Medium");
		lbltoppingMedium.setBounds(201, 199, 61, 16);
		contentPane.add(lbltoppingMedium);
		
		toppingMedium = new JTextField();
		lbltoppingMedium.setLabelFor(toppingMedium);
		toppingMedium.setColumns(10);
		toppingMedium.setBounds(274, 199, 61, 16);
		contentPane.add(toppingMedium);
		
		JLabel lbltoppingLarge = new JLabel("Large");
		lbltoppingLarge.setBounds(416, 199, 61, 16);
		contentPane.add(lbltoppingLarge);
		
		toppingLarge = new JTextField();
		lbltoppingLarge.setLabelFor(toppingLarge);
		toppingLarge.setColumns(10);
		toppingLarge.setBounds(478, 199, 61, 16);
		contentPane.add(toppingLarge);
		
		JLabel lblSodaPrice = new JLabel("Soda Price");
		lblSodaPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblSodaPrice.setBounds(6, 273, 97, 16);
		contentPane.add(lblSodaPrice);
		
		sodaPrice = new JTextField();
		sodaPrice.setColumns(10);
		sodaPrice.setBounds(16, 301, 61, 16);
		contentPane.add(sodaPrice);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTax.setBounds(6, 367, 61, 16);
		contentPane.add(lblTax);
		
		tax = new JTextField();
		tax.setColumns(10);
		tax.setBounds(16, 395, 61, 16);
		contentPane.add(tax);
		
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
