import java.util.Scanner;
import java.util.ArrayList;
// import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hackerInfo hacker = new hackerInfo();
		ArrayList<String> teams = new ArrayList();
		// ArrayList<String> hacker = new ArrayList();
		Scanner inp = new Scanner(System.in); // Scanner
		int choice = 0; // default choice mulai dari 0 untuk pilih options
		while (choice != 4) { // Loop Menu utama terus sampe kena exit
			// Menu Utama
			System.out.println("1. Menu Utama");
			System.out.println("2. Insert Data");
			System.out.println("3. Show");
			System.out.println("4. Exit");
			System.out.println("Select the following option: ");
			choice = inp.nextInt(); // scan integer
			// testing untuk github doang, ignore this line
			// Menjalankan program berdasarkan pilihan choice
			switch(choice) {
				case 1: { // Menampilkan menu utama awal program
					break;
				}
				
				case 2: { // Insert Data
					int insertTable = 0;
					String name;
					int nim;
					String teamName;
					String newTeam;
					do {
						System.out.println("Which Table to insert?");
						System.out.println("1. User");
						System.out.println("2. Team");
						insertTable = inp.nextInt();
						if (insertTable == 1 && !teams.isEmpty()) {
							System.out.print("Add Name: ");
							name = inp.next();
							System.out.print("Add NIM: ");
							nim = inp.nextInt();
							System.out.print("Add Team: ");
							teamName = inp.next();
						} else if (insertTable == 2) {
							System.out.print("Add Team Name: ");
							newTeam = inp.next();
							teams.add(newTeam);
						} else {
							System.out.println("Invalid Option, try again");
						}
					} while (insertTable != 1 && insertTable != 2);
					
					// butuh function untuk insert data kepada csv dibawah line ini
					
					break;
				}
				
				case 3: { // Menunjukkan tabel 
					int showTable = 0;
					int conditionChoice = 0;
					String condition;
					
					do {
						System.out.println("Which Table to Show?");
						System.out.println("1. User");
						System.out.println("2. Team");
						showTable = inp.nextInt();	
					} while (showTable != 1 && showTable != 2);
					
					do {
						System.out.println("Want to filter by condition?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						conditionChoice = inp.nextInt();
					} while (conditionChoice != 1 && conditionChoice != 2);
					
					if (conditionChoice == 2) {
						// show semua table
						// Butuh function untuk menunjukkan semua table
					} else { // show table sesuai dengan kondisi yang terkasih
						System.out.print("Add condition, seperate by semicolon [condition;=;value]: ");
						condition = inp.next();				
						// Butuh function dibawah line ini untuk menunjukkan tabel sesuai dengan kondisi yang terkasih
					}
						
					
					break;
				}
				
				// default ini ignore aja, lagi testing
//				default: { // kalau pilih nomor lain
//					System.out.println("Invalid Option, please try again");
////					inp.next();
//					break;
//				}
			}
		}
		
		System.out.println("Program Exited");
	}
}
