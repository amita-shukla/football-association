package my.project.dao;

import my.project.bean.MatchBean;
import my.project.dao.DBConnector;
import my.project.model.Checker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao_matches  {

		private String teamA, teamB,date;
	
	public Dao_matches(String teamA, String teamB, String date)
	{
		this.teamA=teamA;
		this.teamB=teamB;
		this.date=date;		
	}
	
	public Dao_matches() {
		// TODO Auto-generated constructor stub
	}
	
	public Dao_matches(MatchBean mb) {
		this.teamA=mb.getTeamA();
		this.teamB=mb.getTeamB();
		this.date=mb.getDate();	
	}

	private Connection con=DBConnector.getConnection();
	private PreparedStatement ps;

	public String addMatch() {
		// TODO Auto-generated method stub
		try {
			ps= con.prepareStatement("insert into matches values (?,?,?,?)");
			ps.setString(1, teamA);
			ps.setString(2, teamB);
			ps.setString(3, date);
			ps.setString(4,"");
			int row=ps.executeUpdate();
			if(row>0)
			{
				return "Match Set!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL Exception.");
		}
		return "Error while fixing the match.";
	}	
	
	public String delMatch()
	{	MatchBean m = new MatchBean(teamA, teamB, date, null);
		Checker check = new Checker(m);
		Boolean rs=check.checkDate();
		if(rs){
			try {
		
			ps= con.prepareStatement("delete from matches where teamA=? and teamB=? and date=?");
			ps.setString(1, teamA);
			ps.setString(2, teamB);
			ps.setString(3, date);
			int row=ps.executeUpdate();
			if(row>0)
			{
				return "Match Deleted Successfully!";
			}
			else
			{
				return "Error in deletion";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL Exception.");
		}
		return "Error while deleting the match.";
		}
		else
		{
			return "Data Not Found";
		}
	}
	
}
