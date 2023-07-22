package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectDB;
import model.*;

public class BorrowDAO {
	public ArrayList<Borrow_Model> findAll(){
		ArrayList<Borrow_Model> book_borrow = new ArrayList<Borrow_Model>();
		
		ConnectDB db = new ConnectDB();
		String sql = "SELECT tb_borrow_book.*, tb_book.b_name,tb_book.b_writer,tb_book.b_category,tb_book.b_price, tb_member.m_pass,tb_member.m_name,tb_member.m_phone\r\n"
				+ "FROM tb_borrow_book\r\n"
				+ "JOIN tb_book ON tb_borrow_book.b_id = tb_book.b_id\r\n"
				+ "JOIN tb_member ON tb_borrow_book.m_user = tb_member.m_user;";
		
		try {
			PreparedStatement pSTMT = db.getCon().prepareStatement(sql);
			ResultSet rs  = pSTMT.executeQuery();
			
			while(rs.next()) {
				
				Book_Model bkm = new Book_Model(rs.getString("b_id"),rs.getString("b_name"),rs.getString("b_writer"),rs.getInt("b_category"),rs.getInt("b_price"));
				Member_Model mmm = new Member_Model(rs.getString("m_user"), rs.getString("m_pass"), rs.getString("m_name"), rs.getString("m_phone"));
				
				Borrow_Model bmm = new Borrow_Model(rs.getString("br_date_br"), rs.getString("br_date_rt"), mmm, bkm,rs.getInt("br_fine"));
				
				book_borrow.add(bmm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book_borrow;
	}
	
	
	public ArrayList<Borrow_Model> find(String search){
		ArrayList<Borrow_Model> book_borrow = new ArrayList<Borrow_Model>();
		
		ConnectDB db = new ConnectDB();
		System.out.println(search);
		String sql = "SELECT tb_borrow_book.*, tb_book.b_name, tb_book.b_writer, tb_book.b_category, tb_book.b_price, tb_member.m_pass, tb_member.m_name, tb_member.m_phone "
		        + "FROM tb_borrow_book "
		        + "JOIN tb_book ON tb_borrow_book.b_id = tb_book.b_id "
		        + "JOIN tb_member ON tb_borrow_book.m_user = tb_member.m_user "
		        + "WHERE tb_member.m_name = ? OR tb_book.b_name = ?";
		try {
			PreparedStatement pSTMT = db.getCon().prepareStatement(sql);
			pSTMT.setString(1, search);
	        pSTMT.setString(2, search);
			ResultSet rs  = pSTMT.executeQuery();
			System.out.println("SQL : " + pSTMT);
			while(rs.next()) {
				
				Book_Model bkm = new Book_Model(rs.getString("b_id"),rs.getString("b_name"),rs.getString("b_writer"),rs.getInt("b_category"),rs.getInt("b_price"));
				Member_Model mmm = new Member_Model(rs.getString("m_user"), rs.getString("m_pass"), rs.getString("m_name"), rs.getString("m_phone"));
				
				Borrow_Model bmm = new Borrow_Model(rs.getString("br_date_br"), rs.getString("br_date_rt"), mmm, bkm,rs.getInt("br_fine"));
				
				book_borrow.add(bmm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book_borrow;
	}
	
	
	
	public int AddBorrow(String bid, String mid,String date) {
		int status = 0;
		
		String sql = "INSERT INTO `tb_borrow_book`(`br_date_br` ,`b_id`, `m_user`) VALUES (?,?,?)";
		ConnectDB db = new ConnectDB();
		
		
		try {
			PreparedStatement pSTMT = db.getCon().prepareStatement(sql);
			pSTMT.setString(1, date);
			pSTMT.setString(2, bid);
			pSTMT.setString(3, mid);
			
			
			System.out.println(pSTMT);
			
			status = pSTMT.executeUpdate();
			
			pSTMT.close();
			
			db.closeConnect();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	public ArrayList<Borrow_Model> findAllNotReturn(){
		ArrayList<Borrow_Model> book_borrow = new ArrayList<Borrow_Model>();
		
		ConnectDB db = new ConnectDB();
		String sql = "SELECT tb_borrow_book.*, tb_book.b_name,tb_book.b_writer,tb_book.b_category,tb_book.b_price, tb_member.m_pass,tb_member.m_name,tb_member.m_phone FROM tb_borrow_book\r\n"
				+ "JOIN tb_book ON tb_borrow_book.b_id = tb_book.b_id\r\n"
				+ "JOIN tb_member ON tb_borrow_book.m_user = tb_member.m_user\r\n"
				+ "WHERE tb_borrow_book.br_date_rt IS NULL;";
		
		try {
			PreparedStatement pSTMT = db.getCon().prepareStatement(sql);
			ResultSet rs  = pSTMT.executeQuery();
			
			while(rs.next()) {
				
				Book_Model bkm = new Book_Model(rs.getString("b_id"),rs.getString("b_name"),rs.getString("b_writer"),rs.getInt("b_category"),rs.getInt("b_price"));
				Member_Model mmm = new Member_Model(rs.getString("m_user"), rs.getString("m_pass"), rs.getString("m_name"), rs.getString("m_phone"));
				
				Borrow_Model bmm = new Borrow_Model(rs.getString("br_date_br"), rs.getString("br_date_rt"), mmm, bkm,rs.getInt("br_fine"));
				
				book_borrow.add(bmm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book_borrow;
	}
	
	
	public int ReturnEdit(String br_date_br,String fine,String br_date_rt,String b_id ,String m_id) {
		int status = 0;
		
		String sql = "UPDATE tb_borrow_book SET br_date_rt = ?,br_fine = ? WHERE br_date_br = ? AND b_id = ? AND m_user = ?";
		
		ConnectDB db = new ConnectDB();
		
		PreparedStatement stmt;
		try {
			stmt = db.getCon().prepareStatement(sql);
			stmt.setString(1, br_date_rt);
			stmt.setString(2, fine);
			stmt.setString(3, br_date_br);
			stmt.setString(4, b_id);
			stmt.setString(5, m_id);
			
			
			System.out.println(stmt);
			
			status = stmt.executeUpdate();
			
			stmt.close();
			
			db.closeConnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	
	public ArrayList<Borrow_Model> SearchAllNotReturn(String search){
		ArrayList<Borrow_Model> book_borrow = new ArrayList<Borrow_Model>();
		
		ConnectDB db = new ConnectDB();
		String sql = "SELECT tb_borrow_book.*, tb_book.b_name,tb_book.b_writer,tb_book.b_category,tb_book.b_price, tb_member.m_pass,tb_member.m_name,tb_member.m_phone FROM tb_borrow_book\r\n"
				+ "JOIN tb_book ON tb_borrow_book.b_id = tb_book.b_id\r\n"
				+ "JOIN tb_member ON tb_borrow_book.m_user = tb_member.m_user\r\n"
				+ "WHERE tb_borrow_book.br_date_rt IS NULL AND tb_member.m_name = ? OR tb_book.b_name = ?";
		
		try {
			PreparedStatement pSTMT = db.getCon().prepareStatement(sql);
			pSTMT.setString(1, search);
	        pSTMT.setString(2, search);
			ResultSet rs  = pSTMT.executeQuery();
			
			while(rs.next()) {
				
				Book_Model bkm = new Book_Model(rs.getString("b_id"),rs.getString("b_name"),rs.getString("b_writer"),rs.getInt("b_category"),rs.getInt("b_price"));
				Member_Model mmm = new Member_Model(rs.getString("m_user"), rs.getString("m_pass"), rs.getString("m_name"), rs.getString("m_phone"));
				
				Borrow_Model bmm = new Borrow_Model(rs.getString("br_date_br"), rs.getString("br_date_rt"), mmm, bkm,rs.getInt("br_fine"));
				
				book_borrow.add(bmm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book_borrow;
	}
}
