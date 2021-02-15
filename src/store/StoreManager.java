package store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import management.Result;

public class StoreManager {

	public List<String> readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		List<String> records = new ArrayList<String>();
		try {
			String line = "";
			int i = 0;
			while (line != null) {
				i++;
				line = br.readLine();
				if(i==1) continue;
				records.add(line);
			}
		} finally {
			br.close();
		}
		return records;
	}
	
	public void writeFile(String fileName, List<Result> records) throws IOException {
		File fileToWrite = new File(fileName);
		if(!fileToWrite.exists()) {
			fileToWrite.createNewFile();
		}
		FileWriter writer = new FileWriter(fileName); 
		for(Result record : records) {
		  String toWrite = record.getId()+","+record.getNumber()+","+record.getResult();
		  writer.write(toWrite + System.lineSeparator());
		}
		writer.close();
	}
}
