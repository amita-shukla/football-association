package my.project.model;

import my.project.bean.MatchBean;
import my.project.dao.DBConnector;

import java.sql.*;


public class Checker {
	private String  teamA,teamB,date;
	PreparedStatement ps;
	ResultSet rs;
	Connection con=DBConnector.getConnection();
	public Checker(MatchBean m) {
		this.teamA=m.getTeamA();
		this.teamB=m.getTeamB();
		this.date=m.getDate();
		
	}

	public Checker()
	{
		
		
	}


	public boolean checkDate() {
		try {
			ps = con.prepareStatement("select * from matches where teamA=? and teamB=? and date=?");
			ps.setString(1, teamA);
			ps.setString(2, teamB);
			ps.setString(3, date);
			rs= ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else{
				return false;	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public ResultSet checkUpdate(String name) {
		
		try {
			ps = con.prepareStatement("select * from team where TeamName=?");
			ps.setString(1, name);
			
			rs= ps.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
