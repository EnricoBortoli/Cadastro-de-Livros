
package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedWriter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import io.Livro;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfTitulo;
	private JTextField tfCategoria;
	private JTextField tfAutor;
	private JTextField tfAno;
	private JTextField tfNPaginas;
	private JTextArea txtResenha;


	public static void main(String[] args) {
		try {
			Cadastro dialog = new Cadastro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cadastro() {
		setTitle("Cadastro");
		setModal(true);
		setBounds(100, 100, 467, 338);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitulo.setBounds(20, 23, 78, 14);
		contentPanel.add(lblTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(108, 20, 312, 20);
		contentPanel.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategoria.setBounds(20, 54, 78, 14);
		contentPanel.add(lblCategoria);
		
		tfCategoria = new JTextField();
		tfCategoria.setColumns(10);
		tfCategoria.setBounds(108, 51, 147, 20);
		contentPanel.add(tfCategoria);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAutor.setBounds(20, 82, 46, 14);
		contentPanel.add(lblAutor);
		
		tfAutor = new JTextField();
		tfAutor.setColumns(10);
		tfAutor.setBounds(108, 79, 147, 20);
		contentPanel.add(tfAutor);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAno.setBounds(265, 54, 46, 14);
		contentPanel.add(lblAno);
		
		tfAno = new JTextField();
		tfAno.setColumns(10);
		tfAno.setBounds(331, 51, 89, 20);
		contentPanel.add(tfAno);
		
		JLabel lblNPaginas = new JLabel("N\u00BA Paginas");
		lblNPaginas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNPaginas.setBounds(265, 82, 78, 14);
		contentPanel.add(lblNPaginas);
		
		tfNPaginas = new JTextField();
		tfNPaginas.setColumns(10);
		tfNPaginas.setBounds(331, 79, 89, 20);
		contentPanel.add(tfNPaginas);
		
		JLabel lblResenha = new JLabel("Resenha");
		lblResenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResenha.setBounds(20, 107, 78, 14);
		contentPanel.add(lblResenha);
		
		txtResenha = new JTextArea();
		txtResenha.setWrapStyleWord(true);
		txtResenha.setLineWrap(true);
		txtResenha.setBounds(20, 132, 400, 88);
		contentPanel.add(txtResenha);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfTitulo.getText().isEmpty() || tfAutor.getText().isEmpty() 
						|| tfCategoria.getText().isEmpty() || tfAno.getText().isEmpty() 
						|| tfNPaginas.getText().isEmpty() || txtResenha.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
				}else {
					chamaGravaRegistro();
				};
			}
		});
		btnSalvar.setBounds(20, 231, 89, 23);
		contentPanel.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(144, 231, 89, 23);
		contentPanel.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(331, 231, 89, 23);
		contentPanel.add(btnSair);
		setResizable(false);
		btnSair.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				dispose();
			} 
		});
	}
	
	public void chamaGravaRegistro() {
		Livro novoLivro = new Livro();
		try{
			novoLivro.setTitulo(tfTitulo.getText());
			novoLivro.setCategoria(tfCategoria.getText());
			novoLivro.setAutor(tfAutor.getText());
			novoLivro.setResenha(txtResenha.getText());
			novoLivro.setnPaginas(Integer.parseInt(tfNPaginas.getText()));
			novoLivro.setAno(Integer.parseInt(tfAno.getText()));
			novoLivro.gravaRegistro();
			limpar();
		}catch (NumberFormatException nEx){
			String mensagem = nEx.getMessage();
			JOptionPane.showMessageDialog(null, "Os campos 'Ano' e 'Numero de paginas' aceitam apenas n�meros");
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage()); 
		}
	}
	
	public void limpar() {
		tfTitulo.setText("");
		tfCategoria.setText("");
		tfAutor.setText("");
		txtResenha.setText("");
		tfNPaginas.setText("");
		tfAno.setText("");
	}
}
