package Models;
import java.util.ArrayList;
import Repository.*;

public class User extends Model implements UserRepository {
	String name;
	String nim;
	String userFilePath = "";
	
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
	
	public ArrayList<User> find(){
		
	};
	public User findOne(){
		
	};
	public User insert(){
		
	};
	

}
