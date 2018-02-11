package workflow;

import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import constants.NBAYearEnum;
import constants.PositionEnum;
import constants.TeamEnum;
import constants.VenueEnum;
import util.DateUtil;

public class PlayerStatisticsCSVParser {

	private static final String FILEPATH = "/Users/Kevin_Setayesh/Desktop/2014-2016 NBA Player Data/NBA-2014-2015-Player-BoxScore-Dataset/2014-2015-Table 1.csv";
	private static final String PLAYOFFS = "Playoffs";
	
	private final static int NBA_YEAR_INDEX = 0;
	private final static int DATE_OF_GAME_INDEX = 1;
	private final static int NAME_INDEX = 2;
	private final static int POSITION_INDEX = 3;
	private final static int OWN_TEAM_INDEX = 4;
	private final static int OPPONENT_TEAM_INDEX = 5;
	private final static int VENUE_INDEX = 6;
	private final static int MINUTES_PLAYED_INDEX = 7;
	private final static int FIELD_GOALS_MADE_INDEX = 8;
	private final static int FIELD_GOALS_ATTEMPTED_INDEX = 9;
	private final static int THREE_POINTERS_MADE_INDEX = 10;
	private final static int THREE_POINTERS_ATTEMPTED_INDEX = 11;
	private final static int FREE_THROWS_MADE_INDEX = 12;
	private final static int FREE_THROWS_ATTEMPTED_INDEX = 13;
	private final static int OFFENSIVE_REBOUNDS_INDEX = 14;
	private final static int DEFENSIVE_REBOUNDS_INDEX = 15;
	private final static int TOTAL_REBOUNDS_INDEX = 16;
	private final static int ASSISTS_INDEX = 17;
	private final static int PERONAL_FOULS_INDEX = 18;
	private final static int STEALS_INDEX = 19;
	private final static int TURNOVERS_INDEX = 20;
	private final static int BLOCKS_INDEX = 21;
	private final static int POINTS_INDEX = 22;
	
	
	private PlayerStatisticsCSVParser(){}
	
	public static List<String> parsePlayerStatisticsCSVFile() throws IOException{
		final List<String> playerGameStatsList = new ArrayList<String>();
		final FileReader fr = new FileReader(FILEPATH);
		final BufferedReader br = new BufferedReader(fr);
		
		int lineNumber = 0;
		String currentLine = "";
		while ((currentLine = br.readLine()) != null) {
			lineNumber++;
			if (lineNumber == 1){
				continue;
			}
			playerGameStatsList.add(currentLine);
			
		}
		
		fr.close();
		br.close();
		
		return playerGameStatsList;
	}
	
	public static String [] splitArray(final String row){
		return row.split(",");
	}
	
	public static boolean isPlayOffGame(final String row){
		return splitArray(row)[NBA_YEAR_INDEX].contains(PLAYOFFS);
	}
	
	public static NBAYearEnum getNBAYear(final String row) throws Exception{
		return DateUtil.getNBAYear(splitArray(row)[NBA_YEAR_INDEX]);
	}
	
	public static Date getDateOfGame(final String row) throws ParseException{
		return DateUtil.getDateOfGame(splitArray(row)[DATE_OF_GAME_INDEX]);
	}
	
	public static String getFirstName(final String row) {
		final String data = splitArray(row)[NAME_INDEX];

		String firstName = "";
		try {
			if ("Nene".equals(data)) {
				return data;
			}
			firstName = data.substring(0, data.lastIndexOf(" "));
		} catch (Exception e) {
			System.out.println("error found with the following first name: " + data);
		}

		return firstName;
	}
	
	public static String getLastName(final String row) {
		final String data = splitArray(row)[NAME_INDEX];
		String lastName = "";
		try {
			lastName = data.substring(data.lastIndexOf(" ") + 1);
		} catch (Exception e) {
			System.out.println("error found with the following last name: " + data);
		}

		return lastName;
	}
	
