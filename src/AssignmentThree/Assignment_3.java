package AssignmentThree;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Assignment_3 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = openFile(args[0]);
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		while(getNextLine(reader))
		{
			switch(mCommand)
			{
				case 1: 
					list.appendFront(mFirstArg);
					break;
					
				case 2:
					list.appendRear(mFirstArg);
					break;
					
				case 3:
					list.insertBefore(mFirstArg, mSecondArg);
					break;
					
				case 4:
					list.insertAfter(mFirstArg, mSecondArg);
					break;
					
				case 5:
					boolean answer = list.isPresent(mFirstArg);
					System.out.println("Is Present for " + mFirstArg + " returns " + answer);
					break;
					
				case 6:
					list.remove(mFirstArg);
					break;
					
				case 7:
					list.print();
					break;
					
				case 8:
					list.sortAndPrint();
					break;

                case 9:
                    list.printBackwards();
                    break;
					
				default:
					System.out.println("Unknown command in input file: " + mCommand);
					break;
			}
		}
		
		reader.close();
						
	}

	public static BufferedReader openFile(String fileName) throws IOException
	{
		BufferedReader bufReader = null;
		bufReader = new BufferedReader(new FileReader(fileName));
 
		return bufReader;
	}
	
	public static boolean getNextLine(BufferedReader reader) throws IOException
	{
		if(!reader.ready()) return false;
		
		String line = reader.readLine();
		String[] tokens = line.split(" ");
		
		mCommand = Integer.parseInt(tokens[0]);
		if(mCommand == 0) return false;
		
		if(tokens.length > 1) mFirstArg = tokens[1];
		if(tokens.length > 2) mSecondArg = tokens[2];
		
		return true;
	}
		
	private static int mCommand;
	private static String mFirstArg;
	private static String mSecondArg;
}
