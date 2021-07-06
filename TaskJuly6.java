package jpmorgan;

//step 1: filter employees from users list
		// step 2: find cost incurred on a project by its employees, it should not go above project budget
		// step 3: release resource from project whose cost incurred gets beyond the budget, 
		// however we should be utilizing maximum budget

import java.util.ArrayList;

class User{
	String id;
	String name;
	
	public User(String id, String name)
	{
		this.id=id;
		this.name=name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"-->"+this.name;
	}
}

class Address{
	private String city;
	private String zipcode;
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
}

class Project{
	int projectId;
	String proj_name;
	double budget;
	double cost;
	
	public Project(String proj_name,int projectId,double budget)
	{
		this.proj_name=proj_name;
		this.projectId=projectId;
		this.budget=budget;
		this.cost=0;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return this.projectId+"-->"+this.proj_name+"-->"+this.budget;
	}
	
}

class here_Employee extends User{
	
	double salary;
	Project pob;
	//address adob;
	public here_Employee(String id,String name,Project p,double salary){
		super(id,name);
		this.salary=salary;
		this.pob=p;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"-->"+this.name;
	}
	
}

class Budget_check
{
	ArrayList <User> emp_lst;
	Budget_check(ArrayList <User> emp_lst)
	{
		this.emp_lst=emp_lst;
	}
	void calculate()
	{
		for(User ele:emp_lst)
		{
			((here_Employee)ele).pob.cost+=((here_Employee)ele).salary;
			System.out.println(((here_Employee) ele).pob.cost);
		
		if(((here_Employee)ele).pob.budget<((here_Employee)ele).pob.cost) {
			System.out.println("Removed employee ID "+((here_Employee)ele).pob.projectId+" from project "+((here_Employee)ele).pob.proj_name);
			emp_lst.remove(ele);
		}
	}}
}

public class TaskJuly6 {
	public static void main(String[] args)
	{
		ArrayList <Project> projects_lst=new ArrayList<>();
		projects_lst.add(new Project("P1",1,1000));
		projects_lst.add(new Project("P2",2,1200));
		projects_lst.add(new Project("P3",3,1500));
		
		ArrayList <User> usr_lst=new ArrayList<>();
		usr_lst.add(new User("101","U1"));
		usr_lst.add(new User("102","U2"));
		usr_lst.add(new here_Employee("103","E1",projects_lst.get(0),400));
		usr_lst.add(new here_Employee("104","E2",projects_lst.get(0),500));
		usr_lst.add(new here_Employee("105","E3",projects_lst.get(0),300));
		usr_lst.add(new here_Employee("106","E4",projects_lst.get(1),800));
		
		//filtering the employees from the list of users
		ArrayList <User> emp_lst=new ArrayList<>();
		
		for(User u:usr_lst)
		{
			if(u instanceof here_Employee)
				emp_lst.add(u);
		}
		
		System.out.println(emp_lst);
		
		Budget_check obj=new Budget_check(emp_lst);
		obj.calculate();
		
	}

}
