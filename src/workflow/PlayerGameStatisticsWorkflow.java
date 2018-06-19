package workflow;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import config.CSVStatsColumns;
import config.StatisticsFile;
import constants.NBAYearEnum;
import constants.PositionEnum;
import constants.TeamEnum;
import constants.VenueEnum;
import csvparser.CSVExtractor;
import csvparser.CSVExtractorFactory;
import csvparser.CSVParser;
import csvparser.PlayerStatsCSVExtractor;
import data.PlayerGameStats;
import util.DateUtil;
import util.PositionsUtil;

public class PlayerGameStatisticsWorkflow {
	
	final private StatisticsFile statsFile;
	
	public PlayerGameStatisticsWorkflow(final StatisticsFile statsFile){
		this.statsFile = statsFile;
	}
	
	public List<PlayerGameStats> getAllPlayerGameStatisticsData() throws IOException{ 
		
		final CSVParser csvParser = new CSVParser(statsFile.getFile());
		
		final List<String> dataArray = csvParser.parseCSVFile();
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
		
		final CSVExtractor csvExtractor = CSVExtractorFactory.getCSVExtractor(statsFile.getFileType()); 
	 
		return new PlayerGameStats( csvExtractor.getFirstName(row),
								    csvExtractor.getLastName(row),
								    csvExtractor.getNBAYear(row), 
								    csvExtractor.getDateOfGame(row), 
								    csvExtractor.getOwnTeam(row),
								    csvExtractor.getOpponentTeam(row),
								    csvExtractor.getVenue(row),
									csvExtractor.getMinutesPlayed(row),
					 			    csvExtractor.getFieldGoalsMade(row),
							  	    csvExtractor.getFieldGoalsAttempted(row),
									csvExtractor.getThreePointersMade(row),
									csvExtractor.getThreePointersAttempted(row),
								    csvExtractor.getFreeThrowsMade(row),
								    csvExtractor.getFreeThrowsAttempted(row),
								    csvExtractor.getOffensiveRebounds(row),
								    csvExtractor.getDefensiveRebounds(row),
								    csvExtractor.getTotalRebounds(row),
									csvExtractor.getAssists(row),
									csvExtractor.getAssists(row),
									csvExtractor.getSteals(row),
									csvExtractor.getTurnOvers(row),
									csvExtractor.getBlocks(row),
									csvExtractor.getPoints(row) );
		 
		
	}
	
	
	
}
