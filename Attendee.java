/**
 * Attendee.java Class for creating attendee objects in Party Planner
 * 
 * Preconditions: txt file to import attendee objects
 * Postconditions: generates an attendee object with name, tableID, tablePos, and companyID 
*/

public class Attendee{
	private String name;
	private int tableID;
	private int seatID;
	private int companyID;
	
	public Attendee (String attName, int compID){
		name = attName;
		tableID = -1;
		seatID = -1;
		companyID = compID;
	}
	
	//Getters and Setters
	
	//toString
	//getAttendee
	//getTableID
	public int getTableID(){
		return tableID;
	}
	//getSeatID
	public int getSeatID(){
		return seatID;
	}
	//getCoID
	public int getCompanyID(){
		return companyID;
	}
	//setTableID
	public void setTableID(int newTable){
		tableID = newTable;
	}
	//setSeatID
	public void setSeatID(int newSeat){
		seatID = newSeat;
	}
	public String getName(){
		return name;
	}
}
