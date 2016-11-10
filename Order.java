import javax.swing.*;
import java.awt.*;

import static javax.swing.GroupLayout.Alignment.CENTER;

public class Order extends JFrame{
    public JTextField pinInput = new JTextField(10);

    public Order() {

        JLabel title = new JLabel();
        JLabel logo = new JLabel();
        JLabel pinLabel = new JLabel();

        JButton login = new JButton();

        title.setText("Bob's Pizza");
        title.setFont(new Font("Courier", Font.PLAIN,65));

        Icon icon = new ImageIcon("src/pizzaHeart.jpg");
        logo.setIcon(icon);

        pinLabel.setText("Enter PIN: ");
        pinInput.setMaximumSize(pinInput.getPreferredSize());

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });



        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        getContentPane().setBackground(Color.white);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addComponent(logo)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pinLabel)
                                .addComponent(pinInput)
                        )
                        .addComponent(login)
                )
        );


        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addComponent(logo)
                .addGroup(layout.createParallelGroup(CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(pinLabel)
                                        .addComponent(pinInput)
                                )
                        )
                )
                .addComponent(login)
        );

        setTitle("Bob's Pizza POS");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String pin = pinInput.getText();

        if("".equals(pin)){
            JOptionPane.showMessageDialog(this, "PIN is empty", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Hello "+pin, "Correct Input", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            "javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new Order().setVisible(true);
            }
        });
    }

}
