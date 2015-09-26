package my.project.dao;

import my.project.bean.TeamBean;
import my.project.dao.DBConnector;
import my.project.model.Checker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

	static Connection con= DBConnector.getConnection();
	static PreparedStatement ps;
	
	private String team_name,captain,members;
	
	public Dao()
	{
		
	}
	
	public Dao(TeamBean tb) {
		team_name=tb.getName();
		this.captain=tb.getCaptain();
		this.members=tb.getPlayers();
	}
	
	public static ResultSet fetchCredentials()
	{
		ResultSet rs=null;
		
		try {
			ps=con.prepareStatement("Select username, password from user");
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	

	public static ResultSet fetchMatches()
	{
		ResultSet rs=null;
		
		try {
			ps= con.prepareStatement("select teamA, teamB, date from matches");
			rs =ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Sql exception in fetchMatches()");
		}
		return rs;
	}
	
	public static boolean uploadResult(String teamA, String teamB, String result)
	{
		 try {
			ps = con.prepareStatement("update matches set result=? where teamA in(?,?) and teamB in(?,?)");
			ps.setString(1, result);
			ps.setString(2, teamA);
			ps.setString(3, teamB);
			ps.setString(4, teamB);
			ps.setString(5, teamA);
			
			int rowNum=ps.executeUpdate();
			if (rowNum==1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return false;
	}
	
	public static ResultSet teamNames()
	{
		ResultSet rs=null;
		
		try {
			ps= con.prepareStatement("select TeamName from team ");
		
			 rs =ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet teamDetails(String teamName)
	{
		ResultSet rs=null;
		
		try {
			ps= con.prepareStatement("select * from team where TeamName=?");
		
				ps.setString(1,teamName);
			
			 rs =ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet upcomingMatches()
	{
		ResultSet rs=null;
		
		try {
			ps= con.prepareStatement("select teamA, teamB, date from matches where date>curdate()");		
			 rs =ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;	
	}
	
	public String addTeam()
	{
		try {
			ps=con.prepareStatement("insert into team values(?,?,?)");
			ps.setString(1, team_name);
			ps.setString(2, captain);
			ps.setString(3, members);
			int row=ps.executeUpdate();
			if(row>0){
			return "Team added Successfully";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL Exception");
		}
		return "Error Occured While adding Team details into Database";
	}
	
	public String updateTeam() {
		try {
			ps=con.prepareStatement("update team set captain=?,PlayersList=? where TeamName=?");
			ps.setString(3, team_name);
			ps.setString(1, captain);
			ps.setString(2, members);
			int row=ps.executeUpdate();
			if(row>0){
			return "Team Updated Successfully";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SQL Exception");
		}
		return "Error Occured While Updating Team details into Database";
	}
	
	public String delTeam(String name)
	{	ResultSet rs = null;
	int rowno;
		Checker check = new Checker();
		rs=check.checkUpdate(name);
		try {
			while(rs.next())
			{
				ps=con.prepareStatement("delete from team where TeamName=?");
				ps.setString(1, name);
				rowno=ps.executeUpdate();
				if(rowno>0)
				{
					return "Deleted Successfully";
				}
				else
				{
					return "Error in Deletion";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return "SQL Exception";
		}
		return "Error in Deletion";
	}
/*
	public static ResultSet displayDetails(String username)
	{
		
			
			ResultSet rs=null;
			
			try {
				ps= con.prepareStatement("select name, codename, designation, dob from agent where username=? ");
			
					ps.setString(1,username);
				
				 rs =ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		
	}
	*/
}
