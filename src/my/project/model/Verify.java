package my.project.model;
import my.project.dao.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Verify {

	public static boolean verifyUser(String username, String pass)
	{
		ResultSet rs = Dao.fetchCredentials();
		try {
			while(rs.next())
			{
				String u= rs.getString(1);
				String p=rs.getString(2);
				if(u.equals(username) && p.equals(pass))
				{
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean verifyMatch(String teamA, String teamB, String date)
	{
		ResultSet rs=Dao.fetchMatches();
		try {
			while(rs.next())
			{
				String team1= rs.getString(1);
				String team2=rs.getString(2);
				String dateOfMatch=rs.getString(3);
				if((team1.equals(teamA) && team2.equals(teamB) || (team1.equals(teamB) && team2.equals(teamA))) && dateOfMatch.equals(date))
				{
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
