import java.util.ArrayList;

import edu.princeton.cs.algs4.Stopwatch;

public class AdderMain {

	
	public static void main(String[] args) throws InterruptedException{
		
		long addedTraditionally = 0;
		long addedThreadily = 0;
		int numThreads = 4;
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		ArrayList<Adder> adderList = new ArrayList<Adder>();
		
		int[]list = new int[100000000];
		for(int i = 0;i<list.length;i++)
			list[i] = i;

		for(int i = 0;i<numThreads;i++)
		{
			Adder newAdder = new Adder(list,i,numThreads);	
			adderList.add(newAdder);
		}
		for(int i = 0;i<numThreads;i++)
		{
			Thread newThread = new Thread(adderList.get(i));
			threadList.add(newThread);
		}
		
	
		//n thread add
		long startingTimeQuadra = System.currentTimeMillis();
		for(Thread t:threadList)
		{
			t.start();
		}
		
		for(Thread t:threadList)
		{
			t.join();
			
			
		}
	
		for(Adder a:adderList)
		{
			addedThreadily+=a.getAdded();
			//System.out.println(a.getAdded());
			System.out.println("startIndex="+(list.length*a.number)/a.total + ", endIndex="+(list.length*(a.number+1))/a.total);
		}
		long endTimeQuadra = (System.currentTimeMillis()-startingTimeQuadra);
		
		System.out.println(numThreads + " THREADS: " + "Sum is " + addedThreadily + " with time of " + endTimeQuadra);
		
		//traditional add
		long secondStartingTime= System.currentTimeMillis();
		for(int i = 0;i<list.length;i++)
		{
			addedTraditionally+=Math.sqrt(list[i]);
			addedTraditionally+=Math.sqrt(list[i]);
			addedTraditionally+=Math.sqrt(list[i]);
			addedTraditionally+=Math.sqrt(list[i]);
			addedTraditionally+=Math.sqrt(list[i]);
			addedTraditionally+=Math.sqrt(list[i]);
			addedTraditionally+=Math.sqrt(list[i]);
			addedTraditionally+=Math.sqrt(list[i]);
		}
		long secondEndTime = (System.currentTimeMillis()-secondStartingTime);
		System.out.println("TRADITIONAL: " + "Sum is " + addedTraditionally + " with time of " + secondEndTime);	
		
		
		
	}
	
	
	
	
}
