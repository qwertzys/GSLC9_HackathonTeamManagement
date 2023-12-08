package Models;
import java.util.ArrayList;
import Repository.*;

public class Team extends Model implements TeamRepository {
	String name;
	int member;
	String teamFilePath = "C:\\Users\\stebb\\Downloads\\Hackathon Team Management GLS CASE STUDY\\Database\\teams.csv";
	//path sesuaikan dengan local path
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Team> find(String column, String[] filter, Boolean join, String table, Connection c){
		ArrayList<Team> teams = new ArrayList<Team>();
		Team t = new Team();
		if(column == null && filter == null && join == null  && table == null && c != null ) {
			return c.readTeam(teamFilePath);
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
		return teams;
	}
	public Team findOne(String column, String[] filter, Boolean join, String table, Connection c) {
		ArrayList<Team> teams = new ArrayList<Team>();
		Team t = new Team();
		
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
				boolean found = false;
				if(column.equalsIgnoreCase("name")) {
					for(Team te : teams) {
						if(te.name.equalsIgnoreCase(filter[1])) {
							found = true;
							break;
						}
						if(found) {
							t.setName(filter[1]);
							t.setId(teams.get(teams.indexOf(t)).id);
						} else {
							return null;
						}
					}
				} else {
					c.readTeam(teamFilePath);
					t.setId(Integer.parseInt(filter[1]));
					t.setName(teams.get(teams.indexOf(t)).name);
				}
			}
		}
		
		
		return t;
	};
	public void Insert(Team t, Connection c ) {
		c.writeTeam(teamFilePath, t);
	};

}
