import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Gagnagrunnur {

	//AUKA-T.A.BUA TIL DB
	public static void createDB(String fileName) {
	    
        try {
        	Class.forName("org.sqlite.JDBC");
        	//N�r gagnagrunnur b�inn til ef hann er ekki til n� �egar.
        	Connection connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
        	System.out.println("Ekki tókst að búa til gagnagrunn");
        }
	}
	
	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("org.sqlite.JDBC");
		createDB("prufa2.db");

	}
}