package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	/**Modelo de conex�o**/
	//parametros de conex�o
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "totvs!133121";
	
	//m�todo de conex�o
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**CRUD CREATE**/
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, fone, email) values (?,?,?)";
				try {
					// abrir a conex�o
					Connection con = conectar();
					// Praparar a query para execu��o no banco de dados
					PreparedStatement pst = con.prepareStatement(create);
					// Substituir os par�metros (?) pelo conte�do das vari�veis JavaBeans
					pst.setString(1, contato.getNome());
					pst.setString(2, contato.getFone());
					pst.setString(3, contato.getEmail());
					// Executar a query
					pst.executeUpdate();
					// Encerrar a conex�o com o banco
					con.close();

				} catch (Exception e) {
					System.out.println(e);
				}
	}
	
	
	
	
	
	/**teste de conex�o
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}**/
}
