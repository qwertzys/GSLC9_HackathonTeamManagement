package Models;
import java.util.ArrayList;
import Repository.*;

public class User extends Model implements UserRepository {
	String name;
	String nim;
	String userFilePath = "C:\\Users\\stebb\\Downloads\\Hackathon Team Management GLS CASE STUDY\\Database\\user.csv";
	//path sesuaikan dengan local path
	public void setName(String name) {
		this.name = name;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	
	public String getName() {
		return name;
	}
	public String getNim() {
		return nim;
	}
	
	public ArrayList<User> find(String column, String[] filter, Boolean join, String table, Connection c){
		ArrayList<User> users = new ArrayList<User>();
		if(column == null && filter == null && join == null  && table == null && c != null ) {
			return c.readUser(userFilePath);
		} else if(column != null && filter == null) {
			System.out.println("error, please input the right value");
			return null;
		} else if(column == null && filter != null) {
			System.out.println("error, please input the right value");
			return null;
		} else if(join == true && table == null) {
			System.out.println("error, please input the right value");
			return null;
		} else if(join == null && table != null) {
			System.out.println("error, please input the right value");
			return null;
		} else {
			
		}
		return users;
	};
	public User findOne(String column, String[] filter, Boolean join, String table, Connection c){
		ArrayList<User> users = new ArrayList<User>();
		User u = new User();
		if(column != null && filter == null) {
			System.out.println("error, please input the right value");
			return null;
		} else if(column == null && filter != null) {
			System.out.println("error, please input the right value");
			return null;
		} else if(join == true && table == null) {
			System.out.println("error, please input the right value");
			return null;
		} else if(join == null && table != null) {
			System.out.println("error, please input the right value");
			return null;
		} else {
			if(filter[0] == "=" ) {
				if(column.equalsIgnoreCase("name")) {
					c.readUser(userFilePath);
					u.setName(filter[1]);
					u.setId(users.get(users.indexOf(u)).id);
					u.setNim(users.get(users.indexOf(u)).nim);
				} else if(column.equalsIgnoreCase("nim")) {
					c.readUser(userFilePath);
					u.setNim(filter[1]);
					u.setId(users.get(users.indexOf(u)).id);
					u.setName(users.get(users.indexOf(u)).name);
				} else {
					c.readUser(userFilePath);
					u.setId(Integer.parseInt(filter[1]));
					u.setNim(users.get(users.indexOf(u)).nim);
					u.setName(users.get(users.indexOf(u)).name);
				}
			}
		}
		return u;
	};
	public void insert(String[] fields, Connection c ){
		User u = new User();
		u.setName(fields[0]);
		u.setNim(fields[1]);
		u.setId(1);
		c.writeUser(userFilePath, u);
	};
	

}
