package workflow;

import java.util.List;

import config.ConfigHandler;
import config.StatisticsFile;
import data.GameDetail;
import data.PlayerGameStats;

public class Main {
	
	public static void main(String [] args) throws Exception{
		
		final ConfigHandler configHandler = ConfigHandler.getInstance();
		final List<StatisticsFile> statisticsFiles = configHandler.getStatisticsFile();
		
//		final DFSPlayerGameStatsWorkflow dfsPlayerGameStatsWorkflow = new DFSPlayerGameStatsWorkflow();
//		final Map<String, Integer> playerIds = dfsPlayerGameStatsWorkflow.getRotoGuruPlayerIds();

		for(final StatisticsFile statsFile : statisticsFiles){
			
			statsFile.printMap();
//			final GameWorkflow gameWorkflow = new GameWorkflow(statsFile);
//			final List<GameDetail> games = gameWorkflow.getAllGames();
//			
//			final PlayerGameStatisticsWorkflow pgsw = new PlayerGameStatisticsWorkflow(statsFile);
//			final List<PlayerGameStats> playerGameStats = pgsw.getAllPlayerGameStatisticsData();
			
		}
		
		
		
		
	}
	
	
	
}
