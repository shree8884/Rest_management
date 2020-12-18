package restaurant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Drinks extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drinks frame = new Drinks();
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
	public Drinks() {
		setTitle("Drinks");
		setForeground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 406);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDrinks = new JLabel("Drinks");
		lblDrinks.setForeground(new Color(0, 0, 0));
		lblDrinks.setBackground(Color.RED);
		lblDrinks.setBounds(165, 65, 143, 55);
		lblDrinks.setFont(new Font("Tahoma", Font.BOLD, 34));
		contentPane.add(lblDrinks);
		
		
		JButton btnCoffee = new JButton("Hotdrinks\r\n");
		btnCoffee.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCoffee.setBounds(20, 166, 101, 43);
		contentPane.add(btnCoffee);
		btnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sides().setVisible(true);
				Main.frame.setVisible(false);
			}
		});
		
		JButton btnTea = new JButton("Cooldrinks");
		btnTea.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTea.setBounds(165, 166, 113, 43);
		contentPane.add(btnTea);
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sweets().setVisible(true);
				Main.frame.setVisible(false);
			}
		});
		
		JButton btnNewButton = new JButton("Spirits");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(310, 166, 108, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(102, 102, 102));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shruthi\\Desktop\\restscreenshots\\drinks1.jpg"));
		lblNewLabel.setBounds(0, 0, 534, 374);
		contentPane.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Desserts().setVisible(true);
				Main.frame.setVisible(false);
			}
		});
		
	}
}
