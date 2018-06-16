package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigHandler {

	private static final String FILE_PATH = "FilePath_";
	private static final String FILE_TYPE = "FileType_";
	private static final String READ_FROM_FILE = "ReadFromFile_";
	private static final String CONFIG_FILE_PATH = "/Users/Kevin_Setayesh/Desktop/FdsConfig.txt";
	
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
		final Map<Integer, Boolean> readFromFileMap = new HashMap<>();
		 
		 
		final FileReader fr = new FileReader(CONFIG_FILE_PATH);
		final BufferedReader br = new BufferedReader(fr);
		
		String currentLine = "";
		while ((currentLine = br.readLine()) != null) {
			currentLine = currentLine.trim();
			if(currentLine.length() == 0 || currentLine.startsWith("#")){
				continue;
			}
			if(currentLine.startsWith(FILE_PATH)){
				final String filePath = currentLine.substring(currentLine.indexOf(":") + 2);
				filePathMap.put(getFileNumber(currentLine), filePath);
			}
			else if(currentLine.startsWith(FILE_TYPE)){
				final String fileType = currentLine.substring(currentLine.indexOf(":") + 2);
				final FileTypeEnum fileTypeEnum = FileTypeEnum.valueOf(fileType);
				fileTypeMap.put(getFileNumber(currentLine), fileTypeEnum);
			}
			else if(currentLine.startsWith(READ_FROM_FILE)){
				final String readFromFile = currentLine.substring(currentLine.indexOf(":") + 2);
				if("TRUE".equals(readFromFile.toUpperCase())){
					readFromFileMap.put(getFileNumber(currentLine), true);
				}
				else{
					readFromFileMap.put(getFileNumber(currentLine), false);
				}
			}
		}
		
		br.close();
		
		
		if(filePathMap.size() != fileTypeMap.size() && fileTypeMap.size() != readFromFileMap.size()){
			throw new Exception("Must have same number of data for each of the 3 maps");
		}
		
		int counter = 1;
		while(filePathMap.containsKey(counter) && 
			  fileTypeMap.containsKey(counter) &&
			  readFromFileMap.containsKey(counter)){
			
			final StatisticsFile statsFile = new StatisticsFile(new File(filePathMap.get(counter)),
																fileTypeMap.get(counter),
																readFromFileMap.get(counter));
			statisticsFiles.add(statsFile);
			counter++;
		}
		
		if(filePathMap.containsKey(counter) ||
		   fileTypeMap.containsKey(counter) ||
		   readFromFileMap.containsKey(counter)){
			throw new Exception("Must have same number of data for each of the 3 maps");
		}
		
	}
	
	private Integer getFileNumber(final String currentLine){
		return Integer.parseInt(currentLine.substring(currentLine.indexOf("_") + 1, 
				currentLine.indexOf(":")));
	}
	
	
}
