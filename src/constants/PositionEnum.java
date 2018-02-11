package constants;

public enum PositionEnum {
	
	PG(1, "PointGaurd"),
	SG(2, "ShootingGaurd"),
	SF(3, "SmallForward"),
	PF(4, "PowerForward"),
	C(5, "Center");
	
	private final int positionNumber;
	private final String positionName;
	
    PositionEnum(int positionNumber, String positionName){
		this.positionNumber = positionNumber;
		this.positionName = positionName;
	}
    
    public int getPositionNumber(){
    	return positionNumber;
    }
    
    public String getPositionName(){
    	return positionName;
    }
    
	
}
