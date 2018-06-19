package config;

public enum FileTypeEnum {
	
	PLAYER_STATS(1, "File that has mostly player game statistics"),
	DFS_DATA(2, "File that has mostly dfs data i.e(fan duel points, salary, player ids etc...)");
	
	private final int fileNum;
	private final String description;
	
	FileTypeEnum(final int fileNum, final String description){
		this.fileNum = fileNum;
		this.description = description;
	}
	
	public static FileTypeEnum getFileTypeEnumBasedOnFileNum(final int fileNum) throws Exception{
		for(FileTypeEnum fte : FileTypeEnum.values()){
			if(fte.fileNum == fileNum){
				return fte;
			}
		}
		throw new Exception("FileTypeEnum for fileNum: " + fileNum + " not found");
	}
}
