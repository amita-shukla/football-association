package my.project.bean;

public class Matches {
	private String teamA;
	private String teamB;
	private String date;
	
	public Matches(String teamA, String teamB, String date){
		this.teamA=teamA;
		this.teamB=teamB;
		this.date=date;
	}
	//Matches()
	//{}
	public String getTeamA() {
		return teamA;
	}
	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}
	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTeamB() {
		return teamB;
	}
	public String getDate() {
		return date;
	}
}
