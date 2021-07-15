package NewPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Myfibo implements Callable<List<Integer>>{
	
	int n;
	List <Integer> ls;
	public Myfibo(int n, List <Integer> ls)
	{
		this.n=n;
		this.ls=ls;
	}

	@Override
	public List <Integer> call() throws Exception {
		int a=0,b=1,c;
		int sum=a+b;
		ls.add(a);
		ls.add(b);
		
		for(int i=2;i<=n;i++)
		{
			c=a+b;
			ls.add(c);
			sum=sum+c;
			a=b;
			b=c;
		}
		System.out.println("Sum of "+n+" terms of fibonacii series is "+sum);
		return ls;
	}
	
}

public class fibo_exec {
	public static void main(String[] args) {
		
		List <Integer> ls = new ArrayList<>();
		
		ExecutorService exec = Executors.newSingleThreadExecutor();
		Myfibo obj = new Myfibo(10,ls);
		Future <List<Integer>> callfuture = exec.submit(obj);
		 if(callfuture.isDone())
		 {
			 try {
				System.out.println(callfuture.get());
			}catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		 }
	/*	 try {
			System.out.println(callfuture.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 exec.shutdown();
		 
	}
}
