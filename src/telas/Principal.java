package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuArquivo = new JMenu("Arquivo");
		menuBar.add(MenuArquivo);
		
		JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
		mntmPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisa pesquisa = new Pesquisa();
				pesquisa.setVisible(true);
			}
		});
		mntmPesquisar.setIcon(new ImageIcon("imagens/pesquisa.png"));
		MenuArquivo.add(mntmPesquisar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible(true);
			}
		});
		mntmCadastrar.setIcon(new ImageIcon("imagens/Cadastrar.png"));
		MenuArquivo.add(mntmCadastrar);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setIcon(new ImageIcon("imagens/sair.png"));
		MenuArquivo.add(mntmSair);
		mntmSair.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent arg0) { System.exit(0);} });
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagens/principal.png"));
		lblNewLabel.setBounds(37, 88, 300, 300);
		contentPane.add(lblNewLabel);
		
		JLabel lblCadastrodeBiblioteca = new JLabel("Cadastro de Biblioteca");
		lblCadastrodeBiblioteca.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCadastrodeBiblioteca.setBounds(376, 88, 318, 73);
		contentPane.add(lblCadastrodeBiblioteca);
	}
}
