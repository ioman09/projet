package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class BateauRepo {

	public static List<String> findAll(){
		MysqlDataSource ds = new MysqlDataSource();
		String bat ="bat";
		String pass = "password";
		String url = "jdbc:mysql://localhost:3306/blabla?useSSL=false&serverTimezone=Europe/Paris";
		ds.setUrl(url);
		ds.setUser(bat);
		ds.setPassword(pass);
		try(
		Connection connexion = ds.getConnection();
		Statement st = connexion.createStatement();
		ResultSet res = st.executeQuery("SELECT * FROM blabla;");
		){
		List<String> blabla = new ArrayList<String>();	
		while (res.next()) {
			blabla.add(res.getString("nom"));
		}
		return blabla;
		}catch (SQLException e) {
			System.out.println("Erreur lecture MySQL : " + e.getMessage() );
		return Collections.singletonList(e.getMessage());
		}
	}
}
