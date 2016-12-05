import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class Screens extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private CardLayout card;
	private String pinString;
	private String nameString;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screens frame = new Screens();
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
	public Screens() {
		setTitle("Bob's Pizza");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 694, 472);
		contentPane.add(panel);
		card = new CardLayout(0,0);
		panel.setLayout(card);
		
		Login();
		Order();
		Settings();
		Users();
		Prices();
	}
	

	 public void Login(){ 	
			JPanel login = new JPanel();
			panel.add(login, "login");
			login.setBackground(Color.WHITE);
			login.setBorder(new EmptyBorder(5, 5, 5, 5));
			login.setLayout(null);
			
			JTextField pin;
			
			JLabel lblBobsPizza = new JLabel("Bob's Pizza");
			lblBobsPizza.setFont(new Font("Lucida Grande", Font.BOLD, 38));
			lblBobsPizza.setBounds(237, 6, 243, 53);
			login.add(lblBobsPizza);
			
			JLabel logo = new JLabel();
			Image img = new ImageIcon(this.getClass().getResource("/pizzaHeart.jpg")).getImage();
			logo.setIcon(new ImageIcon(img)); //Set's Login Screen Logo
			logo.setBounds(204, 56, 279, 276);
			login.add(logo);
			
			JLabel lblEnterPin = new JLabel("Enter PIN");
			lblEnterPin.setBounds(274, 326, 61, 16);
			login.add(lblEnterPin);
			
			pin = new JTextField();
			lblEnterPin.setLabelFor(pin);
			pin.setBounds(347, 326, 97, 16);
			login.add(pin);
			pin.setColumns(10);
			
			JButton btnLogin = new JButton("Login");
			btnLogin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String pinInput = pin.getText(); //Set's the pin from user input
				        if(pinInput.length()!=4){
				            JOptionPane.showMessageDialog(null, "PIN is not length 4", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
				        }else if("".equals(pinInput)){
				            JOptionPane.showMessageDialog(null, "PIN is empty", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
				        }else{
			
				                BufferedReader br;
								try {
									br = new BufferedReader(new FileReader("Users"));
								
				                String line = br.readLine();
				                boolean flag = false;
				                while(line!=null){
				                    String[] user = line.split(",");
				                    if(pinInput.equals(user[0])){
				                    	nameString = user[1];
				                    	flag = true;
				                    }
				                    line=br.readLine();
				                }
				                if(!flag){
				                    JOptionPane.showMessageDialog(null, "Incorrect PIN", "Incorrect PIN", JOptionPane.ERROR_MESSAGE);
				                }else{
				                	card.show(panel, "order");
				                	pinString=pin.getText();
				                	
				                	
				                	pin.setText("");
				                }
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				        }
				}
			});
			btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			btnLogin.setBounds(288, 380, 117, 29);
			login.add(btnLogin);
		}
	 
	public void Order(){
		 	JPanel order;
			JTextField Cheese;
			JTextField Pepperoni;
			JTextField Extracheese;
			JTextField Sausage;
			JTextField Onion;
			JTextField Mushroom;
			JTextField GreenPepper;
			JTextField Bacon;
			JTextField soda;
			JTable receiptTable;
			
			JLabel name = new JLabel("");
			name.setBounds(321, 11, 61, 16);
			
			JLabel cashier = new JLabel("");
			cashier.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			cashier.setBounds(361, 79, 147, 16);
			
			order = new JPanel();
			order.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentShown(ComponentEvent e) {
					order.add(name);
					name.setText(nameString);
					cashier.setText(nameString);
					
				}
			});
			panel.add(order, "order");
			order.setBackground(Color.WHITE);
			order.setBorder(new EmptyBorder(5, 5, 5, 5));
			order.setLayout(null);
			
			JLabel lblCart = new JLabel("Cart");
			lblCart.setHorizontalAlignment(SwingConstants.CENTER);
			lblCart.setBounds(357, 60, 164, 16);
			order.add(lblCart);
			
			JScrollPane scrollPanel = new JScrollPane();
			scrollPanel.setBounds(419, 75, 275, 268);
			order.add(scrollPanel);
			JTable cartTable = new JTable(new DefaultTableModel(new Object[]{"#", "Item", "Edit", "Delete"},0));
			scrollPanel.setViewportView(cartTable);
			cartTable.setCellSelectionEnabled(true);
			cartTable.getColumnModel().getColumn(0).setPreferredWidth(15);
			cartTable.getColumnModel().getColumn(1).setPreferredWidth(130);
			cartTable.getColumnModel().getColumn(2).setPreferredWidth(15);
			cartTable.getColumnModel().getColumn(3).setPreferredWidth(15);
			
			//cartTable = new JTable();
			cartTable.setBorder(null);
			lblCart.setLabelFor(cartTable);
			
			JButton btnSignOut = new JButton("Sign Out");
			btnSignOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					card.show(panel, "login");
					
				}
			});
			btnSignOut.setBounds(6, 6, 117, 29);
			order.add(btnSignOut);
			
			JButton btnSettings = new JButton("Settings");
			btnSettings.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					card.show(panel, "settings");
				}
			});
			btnSettings.setBounds(577, 6, 117, 29);
			order.add(btnSettings);
			
			JLabel lblPizza = new JLabel("Pizza");
			lblPizza.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			lblPizza.setBounds(16, 47, 61, 16);
			order.add(lblPizza);
			
			JLabel lblSelectSize = new JLabel("1) Select Size");
			lblSelectSize.setBounds(6, 75, 90, 16);
			order.add(lblSelectSize);
			
			JLabel lblEnterNumber = new JLabel("2) Enter Quantities ");
			lblEnterNumber.setBounds(108, 75, 121, 16);
			order.add(lblEnterNumber);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 103, 71, 61);
			order.add(scrollPane);
			
			String[] ar = {"Small", "Medium", "Large"};
			JList sizeList = new JList(ar);
			sizeList.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
			scrollPane.setViewportView(sizeList);
			
			JPanel toppingsPanel = new JPanel();
			toppingsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			toppingsPanel.setBackground(Color.WHITE);
			toppingsPanel.setBounds(118, 103, 140, 224);
			order.add(toppingsPanel);
			toppingsPanel.setLayout(null);
			
			JLabel lblCheese = new JLabel("Cheese");
			lblCheese.setBounds(6, 6, 45, 16);
			toppingsPanel.add(lblCheese);
			
			JLabel lblPepperoni = new JLabel("Pepperoni");
			lblPepperoni.setBounds(6, 34, 83, 16);
			toppingsPanel.add(lblPepperoni);
			
			JLabel lblNewLabel = new JLabel("Extra Cheese");
			lblNewLabel.setBounds(6, 62, 83, 16);
			toppingsPanel.add(lblNewLabel);
			
			JLabel lblSausage = new JLabel("Sausage");
			lblSausage.setBounds(6, 90, 61, 16);
			toppingsPanel.add(lblSausage);
			
			JLabel lblOnion = new JLabel("Onion");
			lblOnion.setBounds(6, 118, 61, 16);
			toppingsPanel.add(lblOnion);
			
			JLabel lblMushroom = new JLabel("Mushroom");
			lblMushroom.setBounds(6, 146, 83, 16);
			toppingsPanel.add(lblMushroom);
			
			JLabel lblGreenPepper = new JLabel("Green Pepper");
			lblGreenPepper.setBounds(6, 174, 83, 16);
			toppingsPanel.add(lblGreenPepper);
			
			JLabel lblBacon = new JLabel("Bacon");
			lblBacon.setBounds(6, 202, 61, 16);
			toppingsPanel.add(lblBacon);
			
			Cheese = new JTextField();
			Cheese.setName("Cheese");
			lblCheese.setLabelFor(Cheese);
			Cheese.setBounds(89, 6, 45, 16);
			toppingsPanel.add(Cheese);
			Cheese.setColumns(10);
			
			Pepperoni = new JTextField();
			Pepperoni.setName("Pepperoni");
			lblPepperoni.setLabelFor(Pepperoni);
			Pepperoni.setBounds(89, 34, 45, 16);
			toppingsPanel.add(Pepperoni);
			Pepperoni.setColumns(10);
			
			Extracheese = new JTextField();
			Extracheese.setName("Extra Cheese");
			lblNewLabel.setLabelFor(Extracheese);
			Extracheese.setColumns(10);
			Extracheese.setBounds(89, 62, 45, 16);
			toppingsPanel.add(Extracheese);
			
			Sausage = new JTextField();
			Sausage.setName("Sausage");
			lblSausage.setLabelFor(Sausage);
			Sausage.setColumns(10);
			Sausage.setBounds(89, 90, 45, 16);
			toppingsPanel.add(Sausage);
			
			Onion = new JTextField();
			Onion.setName("Onion");
			lblOnion.setLabelFor(Onion);
			Onion.setColumns(10);
			Onion.setBounds(89, 118, 45, 16);
			toppingsPanel.add(Onion);
			
			Mushroom = new JTextField();
			Mushroom.setName("Mushroom");
			lblMushroom.setLabelFor(Mushroom);
			Mushroom.setColumns(10);
			Mushroom.setBounds(89, 146, 45, 16);
			toppingsPanel.add(Mushroom);
			
			GreenPepper = new JTextField();
			GreenPepper.setName("GreenPepper");
			lblGreenPepper.setLabelFor(GreenPepper);
			GreenPepper.setColumns(10);
			GreenPepper.setBounds(89, 174, 45, 16);
			toppingsPanel.add(GreenPepper);
			
			Bacon = new JTextField();
			Bacon.setName("Bacon");
			lblBacon.setLabelFor(Bacon);
			Bacon.setColumns(10);
			Bacon.setBounds(89, 202, 45, 16);
			toppingsPanel.add(Bacon);
			
			JButton btnAddPizzasTo = new JButton("Add Pizzas to Cart");
			btnAddPizzasTo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
					
					if(sizeList.isSelectionEmpty()){
						JOptionPane.showMessageDialog(null, "Please Select a Pizza Size", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
					}else{
						String size = sizeList.getSelectedValue().toString();
						boolean flag = false;
						String item;
						JTextField[] toppings = {Cheese, Pepperoni, Extracheese, Sausage, Onion, Mushroom, GreenPepper, Bacon};
						
						for(int i=0; i<toppings.length; i++){
							if(!toppings[i].getText().equals("")){
								flag=true;
								int amount = Integer.parseInt(toppings[i].getText());
								if(amount<=0 || amount>100){
									JOptionPane.showMessageDialog(null, "Number of pizzas must be between 1 and 100","Incorrect Input", JOptionPane.ERROR_MESSAGE);
								}else{
									item = size + " " + toppings[i].getName();
									model.addRow(new Object[]{toppings[i].getText(), item, "edit", "delete"});
								}
							}
						}
						if(!flag){
							JOptionPane.showMessageDialog(null, "Please Select Quantity","Incorrect Input", JOptionPane.ERROR_MESSAGE);
						}
						
						for(int i=0; i<toppings.length; i++){
							toppings[i].setText("");
						}
						
						sizeList.clearSelection();	
					}
				}
			});
			btnAddPizzasTo.setBounds(54, 360, 140, 29);
			order.add(btnAddPizzasTo);
			
			JLabel lblSoda = new JLabel("Soda");
			lblSoda.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			lblSoda.setBounds(295, 47, 61, 16);
			order.add(lblSoda);
			
			JPanel sodaPanel = new JPanel();
			sodaPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			sodaPanel.setBackground(Color.WHITE);
			sodaPanel.setBounds(284, 103, 117, 29);
			order.add(sodaPanel);
			sodaPanel.setLayout(null);
			
			JLabel lblGeneric = new JLabel("Generic");
			lblGeneric.setBounds(6, 6, 47, 16);
			sodaPanel.add(lblGeneric);
			
			soda = new JTextField();
			lblGeneric.setLabelFor(soda);
			soda.setColumns(10);
			soda.setBounds(66, 6, 45, 16);
			sodaPanel.add(soda);
			
			JButton btnAddSodasTo = new JButton("Add Sodas to Cart");
			btnAddSodasTo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
					if(!soda.getText().equals("")){
						int amount = Integer.parseInt(soda.getText());
						if(amount<=0 || amount>100){
							JOptionPane.showMessageDialog(null, "Number of sodas ust be between 1 and 100","Incorrect Input", JOptionPane.ERROR_MESSAGE);
						}else{
							String item =  "Sodas";
							model.addRow(new Object[]{soda.getText(), item, "edit", "delete"});
							soda.setText("");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Please Enter Quantity","Incorrect Input", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			btnAddSodasTo.setBounds(270, 144, 140, 29);
			order.add(btnAddSodasTo);
			
			JLabel lblEnterSodaQuantity = new JLabel("Enter Soda Quantity");
			lblEnterSodaQuantity.setBounds(284, 75, 129, 16);
			order.add(lblEnterSodaQuantity);
			
			
			
			cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
			    @Override
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			    	JTextField[] toppings = {Cheese, Pepperoni, Extracheese, Sausage, Onion, Mushroom, GreenPepper, Bacon};
			    	for(int i=0; i<toppings.length; i++){
						toppings[i].setText("");
					}
			    	
			    	DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
			        int row = cartTable.rowAtPoint(evt.getPoint());
			        int col = cartTable.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			            if(col == 2){
			            	String quant = model.getValueAt(row, 0).toString();
			            	String item = model.getValueAt(row, 1).toString();
			            	
			            	int counter = item.indexOf(" ");
							String pSize="";
							String pTop="";
							
							String[] topStrings = {"Cheese", "Pepperoni", "Extra Cheese", "Sausage", "Onion", "Mushroom", "GreenPepper", "Bacon"};
							
							if(counter>0){
								pSize = item.substring(0, counter);
								pTop = item.substring(counter+1, item.length());
								
								if(pSize.equals("Small")){
									sizeList.setSelectedIndex(0);
								} else if(pSize.equals("Medium")){
									sizeList.setSelectedIndex(1);
								} else if(pSize.equals("Large")){
									sizeList.setSelectedIndex(2);
								} 
								
								for(int i=0; i<topStrings.length; i++){
									if(pTop.equals(topStrings[i])){
										toppings[i].setText(quant);
									}
								}
							}
			            	
			            	model.removeRow(row);
			            }else if(col==3){
			            	model.removeRow(row);
			            }

			        }
			    }
			});
			
			JButton btnClearOrder = new JButton("Clear Order");
			btnClearOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
					model.setRowCount(0);
				}
			});
			btnClearOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			btnClearOrder.setBounds(503, 370, 129, 44);
			order.add(btnClearOrder);
			
			JPanel receipt = new JPanel();
			receipt.setBackground(Color.WHITE);
			panel.add(receipt, "reciept");
			receipt.setLayout(null);
			
			JLabel label = new JLabel("Bob's Pizza");
			label.setFont(new Font("Lucida Grande", Font.BOLD, 38));
			label.setBounds(241, 30, 243, 53);
			receipt.add(label);
			
			JScrollPane receiptScroll = new JScrollPane();
			receiptScroll.setBounds(128, 107, 462, 288);
			receipt.add(receiptScroll);
			
			receiptTable = new JTable(new DefaultTableModel(new Object[]{"#", "Item", "Price"},0){
				public boolean isCellEditable(int rowIndex, int mColIndex) {
			        return false;
			    }
			});
			receiptScroll.setViewportView(receiptTable);
			receiptScroll.setBorder(BorderFactory.createEmptyBorder());
			
			receiptTable.getColumnModel().getColumn(0).setPreferredWidth(15);
			receiptTable.getColumnModel().getColumn(1).setPreferredWidth(130);
			receiptTable.getColumnModel().getColumn(2).setPreferredWidth(15);
			
			receiptTable.setFocusable(false);
			receiptTable.setRowSelectionAllowed(false);
			
			receipt.add(cashier);
			
			JButton button = new JButton("Sign Out");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					card.show(panel, "login");
				}
			});
			button.setBounds(6, 6, 117, 29);
			receipt.add(button);
			
			JButton button_1 = new JButton("Order Screen");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel cartModel = (DefaultTableModel) cartTable.getModel();
					cartModel.setRowCount(0);
					card.show(panel, "order");
				}
			});
			button_1.setBounds(571, 6, 117, 29);
			receipt.add(button_1);
			
			JLabel lblTotal = new JLabel("Total:");
			lblTotal.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblTotal.setBounds(310, 438, 61, 16);
			receipt.add(lblTotal);
			
			JLabel total = new JLabel("");
			total.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			total.setBounds(383, 438, 84, 16);
			receipt.add(total);
			
			JLabel lblTax = new JLabel("Tax:");
			lblTax.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblTax.setBounds(310, 410, 61, 16);
			receipt.add(lblTax);
			
			JLabel tax = new JLabel("");
			tax.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			tax.setBounds(383, 410, 84, 16);
			receipt.add(tax);
			
			JLabel lblCashier = new JLabel("Cashier:");
			lblCashier.setBounds(276, 79, 61, 16);
			receipt.add(lblCashier);
			
			JButton btnSubmitOrder = new JButton("Submit Order");
			btnSubmitOrder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel receiptModel =(DefaultTableModel) receiptTable.getModel();
					DefaultTableModel cartModel = (DefaultTableModel) cartTable.getModel();
					receiptModel.setRowCount(0);
					
					if(cartModel.getRowCount()==0){
						JOptionPane.showMessageDialog(null, "No Items in Cart","Incorrect Input", JOptionPane.ERROR_MESSAGE);
					}else{
					
					card.show(panel, "reciept");
					float taxPer = 0;
					
					for(int i=0; i<cartModel.getRowCount(); i++){
						String quant = cartModel.getValueAt(i, 0).toString();
						String it = cartModel.getValueAt(i, 1).toString();
						int counter = it.indexOf(" ");
						boolean soda;
						String pSize="";
						String pTop="";
						
						if(counter>0){
							pSize = it.substring(0, counter);
							pTop = it.substring(counter+1, it.length());
							boolean hasTopping;
							
							if(pTop.equals("Cheese")){
								hasTopping = false;
							}else {
								hasTopping = true;
							}
							
							if(pSize.equals("Small")){
								pSize = "pizzaSmall";
								if(hasTopping){
									pTop = "toppingSmall";
								}
							}else if(pSize.equals("Medium")){
								pSize = "pizzaMedium";
								if(hasTopping){
									pTop = "toppingMedium";
								}
							}else if(pSize.equals("Large")){
								pSize = "pizzaLarge";
								if(hasTopping){
									pTop = "toppingLarge";
								}
							}
							soda=false;
						}else{
							soda = true;
						}
						
	
						BufferedReader br;
						try{
							br = new BufferedReader(new FileReader("Prices"));
							String line = null;
							float itemTotal=0;
			                
							while((line = br.readLine()) !=null){
								String prices[] = line.split(",");
								if(!soda){
									if(prices[0].equals(pSize)){
										itemTotal += Integer.parseInt(quant)*Float.parseFloat(prices[1]);
									}
									if(prices[0].equals(pTop)){
										itemTotal += Integer.parseInt(quant)*Float.parseFloat(prices[1]);
									}
								}else{
									if(prices[0].equals("sodaPrice")){
										itemTotal += Integer.parseInt(quant)*Float.parseFloat(prices[1]);
									}
								}
								if(prices[0].equals("tax")){
									taxPer=Float.parseFloat(prices[1]);
								}
								
							}
							DecimalFormat df = new DecimalFormat();
							df.setMaximumFractionDigits(2);
							receiptModel.addRow(new Object[]{quant, it, df.format(itemTotal)});
							br.close();
						}catch(FileNotFoundException e2) {
			                System.out.println("File not found.");
						}catch(IOException k){
			                System.out.println("IO Exception." + k);            
						}				
					}
					
					float tot = 0;
					float taxAmount = 0;
				
					for(int i=0; i<receiptModel.getRowCount(); i++){
						tot += Float.parseFloat(receiptModel.getValueAt(i, 2).toString());
					}
					
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(2);
					
					taxAmount = tot*taxPer;
					tax.setText(String.valueOf(df.format(taxAmount)));
					total.setText(String.valueOf(df.format(tot+taxAmount)));
				}
				}
			});
			btnSubmitOrder.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			btnSubmitOrder.setBounds(339, 370, 129, 44);
			order.add(btnSubmitOrder);
			
	 }
	public void Settings(){
		 JLabel name = new JLabel("");
			name.setBounds(321, 11, 61, 16);
		 
		 JPanel settings = new JPanel();
		 settings.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentShown(ComponentEvent e) {
					settings.add(name);
					name.setText(nameString);
				}
			});
		 panel.add(settings, "settings");
		 settings.setBackground(Color.WHITE);
		 settings.setBorder(new EmptyBorder(5, 5, 5, 5));
		 settings.setLayout(null);
		 
		 
			
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "login");
			}
		});
		btnSignOut.setBounds(6, 6, 117, 29);
		settings.add(btnSignOut);
			
		JButton btnOrderScreen = new JButton("Order Screen");
		btnOrderScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "order");
			}
		});
		btnOrderScreen.setBounds(577, 6, 117, 29);
		settings.add(btnOrderScreen);
			
		JButton btnChangePrices = new JButton("Change Prices");
		btnChangePrices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "prices");
			}
		});
		btnChangePrices.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnChangePrices.setBounds(255, 139, 167, 67);
		settings.add(btnChangePrices);
			
		JButton btnUserAccouts = new JButton("User Accouts");
		btnUserAccouts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "users");
			}
		});
		btnUserAccouts.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnUserAccouts.setBounds(255, 235, 167, 67);
		settings.add(btnUserAccouts);
		
	 }
	 
	
	public void Users(){
		
		JLabel name = new JLabel("");
		name.setBounds(321, 11, 61, 16);
			 
			JTextField addName;
			JTextField addPin;
			JTextField editName;
			JTextField editPin;
			JTextField deleteName;
			JTextField deletePin;
			 
			 JPanel users = new JPanel();
			 users.addComponentListener(new ComponentAdapter() {
					@Override
					public void componentShown(ComponentEvent e) {
						users.add(name);
						name.setText(nameString);
					}
				});
			 panel.add(users, "users");
			 users.setBackground(Color.WHITE);
			 users.setBorder(new EmptyBorder(5, 5, 5, 5));
			 users.setLayout(null);
				
				JButton btnSignOut = new JButton("Sign Out");
				btnSignOut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						card.show(panel, "login");
					}
				});
				btnSignOut.setBounds(6, 6, 117, 29);
				users.add(btnSignOut);
				
				JButton btnOrderScreen = new JButton("Order Screen");
				btnOrderScreen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						card.show(panel, "order");
					}
				});
				btnOrderScreen.setBounds(577, 6, 117, 29);
				users.add(btnOrderScreen);
				
				JLabel lblAddAUser = new JLabel("Add a User:");
				lblAddAUser.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblAddAUser.setBounds(6, 65, 91, 16);
				users.add(lblAddAUser);
				
				addName = new JTextField();
				addName.setBounds(76, 93, 134, 16);
				users.add(addName);
				addName.setColumns(10);
				
				JLabel lbladdName = new JLabel("Name");
				lbladdName.setLabelFor(addName);
				lbladdName.setBounds(16, 93, 61, 16);
				users.add(lbladdName);
				
				JLabel lbladdPin = new JLabel("PIN");
				lbladdPin.setBounds(260, 93, 61, 16);
				users.add(lbladdPin);
				
				addPin = new JTextField();
				lbladdPin.setLabelFor(addPin);
				addPin.setColumns(10);
				addPin.setBounds(300, 93, 134, 16);
				users.add(addPin);
				
				JLabel lblEditAUser = new JLabel("Edit a User:");
				lblEditAUser.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblEditAUser.setBounds(6, 159, 91, 16);
				users.add(lblEditAUser);
				
				JLabel lbleditName = new JLabel("Name");
				lbleditName.setBounds(16, 187, 61, 16);
				users.add(lbleditName);
				
				editName = new JTextField();
				lbleditName.setLabelFor(editName);
				editName.setColumns(10);
				editName.setBounds(76, 187, 134, 16);
				users.add(editName);
				
				JLabel lbleditPin = new JLabel("PIN");
				lbleditPin.setBounds(260, 187, 61, 16);
				users.add(lbleditPin);
				
				editPin = new JTextField();
				lbleditPin.setLabelFor(editPin);
				editPin.setColumns(10);
				editPin.setBounds(300, 187, 134, 16);
				users.add(editPin);
				
				JLabel lblDeleteAUser = new JLabel("Delete a User:");
				lblDeleteAUser.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblDeleteAUser.setBounds(6, 260, 117, 16);
				users.add(lblDeleteAUser);
				
				JLabel lbldeletePin = new JLabel("PIN");
				lbldeletePin.setBounds(16, 288, 61, 16);
				users.add(lbldeletePin);
				
				deletePin = new JTextField();
				lbldeletePin.setLabelFor(deletePin);
				deletePin.setColumns(10);
				deletePin.setBounds(76, 288, 134, 16);
				users.add(deletePin);
				
				JButton btnApplydel = new JButton("Apply Delete");
				btnApplydel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String pin1 = deletePin.getText();
						BufferedReader br;
						
						if(pin1.length()!=4){
				            JOptionPane.showMessageDialog(null, "Enter correct length PIN", "PIN is not length 4", JOptionPane.ERROR_MESSAGE);
				        }else if("".equals(pin1)){
				            JOptionPane.showMessageDialog(null, "PIN is empty", "Enter PIN", JOptionPane.ERROR_MESSAGE);
				        }else {
		
						try{
							
							File users = new File("Users");
							File tempFile = new File(users.getAbsolutePath() + ".tmp");
							br = new BufferedReader(new FileReader("Users"));
							PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
							String line = null;
							int counter = 0;
				
						/*if(br.readLine() == null){
							JOptionPane.showMessageDialog(null, "There is only one user", "Cannot Delete", JOptionPane.ERROR_MESSAGE);
							
						}*/
						
						while((line = br.readLine()) !=null){
							counter++;
		                      if( !line.trim().startsWith(pin1)){
		                    	  
		                    	  pw.println(line);
		                    	  pw.flush();
		                    	 
		                      } 
			                    
		                    }
		                    pw.close();
		                    br.close();
		                   
		                
						if(!users.delete()){
							System.out.println("could not delete file");
							return;
						}
						if(counter != 1){
						if(!tempFile.renameTo(users)){
							System.out.println("Could not rename file");
						}
		                }else{
		                	JOptionPane.showMessageDialog(null, "There is only one user", "Cannot Delete", JOptionPane.ERROR_MESSAGE);
		                }
		                
				
						}catch(FileNotFoundException e2) {
			                System.out.println("File not found.");
						}catch(IOException k){
			                System.out.println("IO Exception.");            
						}
						deletePin.setText("");
					}
					}
					
					
				});
				btnApplydel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				btnApplydel.setBounds(470, 280, 160, 29);
				users.add(btnApplydel);
				
				JButton btnApplyedit = new JButton("Apply Edit");
				btnApplyedit.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				btnApplyedit.setBounds(470, 181, 160, 29);
				users.add(btnApplyedit);
				
				JButton btnApplyAdd = new JButton("Apply Changes");
				btnApplyAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						String pinI = addPin.getText();
						String nameI = addName.getText();
						if(pinI.length()!=4){
				            JOptionPane.showMessageDialog(null, "PIN is not length 4", "Enter correct length PIN", JOptionPane.ERROR_MESSAGE);
				        }else if("".equals(pinI)){
				            JOptionPane.showMessageDialog(null, "PIN is empty", "Add PIN", JOptionPane.ERROR_MESSAGE);
				        }else if("".equals(nameI)){
				        	JOptionPane.showMessageDialog(null, "No name was entered", "Add name", JOptionPane.ERROR_MESSAGE);
				        	
				        }else{
						BufferedReader br;
						try{
							br = new BufferedReader(new FileReader("Users"));
							String line = br.readLine();
			                boolean flag = false;
			                
						FileWriter writer = new FileWriter("Users", true);
						BufferedWriter bufferedWriter = new BufferedWriter(writer);
						
						
						
						
						while(line!=null){
		                    String[] user = line.split(",");
		                    if(pinI.equals(user[0])){
		                        flag = true;
		                    }
		                    line=br.readLine();
		                }
		                if(!flag){
		                	bufferedWriter.newLine();
		                	bufferedWriter.write(addPin.getText() +"," + addName.getText());
		                	JOptionPane.showMessageDialog(null, "User Added", "User Added", JOptionPane.PLAIN_MESSAGE);
		                }else{
		                    
		                    JOptionPane.showMessageDialog(null, "PIN Already Exists", "PIN Already Exists", JOptionPane.ERROR_MESSAGE);
		                }

						
						bufferedWriter.close();
						}catch(FileNotFoundException e) {
			                System.out.println("File not found.");
						}catch(IOException k){
			                System.out.println("IO Exception.");            
			            }
					}
						addName.setText("");
						addPin.setText("");
					}	
					
				});
				btnApplyAdd.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				btnApplyAdd.setBounds(470, 87, 160, 29);
				users.add(btnApplyAdd);
		 }
	 
	public void Prices(){
		  JPanel contentPane;
			 JTextField pizzaSmall;
			 JTextField pizzaMedium;
			 JTextField pizzaLarge;
			 JTextField toppingSmall;
			 JTextField toppingMedium;
			 JTextField toppingLarge;
			 JTextField sodaPrice;
			 JTextField tax;
			 float pizzaSmallPrice;
			 float pizzaMediumPrice;
			 float pizzaLargePrice;
			 float toppingSmallPrice;
			 float toppingMediumPrice;
			 float toppingLargePrice;
			 float genericSodaPrice;
			 float allTax;
			 

				JLabel name = new JLabel("");
				name.setBounds(321, 11, 61, 16);
				 
		 
		 JPanel prices = new JPanel();
		 prices.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentShown(ComponentEvent e) {
					prices.add(name);
					name.setText(nameString);
				}
			});
		 panel.add(prices, "prices");
		 prices.setBackground(Color.WHITE);
		 prices.setBorder(new EmptyBorder(5, 5, 5, 5));
		 prices.setLayout(null);

			JButton btnSignOut = new JButton("Sign Out");
			btnSignOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					card.show(panel, "login");
					
				}
			});
			btnSignOut.setBounds(6, 6, 117, 29);
			prices.add(btnSignOut);

			JButton btnOrderScreen = new JButton("Order Screen");
			btnOrderScreen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					card.show(panel, "order");
				}
			});
			btnOrderScreen.setBounds(577, 6, 117, 29);
			prices.add(btnOrderScreen);
			
			JLabel lblPizzaPrice = new JLabel("Pizza Price");
			lblPizzaPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblPizzaPrice.setBounds(6, 65, 97, 16);
			prices.add(lblPizzaPrice);

			JLabel lblpizzaSmall = new JLabel("Small");
			lblpizzaSmall.setBounds(16, 93, 61, 16);
			prices.add(lblpizzaSmall);

			pizzaSmall = new JTextField();
			lblpizzaSmall.setLabelFor(pizzaSmall);
			pizzaSmall.setBounds(89, 93, 61, 16);
			prices.add(pizzaSmall);
			pizzaSmall.setColumns(10);

			JLabel lblpizzaMedium = new JLabel("Medium");
			lblpizzaMedium.setBounds(201, 93, 61, 16);
			prices.add(lblpizzaMedium);

			pizzaMedium = new JTextField();
			lblpizzaMedium.setLabelFor(pizzaMedium);
			pizzaMedium.setColumns(10);
			pizzaMedium.setBounds(274, 93, 61, 16);
			prices.add(pizzaMedium);

			JLabel lblpizzaLarge = new JLabel("Large");
			lblpizzaLarge.setBounds(416, 93, 61, 16);
			prices.add(lblpizzaLarge);

			pizzaLarge = new JTextField();
			lblpizzaLarge.setLabelFor(pizzaLarge);
			pizzaLarge.setColumns(10);
			pizzaLarge.setBounds(478, 93, 61, 16);
			prices.add(pizzaLarge);

			JLabel lblToppingPrice = new JLabel("Topping Price");
			lblToppingPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblToppingPrice.setBounds(6, 168, 117, 19);
			prices.add(lblToppingPrice);

			JLabel lbltoppingSmall = new JLabel("Small");
			lbltoppingSmall.setBounds(16, 199, 61, 16);
			prices.add(lbltoppingSmall);

			toppingSmall = new JTextField();
			lbltoppingSmall.setLabelFor(toppingSmall);
			toppingSmall.setColumns(10);
			toppingSmall.setBounds(89, 199, 61, 16);
			prices.add(toppingSmall);

			JLabel lbltoppingMedium = new JLabel("Medium");
			lbltoppingMedium.setBounds(201, 199, 61, 16);
			prices.add(lbltoppingMedium);

			toppingMedium = new JTextField();
			lbltoppingMedium.setLabelFor(toppingMedium);
			toppingMedium.setColumns(10);
			toppingMedium.setBounds(274, 199, 61, 16);
			prices.add(toppingMedium);

			JLabel lbltoppingLarge = new JLabel("Large");
			lbltoppingLarge.setBounds(416, 199, 61, 16);
			prices.add(lbltoppingLarge);

			toppingLarge = new JTextField();
			lbltoppingLarge.setLabelFor(toppingLarge);
			toppingLarge.setColumns(10);
			toppingLarge.setBounds(478, 199, 61, 16);
			prices.add(toppingLarge);

			JLabel lblSodaPrice = new JLabel("Soda Price");
			lblSodaPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblSodaPrice.setBounds(6, 273, 97, 16);
			prices.add(lblSodaPrice);

			sodaPrice = new JTextField();
			sodaPrice.setColumns(10);
			sodaPrice.setBounds(16, 301, 61, 16);
			prices.add(sodaPrice);

			JLabel lblTax = new JLabel("Tax");
			lblTax.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblTax.setBounds(6, 367, 61, 16);
			prices.add(lblTax);

			tax = new JTextField();
			tax.setColumns(10);
			tax.setBounds(16, 395, 61, 16);
			prices.add(tax);

			JButton btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pizzaSmall.setText("");
					pizzaMedium.setText("");
					pizzaLarge.setText("");
					toppingSmall.setText("");
					toppingMedium.setText("");
					toppingLarge.setText("");
					sodaPrice.setText("");
					tax.setText("");
				}
			});
			btnClear.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			btnClear.setBounds(145, 425, 117, 29);
			prices.add(btnClear);

			//update prices
