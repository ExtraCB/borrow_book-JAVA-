package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book_Model;
import database.ConnectDB;

public class BookDAO {
	public ArrayList<Book_Model> findAll(){
		ArrayList<Book_Model> books = new ArrayList<Book_Model>();
		
		ConnectDB db = new ConnectDB();
		String sql = "SELECT * FROM tb_book";
		
		try {
			PreparedStatement pSTMT = db.getCon().prepareStatement(sql);
			ResultSet rs  = pSTMT.executeQuery();
			
			while(rs.next()) {
				Book_Model bkm = new Book_Model(rs.getString("b_id"),rs.getString("b_name"),rs.getString("b_writer"),rs.getInt("b_category"),rs.getInt("b_price"));
				
				books.add(bkm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	
	public Book_Model findOne(String search_book) {
		
		ConnectDB db = new ConnectDB();
		
		String sql = "SELECT * FROM tb_book WHERE b_id = ? OR b_name = ?";
		
		
		try {
			PreparedStatement stmt = db.getCon().prepareStatement(sql);
			stmt.setString(1, search_book);
			stmt.setString(2, search_book);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Book_Model bkm = new Book_Model(rs.getString("b_id"),rs.getString("b_name"),rs.getString("b_writer"),rs.getInt("b_category"),rs.getInt("b_price"));
				
				return bkm;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
