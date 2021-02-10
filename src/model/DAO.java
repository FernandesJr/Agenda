package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	
	private Connection conexao = null;
	
	//default do curso -> com.mysql.jdbc.Driver | Atualizado -> com.mysql.cj.jdbc.Driver  
	private String drive = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_agenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String passoword = "";
	
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
}
