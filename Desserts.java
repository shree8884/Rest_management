package restaurant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Desserts extends JFrame {
	 public static final String SOURCE = "./src/main/resources/data/";
	 public static final String RESTAURANT_NS= "http://www.semanticweb.org/shruthi/ontologies/2020/11/untitled-ontology-87";

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 * 
	 */
	//public static Cake frame = new  Cake();
	private JScrollPane sp=new JScrollPane();
	
	public static Desserts frame = new  Desserts();
	private JTextField txtByName;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	Cake frame = new Cake();
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Desserts() {
		setTitle("DESSERT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 423);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(153, 102, 51));
		contentPane.setBackground(new Color(204, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(442, 183, 57, 51);
		contentPane.add(btnNewButton);
		//JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(456, 177, 140, 51);
		btnNewButton.setFocusPainted(false);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String RESTAURANT = txtByName.getText().toString().toLowerCase();
				OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
				//read ontology model
				FileManager.get().readModel( m, SOURCE + "coffee.owl" );
				
				String prefix = "prefix fc: <" + RESTAURANT_NS + ">\n" +
		                		"prefix rdfs: <" + RDFS.getURI() + ">\n" +
		                		"prefix owl: <" + OWL.getURI() + ">\n";
				
				String query_text=  prefix +
					
						"SELECT ?name  \r\n" +
						 "  WHERE { ?x a fc:Sweets. ?x fc:name ?name. \r\n}";
				System.out.println(query_text);
					Query query = QueryFactory.create( query_text );
		        QueryExecution qexec = QueryExecutionFactory.create( query, m );
		       
		        /*************************************** Create Arrays for Table Headers and Table Values **********************************/ 
		        List<String> columns = new ArrayList<String>();
		        List<String[]> values = new ArrayList<String[]>();
		        columns.add("name");
		   
	            /*******************************************************************************************************************************/
		       try {
		            ResultSet results = qexec.execSelect();
		            int i = 0;
		            while ( results.hasNext() ) {
		                QuerySolution qs = results.next();     
		                /****************************  Assign query data to array. That will populate JTable **************************/
		                values.add(new String[] {qs.get("spicelevel").toString()});
		               /**************************************************************************************************************/
		                
		                System.out.println(qs.get("spicelevel"));
		                i++;
		            }
		            
		         /*************************Create Table and tableModel******************************/
		            TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
		            JTable table = new JTable(tableModel);
		            table.setForeground(Color.DARK_GRAY);
		            table.setBackground(Color.WHITE);
		            table.setRowHeight(35);
		           sp.setViewportView(table);		           
		            sp.setBounds(60, 250, 570, 317);
		         contentPane.add(sp);
		            contentPane.repaint();
		          /*********************************************************************************/
		        }
		        finally {
		            qexec.close();
		        }

			}
		});
		
		contentPane.setLayout(null);
		btnNewButton.setPreferredSize(new Dimension(350, 45));
		contentPane.add(btnNewButton);
		
		txtByName = new JTextField();
		txtByName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtByName.setToolTipText("Enter Name");
		txtByName.setBounds(407, 89, 215, 36);
		contentPane.add(txtByName);
		txtByName.setColumns(10);
		
		JLabel lblCake = new JLabel("DESSERT");
		lblCake.setForeground(Color.WHITE);
		lblCake.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCake.setBounds(456, 23, 140, 36);
		contentPane.add(lblCake);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shruthi\\Desktop\\restscreenshots\\dessert1.jpg"));
		lblNewLabel.setBounds(0, 0, 644, 384);
		contentPane.add(lblNewLabel);
		
	}
}
