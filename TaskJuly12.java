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
			if (Thread.currentThread().getName().equals("thread1") && i%2==0)
			{	myintlst.add(i);}
			else if(Thread.currentThread().getName().equals("thread2") && i%2!=0)
			{myintlst.add(i);}
			//System.out.println(Thread.currentThread().getName()+" "+i);
		}
	//	System.out.println(myintlst);
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
		et1.setName("thread1");
		et1.setName("thread2");
		et1.start();
		et2.start();
		//eth1.getintlist().forEach(in->System.out.println("INT - "+in));
		System.out.println(eth1.getintlist());
	}

}
