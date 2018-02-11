package constants;

public enum VenueEnum {

	H("Home"),
	R("Away");
	
	private final String venue;
	
	VenueEnum(final String venue){
		this.venue = venue;
	}
	
	public String getVenue(){
		return venue;
	}
	
}
