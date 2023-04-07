package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class Livro {
	
	private String titulo;
	private String autor;
	private String categoria;
	private int ano;
	private int nPaginas;
	private String resenha;
	
	

	
	public Livro(String titulo, String autor, String categoria, int ano, int nPaginas, String resenha) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.ano = ano;
		this.nPaginas = nPaginas;
		this.resenha = resenha;
	}

	public Livro() {
		super();
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getnPaginas() {
		return nPaginas;
	}

	public void setnPaginas(int nPaginas) {
		this.nPaginas = nPaginas;
	}

	public String getResenha() {
		return resenha;
	}

	public void setResenha(String resenha) {
		this.resenha = resenha;
	}
	
	

	@Override
	public String toString() {
		return titulo + ";" + autor + ";" + categoria + ";" + ano
				+ ";" + nPaginas + ";" + resenha;
	}

	public void gravaRegistro() {
		try {
			FileWriter fw = new FileWriter("./registroLivros.txt", true);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(this.toString(), 0, this.toString().length());
			writer.newLine();
			writer.close();
			fw.close();
			JOptionPane.showMessageDialog(null, "Livro salvo com sucesso!"); 
		}catch(FileNotFoundException fnfe){
			JOptionPane.showMessageDialog(null, "Arquivo n�o encontrado");
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Problemas de leitura no arquivo de livros");
		}
	}
	
	public void pesquisarPorPeriodo(int inicio, int fim) {
		try {
			FileReader fr = new FileReader("./registroLivros.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        boolean found = false;
	        
	        while((line = br.readLine()) != null) {
	        	
	        	String[] fields = line.split(";");
	            int ano = Integer.parseInt(fields[3]);
	        	
	        	if(ano >= inicio && ano <= fim){
		        	String titulo = fields[0];
		            String autor = fields[1];
		            String categoria = fields[2];
		            String nPaginas = fields[4];
		            String resenha = fields[5];
	        		JOptionPane.showMessageDialog(null, "Livro encontrado:\n" + "Titulo: " + titulo + "\nAutor: " + autor 
	                		+ "\nCategoria: " + categoria + "\nAno: " + ano + "\nNúmero de paginas: " + nPaginas + "\nResenha: " + resenha);
	                found = true;
	        	}
	        }
	        if (!found) {
	            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
	        }
	        br.close();
	        fr.close();
	        
		} catch (FileNotFoundException fnfe) {
	        JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Problemas de leitura no arquivo de livros.");
	    }
	}
	
	
	
	public void pesquisarNome(String nome) {
	    try {
	        FileReader fr = new FileReader("./registroLivros.txt");
	        BufferedReader br = new BufferedReader(fr);
	        String line;
	        boolean found = false;
	        while ((line = br.readLine()) != null) {
	            if (line.contains(nome)) {
	                String[] fields = line.split(";");
	                String titulo = fields[0];
	                String autor = fields[1];
	                String categoria = fields[2];
	                String ano = fields[3];
	                String nPaginas = fields[4];
	                String resenha = fields[5];
	                JOptionPane.showMessageDialog(null, "Livro encontrado:\n" + "Titulo: " + titulo + "\nAutor: " + autor 
	                		+ "\nCategoria: " + categoria + "\nAno: " + ano + "\nNúmero de paginas: " + nPaginas + "\nResenha: " + resenha);
	                found = true;
	            }
	        }
	        if (!found) {
	            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
	        }
	        br.close();
	        fr.close();
	    } catch (FileNotFoundException fnfe) {
	        JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "Problemas de leitura no arquivo de livros.");
	    }
	}
}
