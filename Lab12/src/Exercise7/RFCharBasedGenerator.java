package Exercise7;


import java.io.BufferedWriter;
import java.io.FileWriter;

/*
 * This class write the daily rainfall readings from selected station to a certain output file
 * using suitable subclasses of Writer.
 * 
 * This class is recreated based on RainFallDataWriter.java in package exercise5.
 * 
 * In this case, BufferedWriter is used.
 * @author FATIN AQILAH BINTI NORHALIM (B032120072)
 */
public class RFCharBasedGenerator {

	public static void main (String [] args)
	{
		// 1. Make a declaration of output file
		String outFile = "RainfallCharBased.txt";
		try
		{		
			// 2. Construct BufferedWriter object together with FileWriter
			FileWriter files = new FileWriter(outFile);
			BufferedWriter bwOutput = new BufferedWriter(files);
			int [] array= {1,0,6,19,1,0};
			
			// 3. Write the data
			for (int index = 0; index < array.length; index++) {
				bwOutput.write(String.valueOf(array[index]));
				bwOutput.newLine();
			}
			
			
			// 4. Clear the stream
			bwOutput.flush(); 
			
			// 5. Close the stream
			bwOutput.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// End of program
		System.out.println("End of program. Check out " + outFile); 
	}
	
}
