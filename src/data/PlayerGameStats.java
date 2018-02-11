package data;

import java.util.Date;

import constants.NBAYearEnum;
import constants.TeamEnum;
import constants.VenueEnum;
import util.Util;

public class PlayerGameStats {
	
	private final String firstName;
	private final String lastName;
	private final NBAYearEnum nbaYear;
	private final Date date; 
	private final TeamEnum ownTeam;
	private final TeamEnum opponentTeam;
	private final VenueEnum venue;
	private final double minutes;
	private final int fieldGoalsMade;
	private final int fieldGoaldsAttempted;
	private final double fieldGoalPercentage;
	private final int threePointersMade;
	private final int threePointersAttempted;
	private final double threePointPercentage;
	private final int freeThrowsMade;
	private final int freeThrowsAttempted;
	private final double freeThrowPercentage;
	private final int offensiveRebounds;
	private final int defensiveRebounds;
	private final int totalRebounds;
	private final int personalFouls;
	private final int assists;
	private final int steals;
	private final int turnOvers;
	private final int blocks;
	private final int points;
	
	public PlayerGameStats( 
			 final String firstName,
			 final String lastName,
	         final NBAYearEnum nbaYear, 
			 final Date date,  
			 final TeamEnum ownTeam,
			 final TeamEnum opponentTeam, 
			 final VenueEnum venue, 
			 final double minutes,
			 final int fieldGoalsMade, 
			 final int fieldGoaldsAttempted,
			 final int threePointersMade, 
			 final int threePointersAttempted, 
			 final int freeThrowsMade, 
			 final int freeThrowsAttempted,
			 final int offensiveRebounds, 
			 final int defensiveRebounds, 
			 final int totalRebounds,
			 final int assists, 
			 final int personalFouls,
			 final int steals, 
			 final int turnOvers,
			 final int blocks,
			 final int points) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.nbaYear = nbaYear;
		this.date = date; 
		this.ownTeam = ownTeam;
		this.opponentTeam = opponentTeam;
		this.venue = venue;
		this.minutes = Util.round(minutes);
		this.fieldGoalsMade = fieldGoalsMade;
		this.fieldGoaldsAttempted = fieldGoaldsAttempted;
		this.fieldGoalPercentage = Util.round((double)fieldGoalsMade / fieldGoaldsAttempted);
		this.threePointersMade = threePointersMade;
		this.threePointersAttempted = threePointersAttempted;
		this.threePointPercentage = Util.round((double)threePointersMade / threePointersAttempted);
		this.freeThrowsMade = freeThrowsMade;
		this.freeThrowsAttempted = freeThrowsAttempted;
		this.freeThrowPercentage = Util.round((double)freeThrowsMade / freeThrowsAttempted);
		this.offensiveRebounds = offensiveRebounds;
		this.defensiveRebounds = defensiveRebounds;
		this.totalRebounds = totalRebounds;
		this.assists = assists;
		this.personalFouls = personalFouls;
		this.steals = steals;
		this.turnOvers = turnOvers;
		this.blocks = blocks;
		this.points = points;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}

	public NBAYearEnum getNbaYear() {
		return nbaYear;
	}

	public Date getDate() {
		return date;
	}

	public TeamEnum getOwnTeam() {
		return ownTeam;
	}

	public TeamEnum getOpponentTeam() {
		return opponentTeam;
	}

	public VenueEnum getVenue() {
		return venue;
	}

	public double getMinutes() {
		return minutes;
	}

	public int getFieldGoalsMade() {
		return fieldGoalsMade;
	}

	public int getFieldGoaldsAttempted() {
		return fieldGoaldsAttempted;
	}

	public double getFieldGoalPercentage() {
		return fieldGoalPercentage;
	}

	public int getThreePointersMade() {
		return threePointersMade;
	}

	public int getThreePointersAttempted() {
		return threePointersAttempted;
	}

	public double getThreePointPercentage() {
		return threePointPercentage;
	}

	public int getFreeThrowsMade() {
		return freeThrowsMade;
	}

	public int getFreeThrowsAttempted() {
		return freeThrowsAttempted;
	}

	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	public int getOffensiveRebounds() {
		return offensiveRebounds;
	}

	public int getDefensiveRebounds() {
		return defensiveRebounds;
	}

	public int getTotalRebounds() {
		return totalRebounds;
	}

	public int getAssists() {
		return assists;
	}

	public int getSteals() {
		return steals;
	}

	public int getPersonalFouls(){
		return personalFouls;
	}
	
	public int getTurnOvers() {
		return turnOvers;
	}

	public int getBlocks() {
		return blocks;
	}

	public int getPoints() {
		return points;
	}
	

	@Override
	public String toString() {
		return "PlayerGameStatisticsRequest [firstName=" + firstName + ", lastName=" + lastName + ", nbaYear=" + nbaYear
				+ ", date=" + date + ", ownTeam=" + ownTeam + ", opponentTeam=" + opponentTeam + ", venue=" + venue
				+ ", minutes=" + minutes + ", fieldGoalsMade=" + fieldGoalsMade + ", fieldGoaldsAttempted="
				+ fieldGoaldsAttempted + ", fieldGoalPercentage=" + fieldGoalPercentage + ", threePointersMade="
				+ threePointersMade + ", threePointersAttempted=" + threePointersAttempted + ", threePointPercentage="
				+ threePointPercentage + ", freeThrowsMade=" + freeThrowsMade + ", freeThrowsAttempted="
				+ freeThrowsAttempted + ", freeThrowPercentage=" + freeThrowPercentage + ", offensiveRebounds="
				+ offensiveRebounds + ", defensiveRebounds=" + defensiveRebounds + ", totalRebounds=" + totalRebounds
				+ ", personalFouls=" + personalFouls + ", assists=" + assists + ", steals=" + steals + ", turnOvers="
				+ turnOvers + ", blocks=" + blocks + ", points=" + points + "]";
	}
	
	
}
