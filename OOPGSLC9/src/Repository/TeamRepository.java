package Repository;
import java.util.ArrayList;
import Models.Team;

public interface TeamRepository {
	public ArrayList<Models.Team> find();
	public Models.Team findOne();
	public Models.Team Insert();
}
