package config;

import java.io.File;
import java.util.Date;
import java.util.Map;

import constants.NBAYearEnum;
import constants.TeamEnum;
import constants.VenueEnum;
import csvparser.CSVExtractor;
import csvparser.CSVExtractorFactory;

public class StatisticsFile {
	
	private final File file;
	private final FileTypeEnum fileType;
	private final Map<String, Integer> columnNameToIndexMap;
	private final CSVExtractor csvExtractor;
	
	public StatisticsFile(final File file,
						  final FileTypeEnum fileType,
						  final Map<String, Integer> columnNameToIndexMap) throws Exception{
		this.file = file;
		this.fileType = fileType;
		this.columnNameToIndexMap = columnNameToIndexMap;
		this.csvExtractor = CSVExtractorFactory.getCSVExtractor(fileType);
	}

	public File getFile() {
		return file;
	}

	public FileTypeEnum getFileType() {
		return fileType;
	}
	
	public int getIndexOfColumn(final String columnName){
		if(columnNameToIndexMap.containsKey(columnName)){
			return columnNameToIndexMap.get(columnName);
		}
		return -1;
	}
	
	public void printMap(){
		for(String columnName : columnNameToIndexMap.keySet()){
			System.out.println(columnName + " -> " + columnNameToIndexMap.get(columnName));
		}
	}
	
	public int getPlayerId(final String row){
		if(getIndexOfColumn(CSVStatsColumns.PLAYER_ID) == -1){
			return -1;
		}
	//	return csvExtractor.get(row);
		return -1;
	}
	
	public String getFirstName(final String row){
		if(getIndexOfColumn(CSVStatsColumns.FIRST_NAME) == -1){
			return "";
		}
		return csvExtractor.getFirstName(row);
	}
	
	public String getLastName(final String row){
		if(getIndexOfColumn(CSVStatsColumns.LAST_NAME) == -1){
			return "";
		}
		return csvExtractor.getLastName(row);
	}
	
	public NBAYearEnum getNBAYear(final String row) throws Exception{
		if(getIndexOfColumn(CSVStatsColumns.NBA_YEAR) == -1){
			return null;
		}
		return csvExtractor.getNBAYear(row);
	}
	
	public Date getDateOfGame(final String row) throws Exception{
		if(getIndexOfColumn(CSVStatsColumns.DATE_OF_GAME) == -1){
			return null;
		}
		return csvExtractor.getDateOfGame(row);
	}
	
	public TeamEnum getOwnName(final String row){
		if(getIndexOfColumn(CSVStatsColumns.OWN_TEAM) == -1){
			return null;
		}
		return csvExtractor.getOwnTeam(row);
	}
	
	public TeamEnum getOpposingTeam(final String row){
		if(getIndexOfColumn(CSVStatsColumns.OPPOSING_TEAM) == -1){
			return null;
		}
		return csvExtractor.getOpposingTeam(row);
	}
	
	public VenueEnum getVenue(final String row){
		if(getIndexOfColumn(CSVStatsColumns.VENUE) == -1){
			return null;
		}
		return csvExtractor.getVenue(row);
	}
	
	public double getMinutesPlayed(final String row){
		if(getIndexOfColumn(CSVStatsColumns.MINUTES_PLAYED) == -1){
			return -1;
		}
		return csvExtractor.getMinutesPlayed(row);
	}
	
	public int getFieldGoalsMade(final String row){
		if(getIndexOfColumn(CSVStatsColumns.FIELD_GOALS_MADE) == -1){
			return -1;
		}
		return csvExtractor.getFieldGoalsAttempted(row);
	}
	
	public int getFieldGoalsAttempted(final String row){
		if(getIndexOfColumn(CSVStatsColumns.FIELD_GOALS_ATTEMPTED) == -1){
			return -1;
		}
		return csvExtractor.getFieldGoalsAttempted(row);
	}
	
	public int getThreePointersMade(final String row){
		if(getIndexOfColumn(CSVStatsColumns.THREE_POINTERS_MADE) == -1){
			return -1;
		}
		return csvExtractor.getThreePointersMade(row);
	}
	
	public int getThreePointersAttempted(final String row){
		if(getIndexOfColumn(CSVStatsColumns.THREE_POINTERS_ATTEMPTED) == -1){
			return -1;
		}
		return csvExtractor.getThreePointersAttempted(row);
	}
	
	public int getFreeThrowsMade(final String row){
		if(getIndexOfColumn(CSVStatsColumns.FREE_THROWS_MADE) == -1){
			return -1;
		}
		return csvExtractor.getFreeThrowsMade(row);
	}
	
	public int getFreeThrowsAttempted(final String row){
		if(getIndexOfColumn(CSVStatsColumns.FREE_THROWS_ATTEMPTED) == -1){
			return -1;
		}
		return csvExtractor.getFreeThrowsAttempted(row);
	}
	
	public int getOffensiveRebounds(final String row){
		if(getIndexOfColumn(CSVStatsColumns.OFFENSIVE_REBOUNDS) == -1){
			return -1;
		}
		return csvExtractor.getOffensiveRebounds(row);
	}
	
	public int getDefensiveRebounds(final String row){
		if(getIndexOfColumn(CSVStatsColumns.DEFENSIVE_REBOUNDS) == -1){
			return -1;
		}
		return csvExtractor.getDefensiveRebounds(row);
	}
	
	public int getTotalRebounds(final String row){
		if(getIndexOfColumn(CSVStatsColumns.TOTAL_REBOUNDS) == -1){
			return -1;
		}
		return csvExtractor.getTotalRebounds(row);
	}
	
	public int getAssists(final String row){
		if(getIndexOfColumn(CSVStatsColumns.ASSISTS) == -1){
			return -1;
		}
		return csvExtractor.getAssists(row);
	}
	
	public int getPersonalFouls(final String row){
		if(getIndexOfColumn(CSVStatsColumns.PERSONAL_FOULS) == -1){
			return -1;
		}
		return csvExtractor.getPersonalFouls(row);
	}
	
	public int getSteals(final String row){
		if(getIndexOfColumn(CSVStatsColumns.STEALS) == -1){
			return -1;
		}
		return csvExtractor.getSteals(row);
	}
	
	public int getTurnOvers(final String row){
		if(getIndexOfColumn(CSVStatsColumns.TURNOVERS) == -1){
			return -1;
		}
		return csvExtractor.getTurnOvers(row);
	}
	
	public int getBlocks(final String row){
		if(getIndexOfColumn(CSVStatsColumns.BLOCKS) == -1){
			return -1;
		}
		return csvExtractor.getBlocks(row);
	}
	
	public int getPoints(final String row){
		if(getIndexOfColumn(CSVStatsColumns.POINTS) == -1){
			return -1;
		}
		return csvExtractor.getPoints(row);
	}

	@Override
	public String toString() {
		return "StatisticsFile [file=" + file + ", fileType=" + fileType + "]";
	}
	
}
