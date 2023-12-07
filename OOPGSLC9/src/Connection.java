import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Class ini tujuannya adalah:
// a. membuka file .csv
// b. membaca file .csv
// c. menulis ke dalam file .csv

public class Connection {

    private CSVParser csvParser;

    public Connection(String filePath) {
        try {
            Reader reader = new FileReader(filePath);
            this.csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CSVParser getCsvParser() {
        return csvParser;
    }

	String filePathUser = "https://github.com/qwertzys/GSLC9_HackathonTeamManagement/blob/main/OOPGSLC9/src/user.csv";
	String filePathTeam = "https://github.com/qwertzys/GSLC9_HackathonTeamManagement/blob/main/OOPGSLC9/src/teams.csv";
	
}
