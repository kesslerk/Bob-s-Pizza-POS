import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;


public class OrderScreen extends JFrame {

	private JPanel contentPane;
	private JTextField cheese;
	private JTextField pepperoni;
	private JTextField xcheese;
	private JTextField sausage;
	private JTextField onion;
	private JTextField mushroom;
	private JTextField greenpepper;
	private JTextField bacon;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderScreen frame = new OrderScreen();
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
	public OrderScreen() {
		setTitle("Bob's Pizza");
		setBackground(new Color(238, 238, 238));
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
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(577, 6, 117, 29);
		contentPane.add(btnSettings);
		
		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblPizza.setBounds(16, 47, 61, 16);
		contentPane.add(lblPizza);
		
		JLabel lblSelectSize = new JLabel("1) Select Size");
		lblSelectSize.setBounds(6, 75, 90, 16);
		contentPane.add(lblSelectSize);
		
		JLabel lblEnterNumber = new JLabel("2) Enter Quantities ");
		lblEnterNumber.setBounds(108, 75, 121, 16);
		contentPane.add(lblEnterNumber);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 103, 71, 61);
		contentPane.add(scrollPane);
		
		String[] ar = {"Small", "Medium", "Large"};
		JList list = new JList(ar);
		list.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		scrollPane.setViewportView(list);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(118, 103, 140, 224);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCheese = new JLabel("Cheese");
		lblCheese.setBounds(6, 6, 45, 16);
		panel.add(lblCheese);
		
		JLabel lblPepperoni = new JLabel("Pepperoni");
		lblPepperoni.setBounds(6, 34, 83, 16);
		panel.add(lblPepperoni);
		
		JLabel lblNewLabel = new JLabel("Extra Cheese");
		lblNewLabel.setBounds(6, 62, 83, 16);
		panel.add(lblNewLabel);
		
		JLabel lblSausage = new JLabel("Sausage");
		lblSausage.setBounds(6, 90, 61, 16);
		panel.add(lblSausage);
		
		JLabel lblOnion = new JLabel("Onion");
		lblOnion.setBounds(6, 118, 61, 16);
		panel.add(lblOnion);
		
		JLabel lblMushroom = new JLabel("Mushroom");
		lblMushroom.setBounds(6, 146, 83, 16);
		panel.add(lblMushroom);
		
		JLabel lblGreenPepper = new JLabel("Green Pepper");
		lblGreenPepper.setBounds(6, 174, 83, 16);
		panel.add(lblGreenPepper);
		
		JLabel lblBacon = new JLabel("Bacon");
		lblBacon.setBounds(6, 202, 61, 16);
		panel.add(lblBacon);
		
		cheese = new JTextField();
		lblCheese.setLabelFor(cheese);
		cheese.setBounds(89, 6, 45, 16);
		panel.add(cheese);
		cheese.setColumns(10);
		
		pepperoni = new JTextField();
		lblPepperoni.setLabelFor(pepperoni);
		pepperoni.setBounds(89, 34, 45, 16);
		panel.add(pepperoni);
		pepperoni.setColumns(10);
		
		xcheese = new JTextField();
		lblNewLabel.setLabelFor(xcheese);
		xcheese.setColumns(10);
		xcheese.setBounds(89, 62, 45, 16);
		panel.add(xcheese);
		
		sausage = new JTextField();
		lblSausage.setLabelFor(sausage);
		sausage.setColumns(10);
		sausage.setBounds(89, 90, 45, 16);
		panel.add(sausage);
		
		onion = new JTextField();
		lblOnion.setLabelFor(onion);
		onion.setColumns(10);
		onion.setBounds(89, 118, 45, 16);
		panel.add(onion);
		
		mushroom = new JTextField();
		lblMushroom.setLabelFor(mushroom);
		mushroom.setColumns(10);
		mushroom.setBounds(89, 146, 45, 16);
		panel.add(mushroom);
		
		greenpepper = new JTextField();
		lblGreenPepper.setLabelFor(greenpepper);
		greenpepper.setColumns(10);
		greenpepper.setBounds(89, 174, 45, 16);
		panel.add(greenpepper);
		
		bacon = new JTextField();
		lblBacon.setLabelFor(bacon);
		bacon.setColumns(10);
		bacon.setBounds(89, 202, 45, 16);
		panel.add(bacon);
		
		JButton btnAddPizzasTo = new JButton("Add Pizzas to Cart");
		btnAddPizzasTo.setBounds(54, 360, 140, 29);
		contentPane.add(btnAddPizzasTo);
		
		JLabel lblSoda = new JLabel("Soda");
		lblSoda.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblSoda.setBounds(327, 47, 61, 16);
		contentPane.add(lblSoda);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(327, 103, 117, 29);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblGeneric = new JLabel("Generic");
		lblGeneric.setBounds(6, 6, 47, 16);
		panel_1.add(lblGeneric);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(66, 6, 45, 16);
		panel_1.add(textField);
		
		JButton btnAddSodasTo = new JButton("Add Sodas to Cart");
		btnAddSodasTo.setBounds(316, 144, 140, 29);
		contentPane.add(btnAddSodasTo);
		
		JLabel lblEnterSodaQuantity = new JLabel("Enter Soda Quantity");
		lblEnterSodaQuantity.setBounds(316, 75, 129, 16);
		contentPane.add(lblEnterSodaQuantity);
		
		JButton btnSubmitOrder = new JButton("Submit Order");
		btnSubmitOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmitOrder.setBounds(339, 370, 129, 44);
		contentPane.add(btnSubmitOrder);
		
		JButton btnClearOrder = new JButton("Clear Order");
		btnClearOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnClearOrder.setBounds(503, 370, 129, 44);
		contentPane.add(btnClearOrder);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(530, 76, 164, 267);
		contentPane.add(table);
		
		JLabel lblCart = new JLabel("Cart");
		lblCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblCart.setBounds(530, 58, 164, 16);
		contentPane.add(lblCart);
		
	}
}
