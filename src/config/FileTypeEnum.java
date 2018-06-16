package config;

public enum FileTypeEnum {
	DFS_DATA("File that has mostly dfs data i.e(fan duel points, salary, player ids etc...)"),
	PLAYER_STATS("File that has mostly player game statistics");
	
	private final String description;
	
	FileTypeEnum(final String description){
		this.description = description;
	}
}
