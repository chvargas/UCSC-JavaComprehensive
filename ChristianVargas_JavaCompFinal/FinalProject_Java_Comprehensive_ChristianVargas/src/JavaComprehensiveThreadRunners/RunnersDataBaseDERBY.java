package JavaComprehensiveThreadRunners;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// TODO: Auto-generated Javadoc
/**
 * This class reads runners data from the derby database(RunnersDB)
 * creating thread runners and objects .
 *
 * @author Christian Vargas.
 */
public class RunnersDataBaseDERBY {
	
	/** The run list. */
	private RunnersList runList;
	
   /**
    * Class constructor.
    *
    * @param runList An instance of RunnersList class to hold all runners objects
    */
	
	public RunnersDataBaseDERBY(RunnersList runList)
	{
		this.runList = runList;
	}
	
   /**
    * Getting connection to DERBY DATABASE. 
    * 
    * @return	Connection object from DERBY DATABASE
    */
	
	private Connection getConnection()
	{
		Connection connect = null;
		
		try
		{
			String dbDirectory = "Resources";
			System.setProperty("derby.system.home", dbDirectory);
			String url = "jdbc:derby:RunnersDB";
			String username = "";
			String password = "";
			connect = DriverManager.getConnection(url, username, password);
			return connect;
		}
		catch (SQLException e)
		{
			for (Throwable t: e)
				t.printStackTrace();	
			return null;
		}
	}
	
   /**
    * Shutdown connection from database .
    *
    * @return TRUE Boolean when connection was closed satisfyingly
    */
	
	private boolean disconnect()
	{
		try
		{
			String shutdownURL = "jdbc:derby:RunnersDB;shutdown=true";
			DriverManager.getConnection(shutdownURL);
		}
		catch (SQLException e){
			if (e.getMessage().equals("Database 'RunnersDB' shutdown."))
			{
				return true;
			}
		}
		return false;
	}
	
   /**
    * Creates runners from derby database.
    * 
    * @return	True if runners created successfully from the derby database
    */	
	
	public boolean createRunnersDB(){
		String query = "SELECT * FROM RunnersStats";
		
		try	
		{
			Connection conn = getConnection();
			if (conn != null)
			{
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					String runnersName = rs.getString("Name");
					double runnersSpeed = rs.getDouble("RunnersSpeed");
					double restPercentage = rs.getDouble("RestPercentage");
					runList.addRunner(runnersName, runnersSpeed, restPercentage);
				}
				rs.close();
				return true;
			}
			return false;
			
		}
		catch (SQLException e)
		{
			System.err.println(e);
			return false;
		}		
		finally
		{
			disconnect();
		}
	}
}