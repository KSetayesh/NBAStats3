package workflow;

import java.util.ArrayList; 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import config.StatisticsFile;
import csvparser.CSVExtractor;
import csvparser.CSVExtractorFactory;
import csvparser.CSVParser;
import data.GameDetail;


public class GameWorkflow {
	
	private final StatisticsFile statsFile;
	
	public GameWorkflow(final StatisticsFile statsFile){
		this.statsFile = statsFile;
	}

	public List<GameDetail> getAllGames() throws Exception{
		final CSVParser csvFile = new CSVParser(statsFile.getFile());
		final List<String> dataArray = csvFile.parseCSVFile();
		final Set<GameDetail> gameDetailsSet = new HashSet<>();
		
	 
		
		for(final String data : dataArray){
			final GameDetail gameDetail = buildGameObject(data);
			gameDetailsSet.add(gameDetail); 
		}
		
		
		
		final List<GameDetail> gameDetailsList = new ArrayList<>(gameDetailsSet);
		
		return gameDetailsList;
		
	}
	
	private GameDetail buildGameObject(final String row) throws Exception{
		final CSVExtractor csvExtractor = CSVExtractorFactory.getCSVExtractor(statsFile.getFileType());
		return new GameDetail( csvExtractor.getHomeTeam(row),
							   csvExtractor.getAwayTeam(row),
							   csvExtractor.getDateOfGame(row),
							   csvExtractor.getNBAYear(row),
							   csvExtractor.isPlayOffGame(row));
		 
	}
	
	 
	 
}
