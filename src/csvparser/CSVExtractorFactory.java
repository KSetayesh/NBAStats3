package csvparser;

import config.FileTypeEnum;

public class CSVExtractorFactory {
	
	private CSVExtractorFactory(){}
	
	public static CSVExtractor getCSVExtractor(final FileTypeEnum fileTypeEnum) throws Exception{
		if(FileTypeEnum.DFS_DATA.equals(fileTypeEnum)){
			return new DfsCSVExtractor();
		}
		else if(FileTypeEnum.PLAYER_STATS.equals(fileTypeEnum)){
			return new PlayerStatsCSVExtractor();
		}
		throw new Exception("File type not found");
	}
	
}
