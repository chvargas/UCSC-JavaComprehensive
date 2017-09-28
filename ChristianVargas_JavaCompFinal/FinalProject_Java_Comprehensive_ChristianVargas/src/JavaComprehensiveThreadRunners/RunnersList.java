
package JavaComprehensiveThreadRunners;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * A class to handle ThreadRunner instances. The class instance is shared by RunnersDAO and RunnersFileIO classes.
 * @author Christian Vargas.
 */

public class RunnersList 
{
	
	/** The runners. */
	private ArrayList <ThreadRunner> runners;

	/**
	 * Constructor.
	 */
	public RunnersList()
	{
		runners = new ArrayList<>();
	}
	
   /**
    * Gets the runners.
    *
    * @return A list of ThreadRunners instances
    */
	public ArrayList <ThreadRunner> getRunners()
	{
		return runners;
	}
	
   /**
    * Gets the default runners.
    *
    * @return Default ThreadRunners List instances
    */ 
	public ArrayList <ThreadRunner> getDefaultRunners()
	{
		ThreadRunner th1 = new ThreadRunner("Tortoise", 10, 0);
		ThreadRunner th2 = new ThreadRunner("Hare", 100, 90);
		runners.add(th1);
		runners.add(th2);
		return runners;
	}
	
   /**
    * Will create ThreadRunner instance which will be added to the list.
    *
    * @param runnersName 				String runner's name
    * @param runnersSpeed the runners speed
    * @param runnersRestPercentage the runners rest percentage
    */ 
	public void addRunner(String runnersName, double runnersSpeed, double runnersRestPercentage)
	{
		ThreadRunner th = new ThreadRunner(runnersName, runnersSpeed, runnersRestPercentage);
		runners.add(th);
	}

   /**
    * Clear runners list.
    */ 
	public void clearRunners()
	{
		runners.clear();
	}
	
}