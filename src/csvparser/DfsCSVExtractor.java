package csvparser;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import constants.NBAYearEnum;
import constants.PositionEnum;
import constants.TeamEnum;
import constants.VenueEnum;
import util.DateUtil;

public class DfsCSVExtractor extends CSVExtractor{ 

	private final static int PLAYER_ID_INDEX = 0;
	private final static int LAST_NAME_INDEX = 1;
	private final static int FIRST_NAME_INDEX = 2;
	private final static int FULL_NAME_INDEX = 3;
	private final static int DATE_OF_GAME_INDEX = 4;
	private final static int OWN_TEAM_INDEX = 5;
	private final static int OPPONENT_TEAM_INDEX = 6;
	private final static int VENUE_INDEX = 7;
	private final static int TEAM_POINTS_INDEX = 8;
	private final static int OPPOSING_TEAM_POINTS_INDEX = 9;
	private final static int DID_START_INDEX = 10;
	private final static int MINUTES_PLAYED_INDEX = 11;
	private final static int GAME_PLAYED_INDEX = 12;	
	private final static int IS_ACTIVE_INDEX = 13;
	private final static int FAN_DUEL_POINTS_INDEX = 14;
	private final static int DRAFT_KING_POINTS_INDEX = 15;
	private final static int DRAFT_DAY_POINTS_INDEX = 16;
	private final static int STAR_FANTASY_POINTS_INDEX = 17;
	private final static int PLAYER_STATS_INDEX = 18;
	private final static int FAN_DUEL_SALARY_INDEX = 19;
	private final static int DRAFT_KING_SALARY_INDEX = 20;
	private final static int DRAFT_DAY_SALARY_INDEX = 21;
	private final static int STAR_FANTASY_SALARY_INDEX = 22;
	private final static int FAN_DUEL_POSITION_INDEX = 23;
	private final static int DRAFT_KING_POSITION_INDEX = 24;
	private final static int DRAFT_DAY_POSITION_INDEX = 25;
	private final static int STAR_FANTASY_POSITION_INDEX = 26;
	
	public DfsCSVExtractor(){
		
	}

	
	public boolean isPlayOffGame(String row) {
		return false;
	}

	
	public NBAYearEnum getNBAYear(String row) throws Exception {
		return null;
	}

	
	public Date getDateOfGame(String row) throws ParseException {
		
		return null;
	}

	
	public String getFirstName(String row) {
		
		return null;
	}

	
	public String getLastName(String row) {
		
		return null;
	}

	
	public Set<PositionEnum> getPositions(String row) {
		
		return null;
	}

	
	public TeamEnum getOwnTeam(String row) {
		
		return null;
	}

	
	public TeamEnum getOpponentTeam(String row) {
		
		return null;
	}

	
	public VenueEnum getVenue(String row) {
		
		return null;
	}

	
	public TeamEnum getHomeTeam(String row) {
		
		return null;
	}

	
	public TeamEnum getAwayTeam(String row) {
		
		return null;
	}

	
	public double getMinutesPlayed(String row) {
		
		return 0;
	}

	
	public int getFieldGoalsMade(String row) {
		
		return 0;
	}

	
	public int getFieldGoalsAttempted(String row) {
		
		return 0;
	}

	
	public int getThreePointersMade(String row) {
		
		return 0;
	}

	
	public int getThreePointersAttempted(String row) {
		
		return 0;
	}

	
	public int getFreeThrowsMade(String row) {
		
		return 0;
	}

	
	public int getFreeThrowsAttempted(String row) {
		
		return 0;
	}

	
	public int getOffensiveRebounds(String row) {
		
		return 0;
	}

	
	public int getDefensiveRebounds(String row) {
		
		return 0;
	}

	
	public int getTotalRebounds(String row) {
		
		return 0;
	}

	
	public int getAssists(String row) {
		
		return 0;
	}

	
	public int getPersonalFouls(String row) {
		
		return 0;
	}

	
	public int getSteals(String row) {
		
		return 0;
	}

	
	public int getTurnOvers(String row) {
		
		return 0;
	}

	
	public int getBlocks(String row) {
		
		return 0;
	}

	
	public int getPoints(String row) {
		
		return 0;
	}

	
	protected String[] splitArray(String row) {
		
		return null;
	}
	
    
	
}
