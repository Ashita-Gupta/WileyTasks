package MyPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FibonaciiSum extends Thread{
	int n;
	List <Integer> ls=ls = new ArrayList<>();;
	FibonaciiSum(int n)
	{
		this.n=n;
	}
	@Override
	public void run() {
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
		System.out.println(ls);
	}
	
	public List<Integer> getintlist()
	{
		return ls;
	}}

class FiboTwo extends Thread{ 
	
	List <Integer> ls=new ArrayList<>();
	List <String> mylst=new ArrayList<>();
	
	public FiboTwo(List<Integer> ls)
	{
		this.ls=ls;
	}
	
	@Override
	public void run() {
		int i;
		for(i=0;i<ls.size()-2;i++)
		{
			mylst.add(ls.get(i)+" + "+ ls.get(i+1)+" = "+ls.get(i+2)+"\n");
		}
		mylst.add(ls.get(i)+" + "+ ls.get(i+1)+" = "+ (ls.get(i)+ls.get(i+1))+"\n");
		int su=ls.get(i)+ls.get(i+1);
		i++;
		mylst.add(ls.get(i)+" + "+ su+" = "+ (ls.get(i)+su)+"\n");
		System.out.println(mylst);
	}
}

public class Task2July12_fibonacii_threads {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number: ");
		int n=sc.nextInt();
		
		List lst=new ArrayList<>();
		
		FibonaciiSum ft=new FibonaciiSum(n);
		ft.start();

		FiboTwo ft2 = new FiboTwo(ft.ls);
		ft2.start();
		
	}

}
