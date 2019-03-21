package fr.fazam.dto;

public class FileDto {
	private String file;
	
	public FileDto() {
		
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "FileDto [file=" + file + "]";
	}
}