JButton btnApplyChanges = new JButton("Apply Changes");
			btnApplyChanges.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ("Apply Changes".equals(e.getActionCommand())) {
						

				JTextField[] priceChange = {pizzaSmall,toppingSmall,pizzaMedium,toppingMedium,pizzaLarge,toppingLarge,sodaPrice,tax};
						
						for(int i=0; i<priceChange.length; i++){
							if(!priceChange[i].getText().equals("")){
								float price = Float.parseFloat(priceChange[i].getText());
								if(price<=0){
									JOptionPane.showMessageDialog(null, "Please enter a positive amount","Incorrect Input", JOptionPane.ERROR_MESSAGE);
								}
							}
							for(int j=0; j<priceChange[i].getText().length(); j++){
								
							}
						}
						
						BufferedReader br;
						
						try{
							
							File prices = new File("Prices");
							File tempFile = new File(prices.getAbsolutePath() + ".tmp");
							br = new BufferedReader(new FileReader("Prices"));
							PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

							String line = null;
			                
						while((line = br.readLine()) !=null){
							 
							String[] prices1 = line.split(",");
							if(Float.valueOf(pizzaSmall.getText()) > 0 && !pizzaSmall.getText().isEmpty() && prices1[0].equals("pizzaSmall")){
								pw.println(prices1[0] + "," + pizzaSmall.getText());
							}
							if(Float.valueOf(pizzaMedium.getText()) > 0 && !pizzaMedium.getText().isEmpty() && prices1[0].equals("pizzaMedium")){
								pw.println(prices1[0] + "," + pizzaMedium.getText());
							}
							if(Float.valueOf(pizzaLarge.getText()) > 0 && !pizzaLarge.getText().isEmpty() && prices1[0].equals("pizzaLarge")){
								pw.println(prices1[0] + "," + pizzaLarge.getText());
							}
							if(Float.valueOf(toppingSmall.getText()) > 0 && !toppingSmall.getText().isEmpty() && prices1[0].equals("toppingSmall")){
								pw.println(prices1[0] + "," + toppingSmall.getText());
							}
							if(Float.valueOf(toppingMedium.getText()) > 0 && !toppingMedium.getText().isEmpty() && prices1[0].equals("toppingMedium")){
								pw.println(prices1[0] + "," + toppingMedium.getText());
							}
							if(Float.valueOf(toppingLarge.getText()) > 0 && !toppingLarge.getText().isEmpty() && prices1[0].equals("toppingLarge")){
								pw.println(prices1[0] + "," + toppingLarge.getText());
							}
							if(Float.valueOf(sodaPrice.getText()) > 0 && !sodaPrice.getText().isEmpty() && prices1[0].equals("sodaPrice")){
								pw.println(prices1[0] + "," + sodaPrice.getText());
							}
							if(Float.valueOf(tax.getText()) > 0 && !tax.getText().isEmpty() && prices1[0].equals("tax")){
								pw.println(prices1[0] + "," + tax.getText());
							}
					
		                    	  pw.flush();
			                    
		                    }
		                    pw.close();
		                    br.close();
		                   
						if(!tempFile.renameTo(prices)){
							System.out.println("Could not rename file");
						}
						
						}catch(FileNotFoundException e2) {
			                System.out.println("File not found.");
						}catch(IOException k){
			                System.out.println("IO Exception.");            
						}
					}
				
				}
			});
			btnApplyChanges.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			btnApplyChanges.setBounds(328, 426, 168, 29);
			prices.add(btnApplyChanges);
			
			//autofill with default prices
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader("Prices"));
			
	        String line = br.readLine();
	 
	        while(line!=null){
	            String[] priceArray = line.split(",");
	            line=br.readLine();
	            if(priceArray[0].equals("pizzaSmall")){
	            	pizzaSmall.setText(priceArray[1]);
	            }else if(priceArray[0].equals("pizzaMedium")){
	            	pizzaMedium.setText(priceArray[1]);
	            }else if(priceArray[0].equals("pizzaLarge")){
	            	pizzaLarge.setText(priceArray[1]);
	            }else if(priceArray[0].equals("toppingSmall")){
	            	toppingSmall.setText(priceArray[1]);
	            }else if(priceArray[0].equals("toppingMedium")){
	            	toppingMedium.setText(priceArray[1]);
	            }else if(priceArray[0].equals("toppingLarge")){
	            	toppingLarge.setText(priceArray[1]);
	            }else if(priceArray[0].equals("sodaPrice")){
	            	sodaPrice.setText(priceArray[1]);
	            }else if(priceArray[0].equals("tax")){
	            	tax.setText(priceArray[1]);
	            }
	        }
	        
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
}

	
