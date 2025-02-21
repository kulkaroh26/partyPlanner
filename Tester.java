import java.util.ArrayList; //import for Array Lists
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
public class Tester {
	public static void main (String[] args){
		
		/*int numAttendees = 0;
		
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
		
		System.out.println("Would you like to register more attendees? y/n");
		Scanner scan = new Scanner(System.in); //handles user inputs
		String newReg = scan.nextLine();
		if (newReg.equals("y"){
			System.out.println("There are currently " + numAttendees + " registered");
			if (numAttendees < 100){
				for (int i=0;i<100-numAttendees;i++){
					
				}
			}
			else {
				
			}
		}
		if (newReg.equals("n"){
			System.out.println("You have chosen not to register");
		}
		else {
			System.out.print("Please enter a valid input");
		}		
		
		
		
		Attendee a1 = new Attendee("Mr Posh", 12);
		attList.add(a1);
		Attendee a2 = new Attendee("Ms Posh", 13);
		attList.add(a2);
		Attendee a3 = new Attendee("Mr Nico", 14);
		attList.add(a3);
		System.out.println(attList.get(2).getCompanyID());
		attList.get(2).setTableID(5);
		System.out.println("Table ID: " + attList.get(2).getTableID());
		
		System.out.println("Search for Table ID: ");
		
		int searchNum = 13;
		for (int i=0;i<attList.size()-1;i++){
			if (attList.get(i).getCompanyID()==searchNum){
				System.out.print("Name: " + attList.get(i).getName() + " ,Table ID: " + attList.get(i).getTableID()+ " ,Seat ID: " + attList.get(i).getSeatID());
			}
		}*/
		
		Partay p1 = new Partay(10, 10);
		
	}
}
