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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((awayTeam == null) ? 0 : awayTeam.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((homeTeam == null) ? 0 : homeTeam.hashCode());
		result = prime * result + (isPlayoffGame ? 1231 : 1237);
		result = prime * result + ((nbaYear == null) ? 0 : nbaYear.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameDetail other = (GameDetail) obj;
		if (awayTeam != other.awayTeam)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (homeTeam != other.homeTeam)
			return false;
		if (isPlayoffGame != other.isPlayoffGame)
			return false;
		if (nbaYear != other.nbaYear)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GameDetail [homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", date=" + date + ", nbaYear=" + nbaYear
				+ ", isPlayoffGame=" + isPlayoffGame + "]";
	} 
	
	
	
}
