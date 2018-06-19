package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConfigHandler {

	private static final String FILE_PATH = "FilePath_";
	private static final String FILE_TYPE = "FileType_";
	private static final String MERGING_LOGIC = "MergingLogic";
	private static final String CONFIG_FILE_PATH = "/Users/Kevin_Setayesh/Documents/workspace/thgit/NBAStats3/files/FdsConfig.txt";
	private static final Set<String> linesToSkip = new HashSet<>();
	static{
		linesToSkip.add("#");
		linesToSkip.add("Columns");
	}
	
	private final List<StatisticsFile> statisticsFiles;

	
	private static ConfigHandler configHandler;
	
	private ConfigHandler() throws Exception{
		this.statisticsFiles = new ArrayList<>();
		setDataFromConfigFile();
	}
	
	public static ConfigHandler getInstance() throws Exception{
		if(configHandler == null){
			configHandler = new ConfigHandler();
		}
		return configHandler;
	}
	
	public List<StatisticsFile> getStatisticsFile(){
		return statisticsFiles;
	}
	
	private void setDataFromConfigFile() throws Exception{
		final Map<Integer, String> filePathMap = new HashMap<>();
		final Map<Integer, FileTypeEnum> fileTypeMap = new HashMap<>();
		 
		final FileReader fr = new FileReader(CONFIG_FILE_PATH);
		final BufferedReader br = new BufferedReader(fr);
		boolean parseTableColumns = false;
		final Map<FileTypeEnum, HashMap<String, Integer>> columnNameToIndexMap 
						= new HashMap<FileTypeEnum, HashMap<String,Integer>>();
		
		String currentLine = "";
		while ((currentLine = br.readLine()) != null) {
			if(skipLine(currentLine)){
				continue;
			}
			else if(currentLine.startsWith(FILE_PATH)){
				final String filePath = currentLine.substring(currentLine.indexOf(":") + 2).trim();
				filePathMap.put(getFileNumber(currentLine), filePath);
			}
			else if(currentLine.startsWith(FILE_TYPE)){
				final String fileType = currentLine.substring(currentLine.indexOf(":") + 2).trim();
				final FileTypeEnum fileTypeEnum = FileTypeEnum.valueOf(fileType);
				fileTypeMap.put(getFileNumber(currentLine), fileTypeEnum);
			}
			else if(currentLine.startsWith(MERGING_LOGIC)){
				parseTableColumns = true;
			}
			else if(parseTableColumns){
				final String [] split = currentLine.split("\\|");
				if(split.length < 3){
					parseTableColumns = false;
				}
				else{
					final String columnName = split[0].trim();
					final FileTypeEnum fileTypeEnum = getFileTypeEnumFromIntegerValue(split[1].trim());
					final int columnIndex = Integer.parseInt(split[2].trim());
					addToColumnNameToIndexMap( columnNameToIndexMap, 
										   columnName, 
										   fileTypeEnum, 
										   columnIndex);
				}
			}
		}
		
		br.close();
		
		
		if(filePathMap.size() != fileTypeMap.size()){
			throw new Exception("Must have same number of data for each of the 3 maps");
		}
		
		int counter = 1;
		while(filePathMap.containsKey(counter) && 
			  fileTypeMap.containsKey(counter)){
			
			final FileTypeEnum fileTypeEnum = fileTypeMap.get(counter);
			if(!columnNameToIndexMap.containsKey(fileTypeEnum)){
				throw new Exception("FileTypeEnums not found");
			}
			final StatisticsFile statsFile = new StatisticsFile(new File(filePathMap.get(counter)),
																fileTypeMap.get(counter),
																columnNameToIndexMap.get(fileTypeEnum));
			statisticsFiles.add(statsFile);
			counter++;
		}
		
		if(filePathMap.containsKey(counter) ||
		   fileTypeMap.containsKey(counter)){
			throw new Exception("Must have same number of data for each of the 3 maps");
		}
		
	}
	
	private Integer getFileNumber(final String currentLine){
		return Integer.parseInt(currentLine.substring(currentLine.indexOf("_") + 1, 
				currentLine.indexOf(":")));
	}
	
	private boolean skipLine(String line){
		line = line.trim();
		if(line.length() == 0){
			return true;
		}
		
		if(line.charAt(0) == '-'){
			return true;
		}
		
		for(final String str : linesToSkip){
			if(line.startsWith(str)){
				return true;
			}
		}
		return false;
	}
	
	private FileTypeEnum getFileTypeEnumFromIntegerValue(String str) throws Exception{
		str = str.trim();
		int value = Integer.parseInt(str);
		return FileTypeEnum.getFileTypeEnumBasedOnFileNum(value);
	}
	
	private void addToColumnNameToIndexMap( final Map<FileTypeEnum, HashMap<String, Integer>> columnNameToIndexMap, 
											final String columnName,
											final FileTypeEnum fileTypeEnum,
											final int columnIndex){
		
		if(!columnNameToIndexMap.containsKey(fileTypeEnum)){
			columnNameToIndexMap.put(fileTypeEnum, new HashMap<>());
		}
		
		if(!columnNameToIndexMap.get(fileTypeEnum).containsKey(columnName)){
			columnNameToIndexMap.get(fileTypeEnum).put(columnName, columnIndex);
		}
		
	}
	
}
