
public class Adder implements Runnable {

	int[] list;
	long added = 0;
	long number;
	long total;
	
	public Adder(int[] list,long number,long total){
		this.list = list;
		this.number=number;
		this.total=total;
	}
	
	
	
	
	public long getAdded(){
		
		return added;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
			for(int i = (int)(list.length*number/total);i<(list.length*(number+1))/total;i++)
			{
				
				added+=Math.sqrt(list[i]);
				added+=Math.sqrt(list[i]);
				added+=Math.sqrt(list[i]);
				added+=Math.sqrt(list[i]);
				added+=Math.sqrt(list[i]);
				added+=Math.sqrt(list[i]);
				added+=Math.sqrt(list[i]);
				added+=Math.sqrt(list[i]);
				
			}
		
		
		
		
		
		
		
		
		
	}
}
