package data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import constants.PositionEnum;

public class Player {
	
	private final int playerId;
	private final String firstName;
	private final String lastName;
	private Date birthDate;
	private Set<PositionEnum> positions;
	
	public Player(final int playerId,
				   final String firstName,
				   final String lastName){
		this(playerId, firstName, lastName, new HashSet<PositionEnum>());
	}
	
	public Player(final int playerId,
			   final String firstName,
			   final String lastName,
			   final Set<PositionEnum> positions){
		this.playerId = playerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.positions = positions;
		
	}

	public int getPlayerId() {
		return playerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Set<PositionEnum> getPositions() {
		return positions;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", positions=" + positions + "]";
	}
	

}
