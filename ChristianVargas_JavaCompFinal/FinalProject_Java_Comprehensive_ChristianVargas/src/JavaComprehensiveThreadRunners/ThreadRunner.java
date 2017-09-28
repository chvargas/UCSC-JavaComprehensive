
package JavaComprehensiveThreadRunners;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * This is a class which implements a separate thread for each runner.
 * 
 * @author Christian Vargas.
 */

public class ThreadRunner extends Thread {

	/** The Constant COURSE_DISTANCE. */
	private static final int COURSE_DISTANCE = 1000;
	
	/** The rand. */
	private Random rand;
	
	/** The runners speed. */
	private double 	runnersSpeed;
	
	/** The rest percentage. */
	private double 	restPercentage;
	
	/** The possition. */
	private int 	possition;	
	
	/** The finished. */
	private static volatile boolean finished;  
	
	/** The obj. */
	private static Object obj = new Object();   
	
	/** The current thread. */
	private Thread currentThread;
	
	/**
	 * Will set the runner thread  .
	 *
	 * @param runnersName the runners name
	 * @param runnersSpeed the runners speed
	 * @param restPercentage the rest percentage
	 */
	
	public ThreadRunner(String runnersName, double runnersSpeed, double restPercentage)
	{
		super(runnersName);  					// Setting thread name
		this.runnersSpeed = runnersSpeed;
		this.restPercentage = restPercentage;
		
		rand = new Random();					// Generating random number setting the seed
		possition = 0;							// Initializing position with 0
		finished = false;						// boolean false to finish
	}

	/**
	 * A loop which will repeat until a runner reaches 1000 m. 
	 * The thread decides whether it should run or rest based on the random number 
	 * and the rest percentage.
	 * 
	 * The class adds the speed value passed to the constructor (RunnersSpeed). 
	 * The first runner to reach 1000 will take the synchronized flag (finished) 
	 * declaring itself as the winner. 
	 */
	@Override
	public void run()
	{
		double n;
		currentThread = Thread.currentThread();
	
		try
		{
			while (finished == false && possition < COURSE_DISTANCE)   // will check condition when winner doesn't exist yet
			{
				n = rand.nextInt(100)+1;   		// random number between range 1 to 100
				if (n > restPercentage)			// If random number is greater than restPercentage runner will move
				{  
					possition += runnersSpeed;
					if (possition < 1000)
					{
						System.out.println(currentThread.getName() + ": " + possition);
					}
					else
						break;
				}
				Thread.sleep(100);  			// rest or end of each move
			}

			// Reached 1000
			synchronized (obj)
			{
				if (finished == false)			// Winner's thread only can execute this block. 
				{  
					finished = true; 	 		// Winner takes the flag
					Thread.sleep(200);  		
					
					//Printing winner 
					System.out.println(currentThread.getName() + ": " + COURSE_DISTANCE);
					System.out.println(currentThread.getName() + ": I finished!\n");
					MarathonRace.finishRace(currentThread.getName()); 
				}
				else 			
					Thread.sleep(1000);
			}
		}
		catch (InterruptedException e)	
		{  
			System.out.println(currentThread.getName() + ": You beat me fair and square.");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
