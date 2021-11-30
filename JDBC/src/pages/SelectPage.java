package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SelectPage {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectPage window = new SelectPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(136, 11, 179, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel rno = new JLabel("Enter Roll Number");
		rno.setHorizontalAlignment(SwingConstants.CENTER);
		rno.setBounds(23, 19, 103, 14);
		frame.getContentPane().add(rno);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_build","root","");
					Statement st = con.createStatement();
					String rno =textField.getText();
					ResultSet rs= st.executeQuery("SELECT * FROM `sem 3` WHERE `Roll No`="+rno);
					String name = rs.getString("Name");
					String addr = rs.getString("Address");
					String cgpa = rs.getString("CGPA");
					JOptionPane.showMessageDialog(frame,"Data Found \n ASDF");
					clearFields();
					st.close();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			private void clearFields() {
				// TODO Auto-generated method stub
				textField.setText("");
			}
			
		});
		btnNewButton.setBounds(125, 67, 114, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(125, 118, 114, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Home Page");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(125, 174, 114, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
