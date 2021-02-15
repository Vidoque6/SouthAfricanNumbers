package management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import store.StoreManager;

public class NumbersManager {
	
	private final static String INPUT_FILE_COMPLETE_PATH = "C:\\Users\\User\\Documents\\Pre-selezione. South_African_Mobile_Numbers.csv";
	private final static String ACCEPTED_FILE_COMPLETE_PATH = "C:\\Users\\User\\Documents\\accepted.csv";
	private final static String CORRECTED_FILE_COMPLETE_PATH = "C:\\Users\\User\\Documents\\corrected.csv";
	private final static String DISCARDED_FILE_COMPLETE_PATH = "C:\\Users\\User\\Documents\\discarded.csv";

	public static void main(String[] args) {
		List<String> records = null;
		
		//read inputs
		records = read();
		
		//management
		Results results = manageRecords(records);
		
		//store results
		write(results);
	}

	private static List<String> read() {
		List<String> records = null;
		try {
			StoreManager sm = new StoreManager();
			records = sm.readFile(INPUT_FILE_COMPLETE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;
	}
	
	private static void write(Results results) {
		try {
			StoreManager sm = new StoreManager();
			sm.writeFile(ACCEPTED_FILE_COMPLETE_PATH, results.getAccepted());
			sm.writeFile(CORRECTED_FILE_COMPLETE_PATH, results.getCorrected());
			sm.writeFile(DISCARDED_FILE_COMPLETE_PATH, results.getDiscarded());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Results manageRecords(List<String> records) {
		List<Result> accepted = new ArrayList<Result>();
		List<Result> corrected = new ArrayList<Result>();
		List<Result> discarded = new ArrayList<Result>();
		ValidateAndCorrect vnc = new ValidateAndCorrect();
		for (String rec : records) {
			if(rec!=null) {
				Result result = vnc.validateAndCorrect(rec);
				if(State.ACCEPTED.equals(result.getResult())) {
					accepted.add(result);
				}else if(State.CORRECTED.equals(result.getResult())) {
					corrected.add(result);
				}else {
					discarded.add(result);
				}
			}
		}
		return new Results(accepted, corrected, discarded);
	}

}
