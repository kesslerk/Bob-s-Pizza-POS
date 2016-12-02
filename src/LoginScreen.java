import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField pin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		logo.setBounds(204, 56, 279, 276);
		contentPane.add(logo);
		
		JLabel lblEnterPin = new JLabel("Enter PIN");
		lblEnterPin.setBounds(274, 326, 61, 16);
		contentPane.add(lblEnterPin);
		
		pin = new JTextField();
		lblEnterPin.setLabelFor(pin);
		pin.setBounds(347, 326, 97, 16);
		contentPane.add(pin);
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
			                        flag = true;
			                    }
			                    line=br.readLine();
			                }
			                if(!flag){
			                    JOptionPane.showMessageDialog(null, "Incorrect PIN", "Incorrect PIN", JOptionPane.ERROR_MESSAGE);
			                }else{
			                    JOptionPane.showMessageDialog(null, "Hello "+pin, "Correct Input", JOptionPane.PLAIN_MESSAGE);
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
		contentPane.add(btnLogin);
	}
}