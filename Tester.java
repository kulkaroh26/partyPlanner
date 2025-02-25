import java.util.ArrayList; //import for Array Lists
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
public class Tester {
	public static void main (String[] args){
		int x = 0;
		int y = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number of tables at the event: ");
		x = scan.nextInt();
		System.out.println("Please enter the number of seat at the event: ");
		y = scan.nextInt();
		Partay p1 = new Partay(10, 10);
		System.out.print("\n");
		//while (true){
			System.out.println("What would you like to do? \n 1. Register more attendees \n 2. Print rosters by table \n 3. Print roster by company \n 4. Find person's table and seat # \n 5. Quit program");
			int option = scan.nextInt();
			if (option==1){
				p1.walkInRegister();
			}
			if (option==2){
				System.out.print("What table do you want to print rosters for?");
				
			}
		//}
	}
}
