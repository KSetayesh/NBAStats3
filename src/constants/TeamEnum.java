package constants;

public enum TeamEnum {
	
	Milwaukee("Milwaukee", "Bucks"),
	OklahomaCity("Oklahoma City", "Thunder"),
	Charlotte("Charlotte", "Bobcats"),
	Detroit("Detroit", "Pistons"),
	LAClippers("Los Angeles", "Clippers"),
	Portland("Portland", "TrailBlazers"),
	Indiana("Indiana", "Pacers"),
	LALakers("Los Angeles", "Lakers"),
	Brooklyn("Brooklyn", "Nets"),
	Cleveland("Cleveland", "Cavaliers"),
	Washington("Washington", "Wizards"),
	Utah("Utah", "Jazz"),
	Atlanta("Atlanta", "Hawks"),
	NewOrleans("New Orleans", "Pelicans"),
	Phoenix("Phoenix", "Suns"),
	Memphis("Memphis", "Grizzlies"),
	Denver("Denver", "Nuggets"),
	Dallas("Dallas", "Mavericks"),
	Boston("Boston", "Celtics"),
	NewYork("New York", "Knicks"),
	Sacramento("Sacramento", "Kings"),
	SanAntonio("San Antonio", "Spurs"),
	Chicago("Chicago", "Bulls"),
	Minnesota("Minnesota", "Timberwolves"),
	Miami("Miami", "Heat"),
	Orlando("Orlando", "Magic"),
	GoldenState("Golden State", "Warrors"),
	Philadelphia("Philadelphia", "76'ers"),
	Toronto("Toronto", "Raptors"),
	Houston("Houston", "Rockets");
	
	private final String cityName;
	private final String teamName;
	
	TeamEnum(final String cityName, final String teamName){
		this.cityName = cityName;
		this.teamName = teamName;
	}
	
	public String getCityName(){
		return cityName;
	}
	
	public String getTeamName(){
		return teamName;
	}
	
}
