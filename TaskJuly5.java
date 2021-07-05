package jpmorgan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee {
	String name;
	int salary;
	String city;
	
	Employee(String n,int s,String city)
	{
		name=n;
		salary=s;
		this.city=city;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}

//Comparator is for sorting on multiple attributes
class sortEmployee implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Employee ob1=(Employee)o1;
		Employee ob2=(Employee)o2;
		
		//first sorting
		if((ob1.salary-ob2.salary)!=0)
			return ob1.salary-ob2.salary;
		
		//second sorting
		return ob1.city.compareTo(ob2.city); //sorting by city
		//return ob2.city.compareTo(ob1.city); //reverse sorting by city
		//return ob1.salary-ob2.salary; //sorting by salary
		//return ob2.salary-ob1.salary; //reverse sorting by salary
	}
	
}



public class TaskJuly5 {
	public static void main(String[] args) throws IOException {
		
		ArrayList <Employee> ls=new ArrayList<>();
		ls.add(new Employee("E1",10000,"PUNE"));
		ls.add(new Employee("E2",21000,"BOMBAY"));
		ls.add(new Employee("E3",10000,"JAIPUR"));
		
		Collections.sort(ls,new sortEmployee());
		
		System.out.println(ls);
		
	}

}
