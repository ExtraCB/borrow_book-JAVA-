package DAO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.ConnectDB;
import model.Member_Model;

public class MemberDAO {
	
	
	public ArrayList<Member_Model> findAll(){
	ArrayList<Member_Model> mbmd = new ArrayList<Member_Model>();
	
	ConnectDB db = new ConnectDB();
	
	
	String sql = "SELECT * FROM tb_member";
	
	try {
		PreparedStatement stmt =  db.getCon().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Member_Model mm = new Member_Model(rs.getString("m_user"),rs.getString("m_pass"),rs.getString("m_name"),rs.getString("m_phone"));
			
			mbmd.add(mm);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return mbmd;
	}
	
}
