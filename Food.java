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
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class Food extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Food frame = new Food();
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
	public Food() {
		setTitle("Food");
		setForeground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblFood = new JLabel("FOOD");
		lblFood.setBounds(220, 11, 90, 72);
		lblFood.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblFood);
		JButton btnNewButton = new JButton("Mains");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(50, 120, 95, 44);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Mains().setVisible(true);
				Main.frame.setVisible(false);
			}});
		JButton btnNewButton_1 = new JButton("Sweets");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(82, 232, 115, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnStarters = new JButton("Starters\r\n");
		btnStarters.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnStarters.setBounds(204, 119, 106, 44);
		contentPane.add(btnStarters);
		
		JButton btnSides = new JButton("Sides");
		btnSides.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSides.setBounds(368, 120, 106, 44);
		contentPane.add(btnSides);
		
		JButton btnDesserts = new JButton("Desserts");
		btnDesserts.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDesserts.setBounds(281, 232, 115, 44);
		contentPane.add(btnDesserts);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Starters().setVisible(true);
				Main.frame.setVisible(false);
			}});
		}
}
