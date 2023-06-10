package Exercise5;


import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/*
 * Exercise 5: Processing Daily Rainfall Data A Station
 * 
 * Task B
 * 
 * This program genereates data for 6 days reading of daily rainfall
 * from station Simpang Ampat in Alor Gajah district
 * and write these data into a certain output file named "RainFall.txt"
 * with the help of DataOutputStream.
 * 
 * @author FATIN AQILAH BINTI NORHALIM (B032120072)
 * 
 */

public class RFReader {

	public static void main (String [] args)
	{
		// 1. Make a Declaration of output file
		String outputFile = "RainFall.txt";
		
		try
		{
			// 2. Create output stream of this program and the output file
			DataOutputStream streamOutput = new DataOutputStream(new FileOutputStream(outputFile));
			
			// 3. Write the 6 days reading of daily rainfall
			// from station Simpang Ampat in Alor Gajah district into the output file
			streamOutput.write(1);
			streamOutput.write(0);
			streamOutput.write(6);
			streamOutput.write(19);
			streamOutput.write(1);
			streamOutput.write(0);
			
			// 4. Clear the stream
			streamOutput.flush();
			
			// 5. Close the stream
			streamOutput.close(); 
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		// End of program
		System.out.println("End of program. Check out " + outputFile); 
	}
}
