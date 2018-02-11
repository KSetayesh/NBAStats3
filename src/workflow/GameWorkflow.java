package workflow;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.GameDetail;


public class GameWorkflow {

	public Map<String, GameDetail> getAllGames() throws Exception{
		
		final List<String> dataArray = PlayerStatisticsCSVParser.parsePlayerStatisticsCSVFile();
		final Map<String, GameDetail> gameDetailsMap = new HashMap<>();
		
		for(final String data : dataArray){
			final GameDetail gameDetail = buildGameObject(data);
			final String dateOfGame = createDateKey(gameDetail.getDate());
			gameDetailsMap.put(dateOfGame, gameDetail); 
		}
		
		return gameDetailsMap;
		
	}
	
	private GameDetail buildGameObject(final String row) throws Exception{
		
		return new GameDetail( PlayerStatisticsCSVParser.getHomeTeam(row),
							   PlayerStatisticsCSVParser.getAwayTeam(row),
							   PlayerStatisticsCSVParser.getDateOfGame(row),
							   PlayerStatisticsCSVParser.getNBAYear(row),
							   PlayerStatisticsCSVParser.isPlayOffGame(row));
		 
	}
	
	private String createDateKey(final Date dateOfGame){ 
		return dateOfGame.toString();
		
	}
	 
}
