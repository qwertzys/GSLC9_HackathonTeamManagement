import java.util.Scanner;
import java.util.ArrayList;
import Models.*;
import Repository.*;
// import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User u = new User();
		Team t = new Team();
		Connection c = new Connection();
		ArrayList<User> au = new ArrayList();
		ArrayList<Team> at = new ArrayList();
		Scanner inp = new Scanner(System.in); // Scanner
		int choice = 1; // default choice mulai dari 0 untuk pilih options
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
					String nim;
					String teamName;
					String newTeam;
					do {
						System.out.println("Which Table to insert?");
						System.out.println("1. User");
						System.out.println("2. Team");
						insertTable = inp.nextInt();
						if (insertTable == 1) {
							System.out.print("Add Name: ");
							name = inp.next();
							u.setName(name);
							System.out.print("Add NIM: ");
							nim = inp.next();
							u.setNim(nim);
							System.out.print("Add Team: ");
							teamName = inp.next();
						} else if (insertTable == 2) {
							System.out.print("Add Team Name: ");
							newTeam = inp.next();
							String[] str = new String[5];
							str[0] = "=";
							str[1] = newTeam;
							if(t.findOne("name", str , false, null, c) != null) {
								System.out.println("name already added");
							} else {
								at = t.find(null, null, null, null, c);
								t.setName(newTeam);
								t.setId(at.get(at.size()-1).getId()+1);
								t.Insert(t, c);
							}
							
							
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
						
						if(showTable == 1) {
							ArrayList<User> au1 = u.find(null, null, null, null, c);
							System.out.println("NIM | Name | Team ID");
							for(User us : au1) {
								System.out.printf("%s | %s | %d\n", us.getNim(), us.getName(), us.getId());
							}
						}else {
							ArrayList<Team> at1 = t.find(null, null, null, null, c);
							System.out.println("ID | Team Name");
							for(Team te : at1) {
								System.out.printf("%d | %s\n",te.getId(),te.getName());
							}
						}
						
						
					} else { // show table sesuai dengan kondisi yang terkasih
						System.out.print("Add condition, separate by semicolon [condition;=;value]: ");
						condition = inp.next();			
						String[] conditionSpl = condition.split(";");
						
						// Butuh function dibawah line ini untuk menunjukkan tabel sesuai dengan kondisi yang dikasih
						
						if(showTable == 1) {
							if(conditionSpl[0].equalsIgnoreCase("nim") ) {
								ArrayList<User> au1 = u.find(null, null, null, null, c);
								System.out.println("NIM | Name | Team ID");
								for(User us : au1) {
									if(conditionSpl[2].equalsIgnoreCase(us.getNim()))
									System.out.printf("%s | %s | %d\n", us.getNim(), us.getName(), us.getId());
								}
							}else if(conditionSpl[0].equalsIgnoreCase("name")) {
								ArrayList<User> au1 = u.find(null, null, null, null, c);
								System.out.println("NIM | Name | Team ID");
								for(User us : au1) 
									if(conditionSpl[2].equalsIgnoreCase(us.getName()))
									System.out.printf("%s | %s | %d\n", us.getNim(), us.getName(), us.getId());
							}else if(conditionSpl[0].equalsIgnoreCase("TeamID")) {
								ArrayList<User> au1 = u.find(null, null, null, null, c);
								System.out.println("NIM | Name | Team ID");
								for(User us : au1) 
									if(conditionSpl[2].equalsIgnoreCase(Integer.toString(us.getId())))
									System.out.printf("%s | %s | %d\n", us.getNim(), us.getName(), us.getId());
							}
						}else {
							if(conditionSpl[0].equalsIgnoreCase("id")) {
								ArrayList<Team> at1 = t.find(null, null, null, null, c);
								System.out.println("ID | Team Name");
								for(Team te : at1) {
									if(conditionSpl[2].equalsIgnoreCase(Integer.toString(te.getId())))
									System.out.printf("%d | %s\n",te.getId(),te.getName());
								}
							}else if(conditionSpl[0].equalsIgnoreCase("TeamName")) {
								ArrayList<Team> at1 = t.find(null, null, null, null, c);
								System.out.println("ID | Team Name");
								for(Team te : at1) {
									if(conditionSpl[2].equalsIgnoreCase(Integer.toString(te.getId())))
									System.out.printf("%d | %s\n",te.getId(),te.getName());
								}
							}
						}
					}
					break;
				}
			}
		}
		System.out.println("Program Exited");
	}
}
