package Exercise6;


import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * This program enables Processing  Daily  Rainfall Data  from Selected Station using Byte-Based Stream
 * The data is written in byte-based using DataOutputStream class. 
 * 
 * The data represents station id, station name, name of district and 6-days reading of daily rainfall.
 * 
 * @author FATIN AQILAH BINTI NORHALIM (B032120072)
 *
 */
public class RFByteBasedGenerator {
	
	public static void main (String [] args)
	{
		// 1. Make a declaration output file 
		String outputFile = "RainfallByteBased.txt";
		

		// Declare an array of Station id
		int id[] = {2421003, 2322006, 2321006, 2222002, 2324032, 2324033};
		
		// Declare an array of Station name
		String stations[] = {"Simpang Ampat", "Melaka Pindah", "Ladang Lendu", "Durian Tunggal", "Ldg. Sing Lian di Bkt. Senggeh Melaka", "Hospital Jasin"};
		
		// Declare an array of district name
		String district[] = {"Alor Gajah", "Alor Gajah", "Alor Gajah", "Alor Gajah", "Alor Gajah", "Jasin"};
		
		// Declare an array of readings data on 4 June 2023
		double readingsdata1[] = {1.0, 0.0, 0.0, 0.0, 0.0, 14.0};
		
		// Declare an array of readings on data 5 June 2023
		double readingsdata2[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		// Declare an array of readings on data 6 June 2023
		double readingsdata3[] = {6.0, 2.0, 3.0, 37.0, 0.5, 11.0};
		
		// Declare an array of readings on data 7 June 2023
		double readingsdata4[] = {19.0, 18.5, 4.0, 6.0, 4.5, 15.0};
		
		// Declare an array of readings on data 8 June 2023
		double readingsdata5[] = {1.0, 2.5, 0.0, 9.0, 0.0, 31.0};
		
		// Declare an array of readings on data 9 June 2023
		double readingsdata6[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		try {
			
			// 2. Create output stream to read the data
			DataOutputStream streamOutput = new DataOutputStream(new FileOutputStream(outputFile));
			
			// Process data
			for (int index = 0; index < stations.length; index++) {
				
				// 3. Write data into data stream
				streamOutput.writeInt(id[index]);
				streamOutput.writeUTF(stations[index]);
				streamOutput.writeUTF(district[index]);
				streamOutput.writeDouble(readingsdata1[index]);
				streamOutput.writeDouble(readingsdata2[index]);
				streamOutput.writeDouble(readingsdata3[index]);
				streamOutput.writeDouble(readingsdata4[index]);
				streamOutput.writeDouble(readingsdata5[index]);
				streamOutput.writeDouble(readingsdata6[index]);
				
				// 4. Flush for each writing
				streamOutput.flush();
			}
			
			// 5. Close stream
			streamOutput.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		// End of program 
		System.out.println("End of program. Check out " + outputFile); 
	}
}
