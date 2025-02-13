/**
 * Partay.java Class for creating attendee objects in Party Planner
 * @author Rohan Kulkarni
 * @since 2/7/25
 * 
 * Preconditions: attendee objects, area layout (num seats, num tables)
 * Postconditions: creates layout of party (num seats, num tables) as well as a list of methods used in tester class 
*/
import java.util.ArrayList; //import for Array Lists
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
public class Partay {
	
	private int newTable;
	private int newSeat;
	private int numAttendees = 0;
	private int searchNum;
	
	//constructors
	public Partay (int table, int seat){
		newTable = table;
		newSeat = seat;
		
		ArrayList<Attendee> attList = new ArrayList<Attendee>();
		try {
			File myObj = new File("partyguests.txt");
			Scanner myReader = new Scanner(myObj);
			myReader.nextLine();
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] dataSplit = data.split(",");
				String tempName = dataSplit[2] + " " + dataSplit[1];
				Attendee att = new Attendee(tempName, Integer.parseInt(dataSplit[3]));
				attList.add(att);
				numAttendees++;
			
			}
			myReader.close();

			} 
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} 
	}
	public void walkInRegister(){
		if (int j=0;j<100-numAttendees;j++){
			System.out.println("Would you like to register more attendees? y/n");
			Scanner scan = new Scanner(System.in); //handles user inputs
			String newReg = scan.nextLine();
			String fName;
			String lName;
			if (newReg.equals("y")){
				System.out.println("There are currently " + numAttendees + " registered");
				if (numAttendees < 100)
					System.out.println("Enter first name: ");
					fName = scan.nextLine();
					System.out.println("Enter last name: ");
					lName = scan.nextLine();
					System.out.println("Enter your company by ID: ");
					int tempID = Integer.parseInt(scan.nextLine());
					String tempName = fName + " " + lName;
					Attendee att = new Attendee(tempName, tempID);
					attList.add(att);
					System.out.print("Name: " + attList.get(attList.size()-1).getName() + " ,Table ID: " + attList.get(attList.size()-1).getTableID()+ " ,Seat ID: " + attList.get(attList.size()-1).getSeatID() + " \n");
					numAttendees++;
				
				}
				else {
					System.out.println("There are too many attendees, registration has ended");
				}
		
			if (newReg.equals("n")){
				System.out.println("You have chosen not to register");
				break;
			}
		}
		else {
			return "Too many registers, cannot register further";
		}
	}
	
	public int getInfo(int searchCompNum){
		searchNum = searchCompNum;
		for (int i=0;i<attList.size()-1;i++){
			if (attList.get(i).getCompanyID()==searchNum){
				System.out.print("Name: " + attList.get(i).getName() + " ,Table ID: " + attList.get(i).getTableID()+ " ,Seat ID: " + attList.get(i).getSeatID() + " \n");
			}
		}
	}	
}
