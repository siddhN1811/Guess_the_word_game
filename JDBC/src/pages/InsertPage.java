package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
import java.awt.event.ActionEvent;

public class InsertPage {

	private JFrame frame;
	private JTextField rollNoTextField;
	private JTextField nameTextField;
	private JTextField addrTextField;
	private JTextField cgpaTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertPage window = new InsertPage();
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
	public InsertPage() {
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
		
		JLabel rollNoLabel = new JLabel("Roll Number");
		rollNoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rollNoLabel.setBounds(10, 11, 160, 31);
		frame.getContentPane().add(rollNoLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(10, 63, 160, 31);
		frame.getContentPane().add(nameLabel);
		
		JLabel addrLabel = new JLabel("Address");
		addrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addrLabel.setBounds(10, 114, 160, 31);
		frame.getContentPane().add(addrLabel);
		
		JLabel cgpaLabel = new JLabel("CGPA");
		cgpaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cgpaLabel.setBounds(10, 163, 160, 31);
		frame.getContentPane().add(cgpaLabel);
		
		rollNoTextField = new JTextField();
		rollNoTextField.setBounds(180, 11, 167, 31);
		frame.getContentPane().add(rollNoTextField);
		rollNoTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(180, 63, 167, 31);
		frame.getContentPane().add(nameTextField);
		
		addrTextField = new JTextField();
		addrTextField.setColumns(10);
		addrTextField.setBounds(180, 114, 167, 31);
		frame.getContentPane().add(addrTextField);
		
		cgpaTextField = new JTextField();
		cgpaTextField.setColumns(10);
		cgpaTextField.setBounds(180, 163, 167, 31);
		frame.getContentPane().add(cgpaTextField);
		
		JButton submitB = new JButton("SUBMIT");
		submitB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String rollNo = rollNoTextField.getText();
				String name = nameTextField.getText();
				String addr = addrTextField.getText();
				String cgpa = cgpaTextField.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_build","root","");
					System.out.println("Connection Successful");
					Statement st = con.createStatement();
					String str ="INSERT INTO `sem 3`(`Roll No`, `Name`, `Address`, `CGPA`) VALUES ('"+rollNo+"','"+name+"','"+addr+"','"+cgpa+"')";
					st.executeUpdate(str);
					JOptionPane.showMessageDialog(frame,"Data Added");
					clearFields();
					st.close();
					con.close();
				} catch (Exception e1) {
					System.out.println(e1.getMessage()+"error");
				}
			}
			
			private void clearFields() {
				rollNoTextField.setText(null);
				nameTextField.setText(null);
				addrTextField.setText(null);
				cgpaTextField.setText(null);
			}
		});
		submitB.setBounds(103, 227, 117, 23);
		frame.getContentPane().add(submitB);
		
		JButton btnHome = new JButton("HomePage");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage();
				hp.main(null);
				frame.setVisible(false);
			}
		});
		btnHome.setBounds(230, 227, 117, 23);
		frame.getContentPane().add(btnHome);
	}
}
