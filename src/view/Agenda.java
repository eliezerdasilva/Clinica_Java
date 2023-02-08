package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controler.AgendaController;

import javax.swing.JScrollPane;

public class Agenda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField txtValor;
	private JTextField txtData;
	private JTextField txtHora;
	private AgendaController controler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		controler = new AgendaController(this);
		Iniciar();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 598, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(66, 27, 184, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setBounds(10, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox CbxCliente = new JComboBox();
		CbxCliente.setBounds(66, 58, 184, 22);
		contentPane.add(CbxCliente);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setBounds(10, 66, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setBounds(66, 233, 437, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(260, 25, 274, 197);
		contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 277, 451, 108);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Cliente", "Servi\u00E7o", "Valor", "Hora", "Data", "Observacao"
			}
		));
		
		JComboBox ComboxServiço = new JComboBox();
		ComboxServiço.setBounds(66, 91, 184, 22);
		contentPane.add(ComboxServiço);
		
		txtValor = new JTextField();
		txtValor.setBounds(66, 124, 184, 22);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		txtData = new JTextField();
		txtData.setBounds(66, 157, 184, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(66, 188, 184, 20);
		contentPane.add(txtHora);
		txtHora.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Serviço");
		lblNewLabel_2.setBounds(10, 95, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Valor");
		lblNewLabel_3.setBounds(23, 128, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Data");
		lblNewLabel_4.setBounds(23, 157, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hora");
		lblNewLabel_5.setBounds(23, 191, 46, 14);
		contentPane.add(lblNewLabel_5);
	}

	private void Iniciar() {
		controler.atualizaTabela();
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
}
