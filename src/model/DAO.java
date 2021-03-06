package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	
	
	//default do curso -> com.mysql.jdbc.Driver | Atualizado -> com.mysql.cj.jdbc.Driver  
	private String drive = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_agenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String passoword = "";
	
	Connection conexao = null;
	
	protected Connection conexao(){
		
		try {
			
			Class.forName(drive);
			conexao = DriverManager.getConnection(url, user, passoword);
			System.out.println("conectado");
			
		} catch (Exception e) {
			System.out.println("ERRO:" + e);
		}
		return conexao;
	}
	
	public void inserirContato(JavaBeans contato) {
		String sql = "insert into contatos (nome, tel, email) values (?, ?, ?);";
		
		try {
			//Criando a conex�o com o BD
			Connection com = conexao();
			//Preparando a strind de conexao
			PreparedStatement statement = com.prepareStatement(sql);
			
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getFone());
			statement.setString(3, contato.getEmail());
			
			//Executando a query
			statement.executeUpdate();
			com.close();
			
		} catch (Exception e) {
			System.out.println("ERRO: " + e);
		}
		
	}
	
	//Read dos contatos
	public ArrayList<JavaBeans> listarContatos(){
		ArrayList<JavaBeans> lista = new ArrayList<JavaBeans>();
		String sql = "select * from contatos order by nome;";
		try {
			
			Connection com = this.conexao();
			PreparedStatement statement = com.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				int id = result.getInt("id"); //O professor usou como String
				String nome  = result.getString("nome");
				String fone  = result.getString("tel");
				String email = result.getString("email");
				
				lista.add(new JavaBeans(id, nome, fone, email));	
			}
			com.close();
		} catch (Exception e) {
			System.out.println("ERRO: " + e);
			return null;
		}
		
		return lista;
	}
	
	//Delete dos contatos
	public boolean delContato(int id) {
		
		//Deletar um contato do BD
		String sql = "delete from contatos where id=?;";
		try {
			Connection com = this.conexao();
			PreparedStatement statement = com.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
			com.close();
		} catch (Exception e) {
			System.out.println("ERRO: " + e);
			return false;
		}
		return true;
	}
	
	
	public JavaBeans selectContato(int id) {
		JavaBeans contato = new JavaBeans();
		String sql = "select * from contatos where id = ?;";
		
		try {
			
			Connection com = this.conexao();
			PreparedStatement statement = com.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeQuery();
			
			ResultSet result = statement.getResultSet();
			
			while(result.next()) {
				
				contato.setId(result.getInt("id"));
				contato.setNome(result.getString("nome"));
				contato.setFone(result.getString("tel"));
				contato.setEmail(result.getString("email"));
			}
			com.close();
			
		} catch (Exception e) {
			System.out.println("ERRO: " + e);
		}
		return contato;
	}
	
	public boolean updContato(JavaBeans contato) {
		
		String sql = "update contatos set nome = ?, tel = ?, email = ? where id = ?;";
		
		try {
			
			Connection com = this.conexao();
			PreparedStatement statement = com.prepareStatement(sql);
			statement.setString(1, contato.getNome());
			statement.setString(2, contato.getFone());
			statement.setString(3, contato.getEmail());
			statement.setInt(4, contato.getId());
			statement.executeUpdate();
			
			com.close();
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: " + e);
			return false;
		}	
	}
}
