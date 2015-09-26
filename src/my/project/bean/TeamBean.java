package my.project.bean;

public class TeamBean {
private String name, captain,players;

public TeamBean(String name, String captain, String players) {
	super();
	this.name = name;
	this.captain = captain;
	this.players = players;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCaptain() {
	return captain;
}

public void setCaptain(String captain) {
	this.captain = captain;
}

public String getPlayers() {
	return players;
}

public void setPlayers(String players) {
	this.players = players;
}
}
