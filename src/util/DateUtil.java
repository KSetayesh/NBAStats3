package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private final static String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";
	
	private DateUtil(){}
	
	public static Date getDate(final String date) throws ParseException{
		return getDate(date, DEFAULT_DATE_FORMAT);
	}
	
	public static Date getDate(final String date, final String dateFormat) throws ParseException{
	    final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);  
		return sdf.parse(date);
	}
	
	public static java.sql.Date getSQLDate(final Date date){
		return new java.sql.Date(date.getTime());
	}
	
}


