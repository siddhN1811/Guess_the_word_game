package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
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
		
		JLabel welcome = new JLabel("Welcome!");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Crete Round", Font.PLAIN, 15));
		welcome.setBounds(176, 11, 89, 23);
		frame.getContentPane().add(welcome);
		
		JButton insertB = new JButton("Insert Data");
		insertB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertPage ip = new InsertPage();
				ip.main(null);
				frame.setVisible(false);
			}
		});
		insertB.setBounds(148, 59, 149, 36);
		frame.getContentPane().add(insertB);
		
		JButton selectB = new JButton("Select Data");
		selectB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectPage sp = new SelectPage();
				sp.main(null);
				frame.setVisible(false);
			}
		});
		selectB.setBounds(148, 117, 149, 36);
		frame.getContentPane().add(selectB);
		
		JButton exitB = new JButton("Exit");
		exitB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitB.setBounds(148, 176, 149, 36);
		frame.getContentPane().add(exitB);
	}
}
