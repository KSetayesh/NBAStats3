package csvparser;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import constants.NBAYearEnum;
import constants.PositionEnum;
import constants.TeamEnum;
import constants.VenueEnum;

public abstract class CSVExtractor {
	
	public CSVExtractor(){}
	
	public abstract boolean isPlayOffGame(final String row);
	public abstract NBAYearEnum getNBAYear(final String row) throws Exception;
	public abstract Date getDateOfGame(final String row) throws ParseException;
	public abstract String getFirstName(final String row);
	public abstract String getLastName(final String row);
	public abstract Set<PositionEnum> getPositions(final String row);
	public abstract TeamEnum getOwnTeam(final String row);
	public abstract TeamEnum getOpponentTeam(final String row);
	public abstract VenueEnum getVenue(final String row);
	public abstract TeamEnum getHomeTeam(final String row);
	public abstract TeamEnum getAwayTeam(final String row);
	public abstract double getMinutesPlayed(final String row);
	public abstract int getFieldGoalsMade(final String row);
	public abstract int getFieldGoalsAttempted(final String row);
	public abstract int getThreePointersMade(final String row);
	public abstract int getThreePointersAttempted(final String row);
	public abstract int getFreeThrowsMade(final String row);
	public abstract int getFreeThrowsAttempted(final String row);
	public abstract int getOffensiveRebounds(final String row);
	public abstract int getDefensiveRebounds(final String row);
	public abstract int getTotalRebounds(final String row);
	public abstract int getAssists(final String row);
	public abstract int getPersonalFouls(final String row);
	public abstract int getSteals(final String row);
	public abstract int getTurnOvers(final String row);
	public abstract int getBlocks(final String row);
	public abstract int getPoints(final String row);
	protected abstract String [] splitArray(final String row);
		 
}
