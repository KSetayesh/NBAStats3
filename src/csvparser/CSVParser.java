package csvparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
	
	private final File file;
	
	public CSVParser(final File file){
		this.file = file;
	}
	
	public List<String> parseCSVFile() throws IOException{
		final List<String> list = new ArrayList<String>();
		final FileReader fr = new FileReader(file.getAbsolutePath());
		final BufferedReader br = new BufferedReader(fr);
		
		int lineNumber = 0;
		String currentLine = "";
		while ((currentLine = br.readLine()) != null) {
			lineNumber++;
			if (lineNumber == 1){
				continue;
			}
			list.add(currentLine);
			
		}
		
		fr.close();
		br.close();
		
		return list;
	}

}
