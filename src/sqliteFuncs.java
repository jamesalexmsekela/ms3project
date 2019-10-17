import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqliteFuncs {

	// Declaring a static connection variable
	private static Connection con;
	// Declaring a boolean to let the functions know whether or not the db has data in it 
	private static boolean hasData = false;
	
	// Function that establishes a connection to the db 
	private void startConnection() throws ClassNotFoundException, SQLException{
		// Establishing a connection to a db called "test.db"
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:test.db"); 
		initialise();
	}
	
	// Function that queries into the db to find specified elements
	public ResultSet displayContents() throws ClassNotFoundException, SQLException {
		// Check to see if there is an active connection to a db
		if(con == null) {
			startConnection();
		}
		
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery("SELECT A, B FROM user");
		return res;
	}
	
	// Function in which the user table is created within the identified db
	private void initialise() throws SQLException {
		// Check to see if database is populated
		if(!hasData) {
			hasData = true; 
			
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='user'");
			//Check to see if the result set actually has anything
			if(!res.next()) {
				System.out.println("Currently building table");
				
				//Creating the database table
				Statement state2 = con.createStatement();				
				state2.executeUpdate("CREATE TABLE user(id INTEGER PRIMARY KEY,"
						+ "A TEXT NOT NULL," + "B TEXT NOT NULL,"
						+ "C TEXT NOT NULL," + "D TEXT NOT NULL,"
						+ "E TEXT NOT NULL," + "F TEXT NOT NULL,"
						+ "G TEXT NOT NULL," + "H TEXT NOT NULL,"
						+ "I TEXT NOT NULL," + "J TEXT NOT NULL);");				
				state2.close();
				System.out.println("Built");
				// Users table has been created
			
			}
		}	
	}
	
	// Function that adds users into the db as specified by the given parameters
	public void addUser(int i, String A, String B, String C, String D, String E, String F, String G, String H, String I, String J) throws ClassNotFoundException, SQLException {	
		// Check to see if there is an active connection to a db
		if(con == null) {
			startConnection();
		}
		PreparedStatement prep = con.prepareStatement("INSERT INTO user values(?,?,?,?,?,?,?,?,?,?,?);");
		prep.setInt(1, i);
		prep.setString(2, A);
		prep.setString(3, B);
		prep.setString(4, C);
		prep.setString(5, D);
		prep.setString(6, E);
		prep.setString(7, F);
		prep.setString(8, G);
		prep.setString(9, H);
		prep.setString(10, I);
		prep.setString(11, J);
		prep.executeUpdate();	
	}
	
	
}
