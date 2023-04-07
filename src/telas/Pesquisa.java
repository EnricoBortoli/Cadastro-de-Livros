package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.Livro;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Pesquisa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfPesquisar;
	private Livro livro = new Livro();
	private JTextField tfInicio;
	private JTextField tfFim;


	public static void main(String[] args) {
		try {
			Pesquisa dialog = new Pesquisa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pesquisa() {
		setResizable(false);
		setModal(true);
		setTitle("Tela de pesquisa");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblPesquisa = new JLabel("Insira a palavra a ser pesquisada");
		lblPesquisa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPesquisa.setBounds(10, 11, 213, 14);
		contentPanel.add(lblPesquisa);
		
		tfPesquisar = new JTextField();
		tfPesquisar.setBounds(10, 36, 269, 20);
		contentPanel.add(tfPesquisar);
		tfPesquisar.setColumns(10);
		
		JLabel lblMetodoPesquisa = new JLabel("Metodos de pesquisa:");
		lblMetodoPesquisa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMetodoPesquisa.setBounds(10, 77, 133, 14);
		contentPanel.add(lblMetodoPesquisa);
		
		JLabel lblPeriodo = new JLabel("Selecione o periodo desejado:");
		lblPeriodo.setEnabled(false);
		lblPeriodo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPeriodo.setBounds(10, 131, 178, 14);
		contentPanel.add(lblPeriodo);
		lblPeriodo.setVisible(false);
		
		tfInicio = new JTextField();
		tfInicio.setEnabled(false);
		tfInicio.setBounds(10, 156, 86, 20);
		contentPanel.add(tfInicio);
		tfInicio.setColumns(10);
		tfInicio.setVisible(false);
		
		tfFim = new JTextField();
		tfFim.setEnabled(false);
		tfFim.setBounds(137, 156, 86, 20);
		contentPanel.add(tfFim);
		tfFim.setColumns(10);
		tfFim.setVisible(false);
		
		JLabel lblAte = new JLabel("Até");
		lblAte.setEnabled(false);
		lblAte.setBounds(106, 159, 27, 14);
		contentPanel.add(lblAte);
		lblAte.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBox.getSelectedItem().toString().equals("Pesquisa por periodo")) {
					lblAte.setEnabled(true);
					tfInicio.setEnabled(true);
					tfFim.setEnabled(true);
					lblPeriodo.setEnabled(true);
					
					tfFim.setVisible(true);
					tfInicio.setVisible(true);
					lblPeriodo.setVisible(true);
					lblAte.setVisible(true);
				} else {
					lblAte.setEnabled(false);
					tfInicio.setEnabled(false);
					tfFim.setEnabled(false);
					lblPeriodo.setEnabled(false);
					
					tfFim.setVisible(false);
					tfInicio.setVisible(false);
					lblPeriodo.setVisible(false);
					lblAte.setVisible(false);
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setBounds(10, 98, 151, 22);
		contentPanel.add(comboBox);
		comboBox.addItem("-----");
		comboBox.addItem("Pesquisa por periodo");

		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equals("-----")) {
					livro.pesquisarNome(tfPesquisar.getText());
				} else if(comboBox.getSelectedItem().toString().equals("Pesquisa por periodo")){
					livro.pesquisarPorPeriodo(Integer.parseInt(tfInicio.getText()), Integer.parseInt(tfFim.getText()));
				}
			}
		});
		btnPesquisar.setBounds(335, 35, 89, 23);
		contentPanel.add(btnPesquisar);
		
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSair = new JButton("Sair");
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSair.setActionCommand("Cancel");
				buttonPane.add(btnSair);
			}
		}
	}
}
