package data;

import java.util.Date;

import constants.NBAYearEnum;
import constants.TeamEnum;

public class GameDetail {
	private TeamEnum homeTeam;
	private TeamEnum awayTeam;
	private Date date;
	private NBAYearEnum nbaYear;
	private boolean isPlayoffGame;
	
	public GameDetail( final TeamEnum homeTeam, 
						final TeamEnum awayTeam, 
						final Date date, 
						final NBAYearEnum nbaYear, 
						final boolean isPlayoffGame) {
		
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.date = date;
		this.nbaYear = nbaYear;
		this.isPlayoffGame = isPlayoffGame;
	}

	public TeamEnum getHomeTeam() {
		return homeTeam;
	}

	public TeamEnum getAwayTeam() {
		return awayTeam;
	}

	public Date getDate() {
		return date;
	}

	public NBAYearEnum getNbaYear() {
		return nbaYear;
	}

	public boolean isPlayoffGame() {
		return isPlayoffGame;
	}

	@Override
	public String toString() {
		return "GameDetail [homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", date=" + date + ", nbaYear=" + nbaYear
				+ ", isPlayoffGame=" + isPlayoffGame + "]";
	} 
	
	
	
}
