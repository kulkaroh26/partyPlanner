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
	
	
	ArrayList<Attendee> attList = new ArrayList<Attendee>();
	//constructors
	public Partay (int table, int seat){
		newTable = table;
		newSeat = seat;
		int counter = 0;
		int tempCompID;
		String tempName;
		Attendee[][] seating = new Attendee[table][seat]; //2d array for seats and tables, first array is tables, second array is seats. It will store the company ID for each seat and table as a checker, not the attendee objects themselves
		//the table and seat values will be stored as variables and accessed through getter methods, not the array itself
		Scanner scan = new Scanner(System.in);
		try {
			File myObj = new File("partyguests.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] dataSplit = data.split(",");
				tempName = dataSplit[2] + " " + dataSplit[1];
				Attendee att = new Attendee(tempName, Integer.parseInt(dataSplit[3]));
				tempCompID = Integer.parseInt(dataSplit[3]);
				attList.add(att);
				numAttendees++;
				/*for (int x=0;x<table-1;x++){
					boolean checkCompany = false;
					for (int y=0;y<seat-1;y++){
						if (seating[x][y]!=null){
							y++;
						}
						for (int z=0;z<seat-1;z++){
							if (seating[x][z]==null){
							}
							else if (seating[x][z].getCompanyID()==tempCompID){
								checkCompany=true;
								break;
							}
						}
						if (checkCompany==true){
							break; 
						}
						if (checkCompany==false){
							seating[x][y]=att;
							att.setSeatID(y);
							att.setTableID(x);
							System.out.print("Table: " + x + ", Seat: " + y + ", Name: " + tempName + "\n");
							break;
						}
					}
				}*/
			//myReader.close();
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} 
		int numPrint = 0;
		int compMax = 0;
		int checker = 0;
		for (int g=0;g<attList.size()-1;g++){ //if there are more than 10 people per company, this removes everybody after 10 people
			
			if (attList.get(g).getCompanyID()==attList.get(g+1).getCompanyID()){
				//System.out.print("same ID");
				compMax++;
				System.out.println(compMax + " #: " + g);
			}
			else
			{
				compMax = 0;
			}
			if (compMax >=9){
				compMax = 0;
				System.out.println("Should Remove");
				if (attList.get(g).getCompanyID()==attList.get(g-1).getCompanyID()){
					//System.out.print(attList.get(g));
					attList.remove(g);
					//System.out.print(attList.get(g));
					
				}
			}
		}
		numAttendees = attList.size();
		for (int x=0;x<table;x++){
					boolean checkCompany = false;
					int compCounter = 0;
					for (int y=0;y<seat;y++){
						counter = 0;
						/*if (attList.get(counter).getCompanyID()==attList.get(counter+1).getCompanyID()){
									compCounter++;
								}
							if (compCounter==10){
									counter++;
									break;
								}*/
						if (x==table-1){
								while (attList.get(counter).getCompanyID()!=attList.get(counter+1).getCompanyID()){
									counter++;
								}
							}	
						while (seating[x][y] == null){
							for (int d=0;d<attList.size();d++){
								if (attList.get(d).getSeatID()==-1){
									//System.out.println("X: " + x + ", Y: " + y + ", v: " + v);
									break;
								}
								else{
									counter++;
									
								}
							}
							//System.out.println("AttList size: " + attList.size());
							if (counter >= attList.size()){
								break;
							}
							for (int z=0;z<seat-1;z++){
								if (seating[x][z]==null){
								}
								
								else if (seating[x][z].getCompanyID()==attList.get(counter).getCompanyID()){
									checkCompany=true;
									
								}
							}						
							if (checkCompany==false){
								seating[x][y]=attList.get(counter);
								attList.get(counter).setSeatID(y);
								attList.get(counter).setTableID(x);
								System.out.print("Table: " + attList.get(counter).getTableID() + ", Seat: " + attList.get(counter).getSeatID() + ", Name: " + attList.get(counter).getName() + ", Company ID: " + attList.get(counter).getCompanyID() + ", X: " + x + ", Y: "+y+"\n");
								x=0;
								numPrint++;
								
							}
							//counter++;
						}
					}
				}
		//System.out.print(numAttendees);
		System.out.print(numPrint);
		System.out.print(counter);
		}
		

	public void walkInRegister(){
		if (numAttendees<(newTable*newSeat)){
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
			}
		}
		else {
			System.out.print("Too many registers, cannot register further");
		}
	}
	
	public void getInfo(int searchCompNum){
		searchNum = searchCompNum;
		for (int i=0;i<attList.size()-1;i++){
			if (attList.get(i).getCompanyID()==searchNum){
				System.out.print("Name: " + attList.get(i).getName() + " ,Table ID: " + attList.get(i).getTableID()+ " ,Seat ID: " + attList.get(i).getSeatID() + " \n");
			}
		}
	}	
}
