package constants;

public enum NBAYearEnum {

	_2010(2010, "2010-2011"),
	_2011(2011, "2011-2012"),
	_2012(2012, "2012-2013"),
	_2013(2013, "2013-2014"),
	_2014(2014, "2014-2015"),
	_2015(2015, "2015-2016"),
	_2016(2016, "2016-2017"),
	_2017(2017, "2017-2018"),
	_2018(2018, "2018-2019"),
	_2019(2019, "2019-2020"),
	_2020(2020, "2020-2021");
	
	private final int nbaYear;
	private final String nbaYearDescription;
	
	NBAYearEnum(final int nbaYear, final String nbaYearDescription ){
		this.nbaYear = nbaYear;
		this.nbaYearDescription = nbaYearDescription;
	}
	
    @Override
    public String toString() {
    	return nbaYear + "";
	}
    
}
