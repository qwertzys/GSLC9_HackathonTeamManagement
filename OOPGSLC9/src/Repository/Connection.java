package Repository;
import Models.*;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Connection {
	
	public static ArrayList<User> readUser(String filePath) {
		BufferedReader reader = null;
		ArrayList<User> user = new ArrayList();
		try {
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			line = reader.readLine();
			
			while((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				
				User u = new User();
				u.setNim(fields[0]);
				u.setName(fields[1]);
				u.setId(Integer.parseInt(fields[2]));
				user.add(u);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public static ArrayList<Team> readTeam(String filePath) {
		BufferedReader reader = null;
		ArrayList<Team> team = new ArrayList<Team>();
		
		try {
			String line = "";
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();
			
			while((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				
				Team t = new Team();
				t.setId(Integer.parseInt(fields[0]));
				t.setName(fields[1]);
				team.add(t);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return team;
	}
	
	public static void writeUser(String filePath, User u) {
		FileWriter fileWriter = null;
		
		try {
			fileWriter.append(u.getNim());
			fileWriter.append(",");
			fileWriter.append(u.getName());
			fileWriter.append(",");
			fileWriter.append(String.valueOf(u.getId()));
			fileWriter.append("\n");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeTeam(String filePath, Team t) {
		FileWriter fileWriter = null;
		
		try {
			fileWriter.append(String.valueOf(t.getId()));
			fileWriter.append(",");
			fileWriter.append(t.getName());
			fileWriter.append("\n");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
