import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class UsersScreen extends JFrame {

	private JPanel contentPane;
	private JTextField addName;
	private JTextField addPin;
	private JTextField editName;
	private JTextField editPin;
	private JTextField deleteName;
	private JTextField deletePin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersScreen frame = new UsersScreen();
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
	public UsersScreen() {
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
		
		JLabel lblAddAUser = new JLabel("Add a User:");
		lblAddAUser.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblAddAUser.setBounds(6, 65, 91, 16);
		contentPane.add(lblAddAUser);
		
		addName = new JTextField();
		addName.setBounds(76, 93, 134, 16);
		contentPane.add(addName);
		addName.setColumns(10);
		
		JLabel lbladdName = new JLabel("Name");
		lbladdName.setLabelFor(addName);
		lbladdName.setBounds(16, 93, 61, 16);
		contentPane.add(lbladdName);
		
		JLabel lbladdPin = new JLabel("PIN");
		lbladdPin.setBounds(335, 93, 61, 16);
		contentPane.add(lbladdPin);
		
		addPin = new JTextField();
		lbladdPin.setLabelFor(addPin);
		addPin.setColumns(10);
		addPin.setBounds(376, 93, 134, 16);
		contentPane.add(addPin);
		
		JLabel lblEditAUser = new JLabel("Edit a User:");
		lblEditAUser.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblEditAUser.setBounds(6, 159, 91, 16);
		contentPane.add(lblEditAUser);
		
		JLabel lbleditName = new JLabel("Name");
		lbleditName.setBounds(16, 187, 61, 16);
		contentPane.add(lbleditName);
		
		editName = new JTextField();
		lbleditName.setLabelFor(editName);
		editName.setColumns(10);
		editName.setBounds(76, 187, 134, 16);
		contentPane.add(editName);
		
		JLabel lbleditPin = new JLabel("PIN");
		lbleditPin.setBounds(335, 187, 61, 16);
		contentPane.add(lbleditPin);
		
		editPin = new JTextField();
		lbleditPin.setLabelFor(editPin);
		editPin.setColumns(10);
		editPin.setBounds(376, 187, 134, 16);
		contentPane.add(editPin);
		
		JLabel lblDeleteAUser = new JLabel("Delete a User:");
		lblDeleteAUser.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblDeleteAUser.setBounds(6, 260, 117, 16);
		contentPane.add(lblDeleteAUser);
		
		JLabel lbldeleteName = new JLabel("Name");
		lbldeleteName.setBounds(16, 288, 61, 16);
		contentPane.add(lbldeleteName);
		
		deleteName = new JTextField();
		lbldeleteName.setLabelFor(deleteName);
		deleteName.setColumns(10);
		deleteName.setBounds(76, 288, 134, 16);
		contentPane.add(deleteName);
		
		JLabel lbldeletePin = new JLabel("PIN");
		lbldeletePin.setBounds(335, 288, 61, 16);
		contentPane.add(lbldeletePin);
		
		deletePin = new JTextField();
		lbldeletePin.setLabelFor(deletePin);
		deletePin.setColumns(10);
		deletePin.setBounds(376, 288, 134, 16);
		contentPane.add(deletePin);
		
		JButton btnApplyChanges = new JButton("Apply Changes");
		btnApplyChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String pinI = addPin.getText();
				String nameI = addName.getText();
				if(pinI.length()!=4){
		            JOptionPane.showMessageDialog(null, "PIN is not length 4", "Enter correct length PIN", JOptionPane.ERROR_MESSAGE);
		        }else if("".equals(pinI)){
		            JOptionPane.showMessageDialog(null, "PIN is empty", "Add PIN", JOptionPane.ERROR_MESSAGE);
		        }else if("".equals(nameI)){
		        	JOptionPane.showMessageDialog(null, "No name was entered", "Add name", JOptionPane.ERROR_MESSAGE);
		        	
		        }
				BufferedReader br;
				try{
					br = new BufferedReader(new FileReader("Users"));
					String line = br.readLine();
	                boolean flag = false;
	                
				FileWriter writer = new FileWriter("Users", true);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);
				bufferedWriter.newLine();
				bufferedWriter.write(addPin.getText() +"," + addName.getText());
				
				
				while(line!=null){
                    String[] user = line.split(",");
                    if(pinI.equals(user[0])){
                        flag = true;
                    }
                    line=br.readLine();
                }
                if(!flag){
                	JOptionPane.showMessageDialog(null, "Hello ", "Saved", JOptionPane.PLAIN_MESSAGE);
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Incorrect PIN", "Incorrect PIN", JOptionPane.ERROR_MESSAGE);
                }

				
				bufferedWriter.close();
				}catch(FileNotFoundException e) {
	                System.out.println("File not found.");
				}catch(IOException k){
	                System.out.println("IO Exception.");            
	            }
			}
				
			
		});
		btnApplyChanges.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnApplyChanges.setBounds(297, 411, 160, 29);
		contentPane.add(btnApplyChanges);
	}

}
