package config;

import java.io.File;

public class StatisticsFile {
	
	private final File file;
	private final FileTypeEnum fileType;
	private final boolean useFile;
	
	public StatisticsFile(final File file,
						  final FileTypeEnum fileType,
						  final boolean useFile){
		this.file = file;
		this.fileType = fileType;
		this.useFile = useFile;
	}

	public File getFile() {
		return file;
	}

	public FileTypeEnum getFileType() {
		return fileType;
	}

	public boolean isUseFile() {
		return useFile;
	}

	@Override
	public String toString() {
		return "StatisticsFile [file=" + file + ", fileType=" + fileType + ", useFile=" + useFile + "]";
	}
	
}
