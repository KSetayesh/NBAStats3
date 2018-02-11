package workflow;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import constants.NBAYearEnum;
import constants.PositionEnum;
import constants.TeamEnum;
import constants.VenueEnum;
import data.PlayerGameStats;
import util.DateUtil;
import util.PositionsUtil;

public class PlayerGameStatisticsWorkflow {
	
	public PlayerGameStatisticsWorkflow(){}
	
	public List<PlayerGameStats> getAllPlayerGameStatisticsData() throws IOException{ 
		
		final List<String> dataArray = PlayerStatisticsCSVParser.parsePlayerStatisticsCSVFile();
		final List<PlayerGameStats> playerGameStatsList = new ArrayList<>();
		
		int lineNumber = 1;
		for(final String row : dataArray){
			try{
				final PlayerGameStats playerGameStats = buildPlayerGameStatisticsRequestsObject(row);
				playerGameStatsList.add(playerGameStats);
				//System.out.println(playerGameStats.toString());
				//PlayerGameStatisticsDAO.insertPlayerGameStats(playerGameStats);
			}
			catch(Exception e){
				System.out.println(e.getMessage() + lineNumber);
			}
			finally{
				lineNumber++;
			}
		}
		
		return playerGameStatsList;
		
	}
	
	private PlayerGameStats buildPlayerGameStatisticsRequestsObject(final String row) throws Exception{
	  
		return new PlayerGameStats( PlayerStatisticsCSVParser.getFirstName(row),
								    PlayerStatisticsCSVParser.getLastName(row),
								    PlayerStatisticsCSVParser.getNBAYear(row), 
								    PlayerStatisticsCSVParser.getDateOfGame(row), 
								    PlayerStatisticsCSVParser.getOwnTeam(row),
								    PlayerStatisticsCSVParser.getOpponentTeam(row),
								    PlayerStatisticsCSVParser.getVenue(row),
									PlayerStatisticsCSVParser.getMinutesPlayed(row),
					 			    PlayerStatisticsCSVParser.getFieldGoalsMade(row),
							  	    PlayerStatisticsCSVParser.getFieldGoalsAttempted(row),
									PlayerStatisticsCSVParser.getThreePointersMade(row),
									PlayerStatisticsCSVParser.getThreePointersAttempted(row),
								    PlayerStatisticsCSVParser.getFreeThrowsMade(row),
								    PlayerStatisticsCSVParser.getFreeThrowsAttempted(row),
								    PlayerStatisticsCSVParser.getOffensiveRebounds(row),
								    PlayerStatisticsCSVParser.getDefensiveRebounds(row),
								    PlayerStatisticsCSVParser.getTotalRebounds(row),
									PlayerStatisticsCSVParser.getAssists(row),
									PlayerStatisticsCSVParser.getAssists(row),
									PlayerStatisticsCSVParser.getSteals(row),
									PlayerStatisticsCSVParser.getTurnOvers(row),
									PlayerStatisticsCSVParser.getBlocks(row),
									PlayerStatisticsCSVParser.getPoints(row) );
		 
		
	}
	
	
	
}
