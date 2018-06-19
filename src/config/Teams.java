package config;

import java.util.HashMap;
import java.util.Map;

import constants.TeamEnum;

public class Teams {
	
	// Remove file and put into database 
	
	private static Map<String, TeamEnum> TEAM_ALIASES = new HashMap<>();

	static{
		TEAM_ALIASES.put("Milwaukee", TeamEnum.Milwaukee);
		TEAM_ALIASES.put("OklahomaCity", TeamEnum.OklahomaCity);
		TEAM_ALIASES.put("Detroit", TeamEnum.Detroit);
		TEAM_ALIASES.put("Charlotte", TeamEnum.Charlotte);
		TEAM_ALIASES.put("Portland", TeamEnum.Portland);
		TEAM_ALIASES.put("GoldenState", TeamEnum.GoldenState);
		TEAM_ALIASES.put("Indiana", TeamEnum.Indiana);
		TEAM_ALIASES.put("Brooklyn", TeamEnum.Brooklyn);
		TEAM_ALIASES.put("Cleveland", TeamEnum.Cleveland);
		TEAM_ALIASES.put("Washington", TeamEnum.Washington);
		TEAM_ALIASES.put("Utah", TeamEnum.Utah);
		TEAM_ALIASES.put("LAClippers", TeamEnum.LAClippers);
		TEAM_ALIASES.put("Atlanta", TeamEnum.Atlanta);
		TEAM_ALIASES.put("NewYork", TeamEnum.NewYork);
		TEAM_ALIASES.put("Phoenix", TeamEnum.Phoenix);
		TEAM_ALIASES.put("Denver", TeamEnum.Denver);
		TEAM_ALIASES.put("Memphis", TeamEnum.Memphis);
		TEAM_ALIASES.put("Dallas", TeamEnum.Dallas);
		TEAM_ALIASES.put("Boston", TeamEnum.Boston);
		TEAM_ALIASES.put("LALakers", TeamEnum.LALakers);
		TEAM_ALIASES.put("Sacramento", TeamEnum.Sacramento);
		TEAM_ALIASES.put("Chicago", TeamEnum.Chicago);
		TEAM_ALIASES.put("NewOrleans", TeamEnum.NewOrleans);
		TEAM_ALIASES.put("Minnesota", TeamEnum.Minnesota);
		TEAM_ALIASES.put("Miami", TeamEnum.Miami);
		TEAM_ALIASES.put("SanAntonio", TeamEnum.SanAntonio);
		TEAM_ALIASES.put("Orlando", TeamEnum.Orlando);
		TEAM_ALIASES.put("Philadelphia", TeamEnum.Philadelphia);
		TEAM_ALIASES.put("Toronto", TeamEnum.Toronto);
		TEAM_ALIASES.put("Houston", TeamEnum.Houston);
		TEAM_ALIASES.put("nyk", TeamEnum.NewYork);
		TEAM_ALIASES.put("bkn", TeamEnum.Brooklyn);
		TEAM_ALIASES.put("mia", TeamEnum.Miami);
		TEAM_ALIASES.put("okc", TeamEnum.OklahomaCity);
		TEAM_ALIASES.put("bos", TeamEnum.Boston);
		TEAM_ALIASES.put("gsw", TeamEnum.GoldenState);
		TEAM_ALIASES.put("den", TeamEnum.Denver);
		TEAM_ALIASES.put("dal", TeamEnum.Dallas);
		TEAM_ALIASES.put("hou", TeamEnum.Houston);
		TEAM_ALIASES.put("lac", TeamEnum.LAClippers);
		TEAM_ALIASES.put("nor", TeamEnum.NewOrleans);
		TEAM_ALIASES.put("mil", TeamEnum.Milwaukee);
		TEAM_ALIASES.put("por", TeamEnum.Portland);
		TEAM_ALIASES.put("det", TeamEnum.Detroit);
		TEAM_ALIASES.put("min", TeamEnum.Minnesota);
		TEAM_ALIASES.put("sac", TeamEnum.Sacramento);
		TEAM_ALIASES.put("mem", TeamEnum.Memphis);
		TEAM_ALIASES.put("lal", TeamEnum.LALakers);
		TEAM_ALIASES.put("tor", TeamEnum.Toronto);
		TEAM_ALIASES.put("atl", TeamEnum.Atlanta);
		TEAM_ALIASES.put("cle", TeamEnum.Cleveland);
		TEAM_ALIASES.put("cha", TeamEnum.Charlotte);
		TEAM_ALIASES.put("ind", TeamEnum.Indiana);
		TEAM_ALIASES.put("uta", TeamEnum.Utah);
		TEAM_ALIASES.put("sas", TeamEnum.SanAntonio);
		TEAM_ALIASES.put("chi", TeamEnum.Chicago);
		TEAM_ALIASES.put("was", TeamEnum.Washington);
		TEAM_ALIASES.put("orl", TeamEnum.Orlando);
		TEAM_ALIASES.put("phi", TeamEnum.Philadelphia);
		TEAM_ALIASES.put("pho", TeamEnum.Phoenix);
		
		 
	}
	
	private Teams(){}
	
	public static TeamEnum getTeamByAlias(final String teamAlias) throws Exception{
		if(TEAM_ALIASES.containsKey(teamAlias)){
			return TEAM_ALIASES.get(teamAlias);
		}
		throw new Exception("Alias " + teamAlias + " doesn't exist");
	}
	


}
