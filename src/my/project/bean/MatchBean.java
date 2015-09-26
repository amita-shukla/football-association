package my.project.bean;

public class MatchBean {
private String teamA, teamB,date,result;

public MatchBean(String teamA, String teamB, String date, String result) {
	super();
	this.teamA = teamA;
	this.teamB = teamB;
	this.date = date;
	this.result = result;
}

public String getTeamA() {
	return teamA;
}

public void setTeamA(String teamA) {
	this.teamA = teamA;
}

public String getTeamB() {
	return teamB;
}

public void setTeamB(String teamB) {
	this.teamB = teamB;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getResult() {
	return result;
}

public void setResult(String result) {
	this.result = result;
}

}
