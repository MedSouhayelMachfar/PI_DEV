package utils;


//Step 1: Use interfaces from java.sql package 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datasource {
	// static reference to itself
	private static Datasource instance = new Datasource();
	public static final String URL = "jdbc:mysql://localhost:3306/projetpi";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static Connection con = null;

	// private constructor
	private Datasource() {
		super();
	} 

	// Methods
	public static Datasource getInstance() {
		return instance;
	}
	
	private static void createConnection() {
		try {
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() {
		if(con == null) {
			createConnection();
		}
		return con;
	}
	
	public static void closeConnection(Connection connection) throws SQLException {
		con.close();
	}

	public static void closeStatement(Statement statement) throws SQLException {
		statement.close();
	}

	public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.close();
	}

	public static void closeResultSet(ResultSet resultSet) throws SQLException {
		resultSet.close();
	}
}
