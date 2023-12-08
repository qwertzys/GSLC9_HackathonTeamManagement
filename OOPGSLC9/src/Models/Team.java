package Models;
import java.util.ArrayList;
import Repository.*;

public class Team extends Model implements TeamRepository {
	String name;
	int member;
	String teamFilePath = "";
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Team> find(){
		
	}
	public Team findOne() {
		
	};
	public Team Insert() {
		
	};

}
