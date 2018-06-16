package workflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import data.GameDetail;


public class GameWorkflow {

	public List<GameDetail> getAllGames() throws Exception{
		
		final List<String> dataArray = PlayerStatisticsCSVParser.parsePlayerStatisticsCSVFile();
		final Set<GameDetail> gameDetailsSet = new HashSet<>();
		
		for(final String data : dataArray){
			final GameDetail gameDetail = buildGameObject(data);
			gameDetailsSet.add(gameDetail); 
		}
		
		final List<GameDetail> gameDetailsList = new ArrayList<>(gameDetailsSet);
		
		return gameDetailsList;
		
	}
	
	private GameDetail buildGameObject(final String row) throws Exception{
		
		return new GameDetail( PlayerStatisticsCSVParser.getHomeTeam(row),
							   PlayerStatisticsCSVParser.getAwayTeam(row),
							   PlayerStatisticsCSVParser.getDateOfGame(row),
							   PlayerStatisticsCSVParser.getNBAYear(row),
							   PlayerStatisticsCSVParser.isPlayOffGame(row));
		 
	}
	 
	 
}
