package Exercise6;


import java.io.DataInputStream;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * This program enables Processing Daily Rainfall Data from Selected Station using Byte-Based Stream
 * The data is read in byte-based using DataInputStream class. 
 * The data represents station id, station name, name of district and 6-days reading of daily rainfall.
 * 
 * @author FATIN AQILAH BINTI NORHALIM (B032120072)
 *
 */
public class RFByteBasedReader {

	public static void main(String[] args) {

		// 1. Make a declaration of source file 
		String sourceFile = "RainfallByteBased.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		
		try {

			// 2. Create input stream to read the data
			DataInputStream streamInput = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			// Declare Station Id
			int id = 0;
			
			// Declare Station Name and District
			String station = " ", district = " ";
			
			// Daily rainfall readings data from 4 June 2023 to 9 June 2023
			double readingsdata1 = 0.0, readingsdata2 = 0.0, readingsdata3 = 0.0;
			double readingsdata4 = 0.0, readingsdata5 = 0.0, readingsdata6 = 0.0;
			
			// Variable declaration for calculation
			// Sum of records read from the source file
			int sumOfRecords = 0;
			
			// Total daily rainfall readings data for each station
			double sum = 0.0;
			// Declare Arraylist to store sum of each daily rainfall readings
			ArrayList <Double> totalRainfall = new ArrayList<Double>();
			
			// ArrayList to store stations data to calculate
			ArrayList<String> stations = new ArrayList<String>();
						
			// HashSet to store distinct district data to calculate
			HashSet<String> districtCount = new HashSet<String>();
			
			
			// 3. Process data until end-of-file
			while(streamInput.available() > 0) {
				
				// Read data
				
				// station id
				id = streamInput.readInt();
				
				// station name
				station = streamInput.readUTF();
				
				// district
				district = streamInput.readUTF();
				
				// daily rainfall readings data for 4 June 2023
				readingsdata1 = streamInput.readDouble();
				
				// daily rainfall readings data for 5 June 2023
				readingsdata2 = streamInput.readDouble();
				
				// daily rainfall readings data for 6 June 2023
				readingsdata3 = streamInput.readDouble();
				
				// daily rainfall readings data for 7 June 2023
				readingsdata4 = streamInput.readDouble();
				
				// daily rainfall readings data for 8 June 2023
				readingsdata5 = streamInput.readDouble();
				
				// daily rainfall readings data for 9 June 2023
				readingsdata6 = streamInput.readDouble();
				
				System.out.println( id + "\t" + station + "\t" + district
						+ "\t" + readingsdata1 + "\t" + readingsdata2 + "\t" + readingsdata3 
						+ "\t" + readingsdata4 + "\t" + readingsdata5 + "\t" + readingsdata6 );
				
				// calculate total daily rainfall readings for each station
				sum = readingsdata1 + readingsdata2 + readingsdata3 + readingsdata4 + readingsdata5 + readingsdata6;
				
				// save the sum into the arraylist
				totalRainfall.add(sum);
				
				// save the station names into the arraylist
				stations.add(station);
				
				// save the distinct district into hashSet
				districtCount.add(district);
				
				// Auto update for current number of records
				sumOfRecords ++;
			}
			
			System.out.println("\n");
			
			// Calculation for average daily rainfall readings in each station
			for(int index = 0; index < stations.size(); index++)
			{
				// Calculation for average daily rainfall readings in each station
				double average = totalRainfall.get(index) / sumOfRecords;
				
				// format the average in one decimal places
				String formattedAverage = String.format("%.1f", average);
				
				// display the total daily rainfall readings in each station and its correspond average
				System.out.println("The total daily rainfall readings in " + stations.get(index) + " : " 
						+ totalRainfall.get(index) );
				System.out.println("The average daily rainfall readings in " + stations.get(index) + " : " 
						+ formattedAverage + "\n");
			}
			
			System.out.println("There are " + stations.size() + " stations and "
						+ districtCount.size() + " districts in Melaka.");
			
			// 4. Close stream
			streamInput.close();
	
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// End of program 
		System.out.println("\nEnd of program.");
	}
}
