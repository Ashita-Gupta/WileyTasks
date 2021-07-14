package NewPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Projects{
	int proj_id;
	String proj_name;
	
	Projects(int id,String proj_name)
	{
		this.proj_id=id;
		this.proj_name=proj_name;
	}
	
	@Override
	public String toString() {
		return "projId: "+this.proj_id +" projName: "+ this.proj_name;
	}
}

class Users {
	int user_id;
	String user_name;
	ArrayList <Projects> proj_lst;
	
	Users(int user_id, String user_name, ArrayList <Projects> proj_lst)
	{
		this.user_id=user_id;
		this.user_name=user_name;
		this.proj_lst=proj_lst;
	}
	
	@Override
	public String toString() {
		return "userId: "+this.user_id +" userName: "+ this.user_name;
	}
	
	public void print()
	{
		System.out.println("userId: "+this.user_id +" userName: "+ this.user_name+" "+"projects: "+this.proj_lst);

	}
}


class OperationOne implements Runnable{
	
	volatile ArrayList <Users> User_lst;
	volatile ArrayList <Projects> proj_lst;
	
	public OperationOne(ArrayList <Users> User_lst,ArrayList <Projects> proj_lst)
	{
		this.User_lst=User_lst;
		this.proj_lst=proj_lst;
	}
	
	
	@Override
	public void run() {
		
		proj_lst.add(new Projects(1,"proj1"));
		proj_lst.add(new Projects(2,"proj2"));
		proj_lst.add(new Projects(3,"proj3"));
		
		User_lst.add(new Users(101,"User1",new ArrayList<>(Arrays.asList(proj_lst.get(0),proj_lst.get(1)))));
		User_lst.add(new Users(102,"User2",new ArrayList<>(Arrays.asList(proj_lst.get(1),proj_lst.get(2)))));
		
	}
	
	public void getlist()
	{
		System.out.println(proj_lst);
		System.out.println("-----------------------------------------------------------");
		
		
		for(Users u: User_lst)
			u.print();
			System.out.println("-----------------------------------------------------------");
	}
	
}

class OperationTwo implements Runnable{
	
	ArrayList <Users> User_lst;
	HashMap <Users,ArrayList<Projects>> mappp;
	
	public OperationTwo(ArrayList <Users> User_lst,HashMap <Users,ArrayList<Projects>> mappp)
	{
		this.User_lst=User_lst;
		this.mappp=mappp;
	}

	@Override
	public void run() {
		synchronized (this)
		{
			for(Users u:User_lst)
			{
				mappp.put(u, u.proj_lst);
			}
			this.notify();
		}
	}
	
	public void getMap()
	{
		System.out.println(mappp);
		System.out.println("-----------------------------------------------------------");
	}
	
}

public class Task3July12_ListToMap_threads {
	
	public static void main(String[] args) throws InterruptedException {
	
	ArrayList <Users> User_lst = new ArrayList<>();
	ArrayList <Projects> proj_lst = new ArrayList<>();
	HashMap <Users,ArrayList<Projects>> mappp=new HashMap<>();
	
	OperationOne obj1=new OperationOne(User_lst,proj_lst);
	Thread t1=new Thread(obj1,"t1");
	Thread t11=new Thread(obj1,"t11");
	
	
	OperationTwo obj2=new OperationTwo(User_lst,mappp);
	Thread t2=new Thread(obj2,"t2");
	Thread t22=new Thread(obj2,"t22");
	
	t1.start();
	t11.start();
	t2.start();
	t22.start();
	
	synchronized(t1)
	{
		t1.wait();
		obj1.getlist();
		
	}
	
	synchronized(t2)
	{
		t2.wait();
		obj2.getMap();
	}
	
	
	
	
	/*
	
	System.out.println(proj_lst);
	System.out.println("-----------------------------------------------------------");
	
	for(Users u: User_lst)
	u.print();
	System.out.println("-----------------------------------------------------------");

	System.out.println(mappp);
	System.out.println("-----------------------------------------------------------");
*/
}
}
