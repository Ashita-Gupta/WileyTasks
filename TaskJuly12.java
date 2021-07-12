package MyPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class EmployeeService implements Runnable{

	private List<Integer> myintlst =Collections.emptyList();
	@Override
	public void run() {
		myintlst=new ArrayList<>();
		for(int i=10;i>=0;i--)
		{
			if (myintlst.contains(i))
				;
			else
			{myintlst.add(i);
			try {
				Thread.sleep(1000);  
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}}
		
	}
	public List<Integer> getintlist()
	{
		return myintlst;
	}
	
}


public class TaskJuly12 {
	public static void main(String[] args) {
		EmployeeService eth1=new EmployeeService();
		Thread et1=new Thread(eth1);
		Thread et2=new Thread(eth1);
		et1.start();
		et2.start();
	}

}
