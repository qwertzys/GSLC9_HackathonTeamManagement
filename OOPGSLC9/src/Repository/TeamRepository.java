package Repository;
import java.util.ArrayList;
import Models.Team;

public interface TeamRepository {
	public ArrayList<Team> find(String column, String[] filter, Boolean join, String table, Connection c);
	public Team findOne(String column, String[] filter, Boolean join, String table, Connection c);
	public void Insert(Team t, Connection c);
}
