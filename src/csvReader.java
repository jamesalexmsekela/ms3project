import java.io.BufferedReader;
import java.sql.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File; 

public class csvReader{
	
	public static void main(String[] args) throws IOException{
		// Setting the csv file from which data will be read
		String filename = "ms3Interview.csv";
		File file = new File(filename);
		// Declaring and populating the column headers of the trial-bad.csv file
		FileWriter csvWriter = new FileWriter("trial-bad.csv");
		csvWriter.append("A"); csvWriter.append(",");
		csvWriter.append("B"); csvWriter.append(",");
		csvWriter.append("C"); csvWriter.append(",");
		csvWriter.append("D"); csvWriter.append(",");
		csvWriter.append("E"); csvWriter.append(",");
		csvWriter.append("F"); csvWriter.append(",");
		csvWriter.append("G"); csvWriter.append(",");
		csvWriter.append("H"); csvWriter.append(",");
		csvWriter.append("I"); csvWriter.append(",");
		csvWriter.append("J"); csvWriter.append("\n");
		/*
		Declaring counters to count:
			 # of records received or total records
			 # of records successful or records with "right" # of elements
			 # of records failed
		*/
		int totalCount = 0; 
		int sCount = 0;
		int fCount = 0;

		sqliteFuncs test = new sqliteFuncs();
		ResultSet rs;
		
		try{
			// Declaring scanner to read contents of file
			Scanner input = new Scanner(file);
			// Looping over the contents of the csv file
			while(input.hasNext()){
				String data = input.next();
				// Array containing contents of 1 line of data as separated by ","
				String[] curLine = data.split(",");
				
				// Check to make sure that the record being added to the main/correct db is in fact a record containing the "right" # of elements
				if(curLine.length == 11 && totalCount != 0) {
					rs = test.displayContents();
					test.addUser(sCount+1, curLine[0], curLine[1], curLine[2], curLine[3], curLine[4], curLine[5], curLine[6], curLine[7], curLine[8], curLine[9]);
					while(rs.next()) {
						System.out.println(rs.getString("A") + " " + rs.getString("B"));
					}
					sCount++;
				}// Adding the records that do not have the "right" # of elements into the "bad" db
				else if(curLine.length != 11 && totalCount != 0){
					csvWriter.append(data);
					fCount++;
				}
				totalCount++;
			}
			// Flushing and closing the csvWriter 
			csvWriter.flush();
			csvWriter.close();
			// Closing the scanner
			input.close();
			
		}catch(FileNotFoundException x){
			x.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Converting int values into strings before adding them to the log file
		String totalCountStr = Integer.toString(totalCount);
		String sCountStr = Integer.toString(sCount);
		String fCountStr = Integer.toString(fCount);
		
		// Creating and populating the log file
		FileWriter logFile = new FileWriter("trial.log");
		logFile.append("Statistics"); logFile.append("\n");
		logFile.append("Number of records received = "); logFile.append(totalCountStr); logFile.append("\n");
		logFile.append("Number of records successfully added to the db = "); logFile.append(sCountStr); logFile.append("\n");	
		logFile.append("Number of records that failed to be added to the db = "); logFile.append(fCountStr); logFile.append("\n");
		
		// Flushing and closing the logFile writer 
		logFile.flush();
		logFile.close();
	}

}