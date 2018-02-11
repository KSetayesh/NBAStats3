package util;

import java.util.HashSet;
import java.util.Set;

import constants.PositionEnum;

public class PositionsUtil {

	private PositionsUtil(){}
	
	public static Set<PositionEnum> getPositions(final String data){
		Set<PositionEnum> positions = new HashSet<PositionEnum>();
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
}
