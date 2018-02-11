package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import constants.NBAYearEnum;

public class DateUtil {
	
	private final static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");
	private final static String PLAYOFFS = "Playoffs";
	
	private DateUtil(){}
	
	public static Date getDateOfGame(final String date) throws ParseException{
		return DATE_FORMATTER.parse(date);
	}
	
	public static NBAYearEnum getNBAYear(final String data) throws Exception{
		int yr = -1;
		if(data.contains(PLAYOFFS)){
			yr = Integer.parseInt(data.substring(0, data.indexOf(" "))) - 1;
		}
		else{
			yr = Integer.parseInt(data.substring(0, data.indexOf("-")));
		}
		if(yr == -1){
			throw new Exception("Invalid data found at rowNum ");
		}
		
		return NBAYearEnum.valueOf("_" + yr);
	}
	
	public static java.sql.Date getSQLDate(final Date date){
		return new java.sql.Date(date.getTime());
	}
	
}