	public static Set<PositionEnum> getPositions(final String row){
		final String data = splitArray(row)[POSITION_INDEX];
		final Set<PositionEnum> positions = new HashSet<PositionEnum>();
		if(data.equals("F") || (data.equals("SF-PF"))){
			positions.add(PositionEnum.SF);
			positions.add(PositionEnum.PF);
		}
		else if(data.equals("G")){
			positions.add(PositionEnum.PG);
			positions.add(PositionEnum.SG);
		}
		else if(data.equals("F-C")){
			positions.add(PositionEnum.SF);
			positions.add(PositionEnum.PF);
			positions.add(PositionEnum.C);  
		}
		else if(data.equals("G-F")){
			positions.add(PositionEnum.PG);
			positions.add(PositionEnum.SG); 
			positions.add(PositionEnum.SF);
			positions.add(PositionEnum.PF);
		} 
		else{
			positions.add(PositionEnum.valueOf(data));
		}
		return positions;
	}
	
	public static TeamEnum getOwnTeam(final String row){
		final String data = splitArray(row)[OWN_TEAM_INDEX];
		return getTeam(data);
	}
	
	public static TeamEnum getOpponentTeam(final String row){
		final String data = splitArray(row)[OPPONENT_TEAM_INDEX];
		return getTeam(data);
	}
	
	public static VenueEnum getVenue(final String row){
		final String data = splitArray(row)[VENUE_INDEX];
		return VenueEnum.valueOf(data);
	}
	
	public static TeamEnum getHomeTeam(final String row){
		VenueEnum venueEnum = getVenue(row);
		if(venueEnum.equals(VenueEnum.H)){
			return getOwnTeam(row);
		}
		return getOpponentTeam(row);
		
	}
	
	public static TeamEnum getAwayTeam(final String row){
		VenueEnum venueEnum = getVenue(row);
		if(venueEnum.equals(VenueEnum.R)){
			return getOwnTeam(row);
		}
		return getOpponentTeam(row);
		
	}
	
	public static double getMinutesPlayed(final String row){
		final String data = splitArray(row)[MINUTES_PLAYED_INDEX];
		return Double.parseDouble(data);
	}
	
	public static int getFieldGoalsMade(final String row){
		final String data = splitArray(row)[FIELD_GOALS_MADE_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getFieldGoalsAttempted(final String row){
		final String data = splitArray(row)[FIELD_GOALS_ATTEMPTED_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getThreePointersMade(final String row){
		final String data = splitArray(row)[THREE_POINTERS_MADE_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getThreePointersAttempted(final String row){
		final String data = splitArray(row)[THREE_POINTERS_ATTEMPTED_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getFreeThrowsMade(final String row){
		final String data = splitArray(row)[FREE_THROWS_MADE_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getFreeThrowsAttempted(final String row){
		final String data = splitArray(row)[FREE_THROWS_ATTEMPTED_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getOffensiveRebounds(final String row){
		final String data = splitArray(row)[OFFENSIVE_REBOUNDS_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getDefensiveRebounds(final String row){
		final String data = splitArray(row)[DEFENSIVE_REBOUNDS_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getTotalRebounds(final String row){
		final String data = splitArray(row)[TOTAL_REBOUNDS_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getAssists(final String row){
		final String data = splitArray(row)[ASSISTS_INDEX];
		return Integer.parseInt(data);
	}
	 
	public static int getPersonalFouls(final String row){
		final String data = splitArray(row)[PERONAL_FOULS_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getSteals(final String row){
		final String data = splitArray(row)[STEALS_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getTurnOvers(final String row){
		final String data = splitArray(row)[TURNOVERS_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getBlocks(final String row){
		final String data = splitArray(row)[BLOCKS_INDEX];
		return Integer.parseInt(data);
	}
	
	public static int getPoints(final String row){
		final String data = splitArray(row)[POINTS_INDEX];
		return Integer.parseInt(data);
	}
	 
	private static TeamEnum getTeam(final String data){
		final String teamName = data.replace(" ", "");
		return TeamEnum.valueOf(teamName);
	}
	 
	
}

