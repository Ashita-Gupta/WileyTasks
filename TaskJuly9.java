package MyPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class Address implements Comparable {
	 String city;
	 String zip;
	 int count_users=0;
	 
	public Address(String city,String zip){
		this.city=city;
		this.zip=zip;
	}
	
	public String toString()
	{
		return " city: "+this.city+" zip: "+this.zip;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Address obj=(Address)o;
		
		
		if(this.count_users>obj.count_users)
			return -1;
		else if(this.count_users>obj.count_users)
			return 1;
		else
			return this.zip.compareTo(obj.zip);
	}
}

class User{
	int id;
	String name;
	ArrayList <Address> adr;
	
	public User(int id,String name,ArrayList <Address>adr) {
		this.id=id;
		this.name=name;
		this.adr=adr;
	}
	
	public String toString()
	{
		return " id:"+this.id+" name: "+this.name+" Address: "+this.adr+"\n";
	}
	
}

class Main{
	
	void execute()
	{
		ArrayList <User> User_lst=new ArrayList<>();
		ArrayList <Address> adr_lst = new ArrayList<>();
		
		adr_lst.add(new Address("DEL","110096"));
		adr_lst.add(new Address("DEL","110001"));
		adr_lst.add(new Address("BLR","560001"));
		adr_lst.add(new Address("BLR","560002"));
		adr_lst.add(new Address("BLR","560038"));
		adr_lst.add(new Address("BOM","400037"));
		adr_lst.add(new Address("BOM","400018"));
		
		User_lst.add(new User(3,"User3",new ArrayList<>(Arrays.asList(adr_lst.get(2),adr_lst.get(3),adr_lst.get(1)))));
		User_lst.add(new User(44,"User44",new ArrayList<>(Arrays.asList(adr_lst.get(4),(adr_lst.get(0)),(adr_lst.get(1))))));
		User_lst.add(new User(2,"User2",new ArrayList<>(Arrays.asList(adr_lst.get(6),(adr_lst.get(5)),(adr_lst.get(1)),(adr_lst.get(2))))));

		System.out.println(User_lst);
		
		User_lst.stream().forEach(e->e.adr.stream().forEach(a->a.count_users++));
		
		System.out.println("---------------------------------------------");
		
		TreeMap <Address,ArrayList<User>> map1 = new TreeMap<>();
		
		
		for(int i=0;i<User_lst.size();i++)
		{
			for(int j=0;j<User_lst.get(i).adr.size();j++)
			{
				if(!map1.containsKey(User_lst.get(i).adr.get(j)))
				{
					map1.put(User_lst.get(i).adr.get(j), new ArrayList<>());
					ArrayList <User> userlist2=map1.get(User_lst.get(i).adr.get(j));
					userlist2.add(User_lst.get(i));
					map1.put(User_lst.get(i).adr.get(j),userlist2);
				}
			}
		}
		map1.forEach((K,V)->System.out.println("Address: "+K.city+" "+K.zip+" "+"Users: "+V));
		
	}
	
}

public class TaskJuly9 {
	public static void main(String[] args) {
		Main ob=new Main();
		ob.execute();
	}
}
