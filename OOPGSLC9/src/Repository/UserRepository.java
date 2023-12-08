package Repository;
import java.util.ArrayList;
import Models.User;

public interface UserRepository {
	public ArrayList<User> find(String column, String[] filter, Boolean join, String table, Connection c);
	public User findOne(String column, String[] filter, Boolean join, String table, Connection c);
	public void insert(String[] fields, Connection c );
}
