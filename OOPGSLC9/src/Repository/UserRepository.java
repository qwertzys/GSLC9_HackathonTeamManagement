package Repository;
import java.util.ArrayList;
import Models.User;

public interface UserRepository {
	public ArrayList<Models.User> find();
	public Models.User findOne();
	public Models.User insert();
}
