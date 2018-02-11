package workflow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DFSPlayerGameStatsWorkflow {
	
	private final static String FILEPATH = "/Users/Kevin_Setayesh/Documents/workspace/thgit/NBAStats3/files/dfsIds.txt";
	
	public Map<String, Integer> getRotoGuruPlayerIds() throws IOException {
		final FileReader fr = new FileReader(FILEPATH);
		final BufferedReader br = new BufferedReader(fr);
		
		final Map<String, Integer> rotoGuruPlayerIds = new HashMap<>();
		
		String currentLine = "";
		while ((currentLine = br.readLine()) != null) {
			
			final String [] columns = currentLine.split(";");
			final int rotoGuruId = Integer.parseInt(columns[0]);
			final String nameColumn = columns[3];
			final String firstName = nameColumn.substring(nameColumn.indexOf(",") + 1).trim();
			final String lastName = nameColumn.substring(0, nameColumn.indexOf(",")).trim();
			
			final String key = firstName + " " + lastName;
			rotoGuruPlayerIds.put(key, rotoGuruId);
			
		}
		
		fr.close();
		br.close();
		
		return rotoGuruPlayerIds;
		
	}
	 
	    
}
