package jpmorgan;
import java.util.ArrayList;
import java.util.Scanner;

	public class taskA {
		
		ArrayList<String> namee=new ArrayList<String>();
		//String[] namee=new String[10];
		ArrayList<String> dess=new ArrayList<String>();
		//String[] dess=new String[10];
		ArrayList<Double> sall=new ArrayList<Double>();
		//double[] sall=new double[10];
		ArrayList<Integer> agee=new ArrayList<Integer>();
		//int[] agee=new int[10];
		ArrayList<String> empid=new ArrayList<String>();
		//String[] empid=new String[10];
		int k=0,l=0,m=0,o=0,z=0;

			public void show_menu()
			{
				System.out.println("*********************");
				System.out.println("Press 1 for Create: ");
				System.out.println("Press 2 for display: ");
				System.out.println("Press 3 for Salary raise: ");
				System.out.println("Press 4 to delete employees");
				System.out.println("Press 5 for Exit: ");
				//System.out.println();
				System.out.println("Enter your choice: ");
			}
			
			public int checknam(String name)
			{
				int l=name.length();
				int c=0;
				for(int i=0;i<l;i++)
				{
					if(name.charAt(i)==' ')
						c++;
				}
				if(c>2)
					return 0;
				else
					return 1;
			}
			
			public int checkdes(String des)
			{
				if(des.equalsIgnoreCase("Programmer") || des.equalsIgnoreCase("Manager") || des.equalsIgnoreCase("Tester"))
					return 1;
				else
					return 0;
			}
			
			public int checkage(int age)
			{
				if(age<18 || age>60)
					return 0;
				else
					return 1;
			}
			
			public String inputname()
			{
				Scanner sc=new Scanner(System.in);
				String name=sc.nextLine();
				return name;
			}
			
			public String inputdesignation()
			{
				Scanner sc=new Scanner(System.in);
				String designation=sc.next();
				return designation;
			}
			
			public int inputage()
			{
				Scanner sc=new Scanner(System.in);
				int age=sc.nextInt();
				return age;
			}
			
			public double inputhike()
			{
				Scanner sc=new Scanner(System.in);
				double hike=sc.nextDouble();
				return hike;
			}
			
			public void create()
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter name: ");
				String name=sc.nextLine();
				int c=checknam(name);
				while(c!=1)
				{
					System.err.println("Error Occured. Please try again.");
					name=inputname();
					if(checknam(name)!=0);
						break;
				}
				namee.add(k, name);
				//namee[k]=name;
				k++;
				
				System.out.println("Enter designation: ");
				String designation=sc.next();
				int p= checkdes(designation);
				while(p!=1)
				{
					System.err.println("Error occured. Enter amongst Programmer,manager,tester: ");
					designation=inputdesignation();
					if(checkdes(designation)==1)
						break;
				}
				dess.add(l,designation);
				//dess[l]=designation;
				l++;
				
				if(designation.equalsIgnoreCase("programmer"))
					sall.add(m, new Double(30000));
					//sall[m]=30000;
				else if(designation.equalsIgnoreCase("manager"))
					sall.add(m, new Double(35000));
					//sall[m]=35000;
				if(designation.equalsIgnoreCase("tester"))
					sall.add(m, new Double(25000));
					//sall[m]=25000;
				m++;
				
				
				System.out.println("Enter age: ");
				int age=sc.nextInt();
				int q=checkage(age);
				while(q!=1)
				{
					System.err.println("Age group allowed between 18 & 60");
					age=inputage();
					if(checkage(age)==1)
						break;
				}
				agee.add(o,age);
				//agee[o]=age;
				o++;
				
				if(z<=8)
					empid.add("Wil_0"+(z+1));
				else
					empid.add("Wil"+(z+1));
				//empid[z]="Wil_0"+(z+1);
				//empid[z]="Wil"+(z+1);	
				z++;
			}

			public void display()
			{
				int i;
				System.out.println("List of employees: ");
				//for(i=0;i<k;i++)
				for(i=0;i<namee.size();i++)
				{
					System.out.print("name = "+ namee.get(i)+" ||");
					System.out.print(" designation = "+ dess.get(i)+" ||");
					System.out.print(" age = "+ agee.get(i)+" ||");
					System.out.print(" Employee ID = "+ empid.get(i)+" ||");
					System.out.println(" salary = "+ sall.get(i));
				}
			}
			
			public void raise()
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the employee ID: ");
				String id=sc.next();
				System.out.println("Enter the raise %: ");
				double per=sc.nextDouble();
				if(per>30.0)
					{System.err.println("Invalid. Please enter again: ");
					while(per>30)
					{
						per=inputhike();
						if(per<=30)
							break;
					}
					}
				if(id.charAt(4)=='0')
				{
					int j=id.charAt(5);
					j=j-48;
					double res=sall.get(j-1)+(((per)/100)*sall.get(j-1));
					sall.add(j-1, res);
				//sall[j-1]=sall[j-1]+(((per)/100)*sall[j-1]);
				}
				else
				{
					double res=((per)/100)*sall.get(9);
					sall.add(9, res);
					//sall[9]=((per)/100)*sall[9];
				}
			}
			
			public void dell()
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter employee ID: ");
				String id=sc.next();
				
				if(empid.contains(id))
					{int ll=empid.indexOf(id);
					empid.remove(ll);
					namee.remove(ll);
					agee.remove(ll);
					sall.remove(ll);
					dess.remove(ll);
					System.out.println("Employee deleted.");}
				else
					System.out.println("Employee does not exist.");
			}
			
			public void choice(){
				show_menu();
				Scanner sc=new Scanner(System.in);
				int dt=sc.nextInt();
				char ch=' ';
				while(ch!='n')
				{
				switch(dt) {
				case 1: create();
					break;
				case 2:if(namee.size()==0)
					System.err.println("Create employees first to view data");
					else
					display();
					break;
				case 3: if(namee.size()==0)//(k==0)
					System.err.println("Create employees first to modify salary");
					else
					raise();
					break;
				case 4: if(namee.size()==0)//(k==0)
					System.err.println("Create employees first to delete employees");
				else
					dell();
					break;
				case 5:System.out.println("Exiting...Thank you..!!");
					System.exit(0);
					break;
				default: System.err.println("Key not supported..Enter value between 1 to 5");
				}
				System.out.println("Do you want to continue: y/n");
				ch=sc.next().charAt(0);
			}
			}
			public static void main(String[] args)
			{
				taskA obj=new taskA();
				Scanner sc=new Scanner(System.in);
				int i;
				for(i=0;i<10;i++)
				obj.choice();
			}}
