import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class PricesScreen extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField pizzaSmall;
	private JTextField pizzaMedium;
	private JTextField pizzaLarge;
	private JTextField toppingSmall;
	private JTextField toppingMedium;
	private JTextField toppingLarge;
	private JTextField sodaPrice;
	private JTextField tax;
	private float pizzaSmallPrice;
	private float pizzaMediumPrice;
	private float pizzaLargePrice;
	private float toppingSmallPrice;
	private float toppingMediumPrice;
	private float toppingLargePrice;
	private float genericSodaPrice;
	private float allTax;

	// Getters and Setters

	public float getPizzaSmallPrice() {
		return pizzaSmallPrice;
	}

	public void setPizzaSmallPrice(float pizzaSmallPrice) {
		this.pizzaSmallPrice = pizzaSmallPrice;
	}

	public float getPizzaMediumPrice() {
		return pizzaMediumPrice;
	}

	public void setPizzaMediumPrice(float pizzaMediumPrice) {
		this.pizzaMediumPrice = pizzaMediumPrice;
	}

	public float getPizzaLargePrice() {
		return pizzaLargePrice;
	}

	public void setPizzaLargePrice(float pizzaLargePrice) {
		this.pizzaLargePrice = pizzaLargePrice;
	}

	public float getToppingSmallPrice() {
		return toppingSmallPrice;
	}

	public void setToppingSmallPrice(float toppingSmallPrice) {
		this.toppingSmallPrice = toppingSmallPrice;
	}

	public float getToppingMediumPrice() {
		return toppingMediumPrice;
	}

	public void setToppingMediumPrice(float toppingMediumPrice) {
		this.toppingMediumPrice = toppingMediumPrice;
	}

	public float getToppingLargePrice() {
		return toppingLargePrice;
	}

	public void setToppingLargePrice(float toppingLargePrice) {
		this.toppingLargePrice = toppingLargePrice;
	}

	public float getGenericSodaPrice() {
		return genericSodaPrice;
	}

	public void setGenericSodaPrice(float genericSodaPrice) {
		this.genericSodaPrice = genericSodaPrice;
	}

	public float getAllTax() {
		return allTax;
	}

	public void setAllTax(float allTax) {
		this.allTax = allTax;
	}

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
		btnSignOut.setActionCommand("signout");

		JButton btnOrderScreen = new JButton("Order Screen");
		btnOrderScreen.setBounds(577, 6, 117, 29);
		contentPane.add(btnOrderScreen);
		btnOrderScreen.setActionCommand("orderscreen");

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
		btnClear.setActionCommand("clear");

		JButton btnApplyChanges = new JButton("Apply Changes");
		btnApplyChanges.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnApplyChanges.setBounds(328, 426, 168, 29);
		contentPane.add(btnApplyChanges);
		btnApplyChanges.setActionCommand("apply");

		// Action Listeners
		btnSignOut.addActionListener(this);
		btnOrderScreen.addActionListener(this);
		btnClear.addActionListener(this);
		btnApplyChanges.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if ("clear".equals(e.getActionCommand())) {
			pizzaSmall.setText("");
			pizzaMedium.setText("");
			pizzaLarge.setText("");
			toppingSmall.setText("");
			toppingMedium.setText("");
			toppingLarge.setText("");
			sodaPrice.setText("");
			tax.setText("");
		}
		if ("apply".equals(e.getActionCommand())) {
			if(Float.valueOf(pizzaSmall.getText()) > 0 && !pizzaSmall.getText().isEmpty()){
				setPizzaSmallPrice(Float.valueOf(pizzaSmall.getText()));
			}
			if(Float.valueOf(pizzaMedium.getText()) > 0 && !pizzaMedium.getText().isEmpty()){
				setPizzaMediumPrice(Float.valueOf(pizzaMedium.getText()));
			}
			if(Float.valueOf(pizzaLarge.getText()) > 0 && !pizzaLarge.getText().isEmpty()){
				setPizzaLargePrice(Float.valueOf(pizzaLarge.getText()));
			}
			if(Float.valueOf(toppingSmall.getText()) > 0 && !toppingSmall.getText().isEmpty()){
				setToppingSmallPrice(Float.valueOf(toppingSmall.getText()));
			}
			if(Float.valueOf(toppingMedium.getText()) > 0 && !toppingMedium.getText().isEmpty()){
				setToppingMediumPrice(Float.valueOf(toppingMedium.getText()));
			}
			if(Float.valueOf(toppingLarge.getText()) > 0 && !toppingLarge.getText().isEmpty()){
				setToppingLargePrice(Float.valueOf(toppingLarge.getText()));
			}
			if(Float.valueOf(sodaPrice.getText()) > 0 && !sodaPrice.getText().isEmpty()){
				setGenericSodaPrice(Float.valueOf(sodaPrice.getText()));
				System.out.println(genericSodaPrice);
			}
			if(Float.valueOf(tax.getText()) > 0 && !tax.getText().isEmpty()){
				setAllTax(Float.valueOf(tax.getText()));
			}
			
		}
		if ("signout".equals(e.getActionCommand())) {
		}
		if ("orderscreen".equals(e.getActionCommand())) {
		}

	}

}
