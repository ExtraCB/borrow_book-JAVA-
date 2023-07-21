package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectDB;
import model.Stats_Model;

public class StatsDAO {
	public ArrayList<Stats_Model> Get_stats(){
		ArrayList<Stats_Model> stats_model = new ArrayList<Stats_Model>();
		ConnectDB db = new ConnectDB();
		String sql1 = "SELECT COUNT(b_id) as Delayted FROM `tb_borrow_book` WHERE br_date_rt IS NULL;";
		
		String sql2 = "SELECT COUNT(b_id) as BookAll FROM tb_book;";
		
		String sql3 = "SELECT COUNT(m_user) as MemberAll FROM tb_member";
		
		String sql4 = "SELECT COUNT(br_date_br) as BorrowAll FROM `tb_borrow_book`";
		
		try {
			PreparedStatement stmt = db.getCon().prepareStatement(sql1);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Stats_Model stat_model = new Stats_Model("หนังสือค้างส่ง (เล่ม)",rs.getString("Delayted"));
				
				stats_model.add(stat_model);
			}
			
			
			PreparedStatement stmt2 = db.getCon().prepareStatement(sql2);
			ResultSet rs2 = stmt2.executeQuery();
			
			while(rs2.next()) {
				Stats_Model stat_model2 = new Stats_Model("หนังสือทั้งหมด (เล่ม)",rs2.getString("BookAll"));
				
				stats_model.add(stat_model2);
			}
			
			
			PreparedStatement stmt3 = db.getCon().prepareStatement(sql3);
			ResultSet rs3 = stmt3.executeQuery();
			
			while(rs3.next()) {
				Stats_Model stat_model3 = new Stats_Model("สมาชิกทั้งหมด(คน)",rs3.getString("MemberAll"));
				
				stats_model.add(stat_model3);
			}
			
			
			PreparedStatement stmt4 = db.getCon().prepareStatement(sql4);
			ResultSet rs4 = stmt4.executeQuery();
			
			while(rs4.next()) {
				Stats_Model stat_model4 = new Stats_Model("การยืมคืนหนังสือทังหมด(ครั้ง)",rs4.getString("BorrowAll"));
				
				stats_model.add(stat_model4);
			}
		} catch (SQLException e) {
			// จัดการข้อผิดพลาดที่เกิดขึ้น
			e.printStackTrace();
		} finally {
			// ปิดการเชื่อมต่อฐานข้อมูล
			db.closeConnect();
		}
		
		return stats_model;
	}
}
