package OnlineBankingProject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

class Transaction extends Account{

	double curr_balance;
	String operation;
	LocalDate date;
	LocalTime time;
	public Transaction(String name, String user_id, String acc_no, double curr_balance,String operation, double amt, LocalDate date,LocalTime time) {
		super(name, user_id, acc_no,curr_balance);
		// TODO Auto-generated constructor stub
		this.curr_balance=curr_balance;
		this.date=date;
		this.time=time;
		this.operation=operation;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return "User Account No.: "+this.acc_no+" "
				+ "Current Balance: "+this.curr_balance
				+" Operation: "+this.operation
				+" Date: "+this.date
				+" Time: "+this.time
				+"\n";
	}
	
}

class Account extends User{
	
	double curr_balance=acc_opening_bal;
	
	public Account(String name, String user_id, String acc_no,double acc_opening_bal) {
		super(name, user_id, acc_no,acc_opening_bal);
		double curr_balance=acc_opening_bal;
		//this.curr_balance=acc_opening_bal;
		// TODO Auto-generated constructor stub
	}
	
/*	public Account(String name, String user_id, String acc_no)
	{
		super(name, user_id, acc_no);
		double curr_balance=acc_opening_bal;
	}*/
	
	//double curr_balance=acc_opening_bal;
	
	public void credit(double amt,ArrayList <Transaction> trans_lst) {
		curr_balance=curr_balance+amt;
		trans_lst.add(new Transaction(name,user_id,acc_no,curr_balance,"CREDIT",amt,java.time.LocalDate.now(),java.time.LocalTime.now()));
	}
	
	public void debit(double amt, ArrayList <Transaction> trans_lst) {
		if(amt>curr_balance)
			System.err.println("Insufficient balance..Please enter again: ");
		else if(amt==curr_balance)
			System.err.println("Minimum account balance should be 1000. ");
		else
		{curr_balance=curr_balance-amt;
		trans_lst.add(new Transaction(name,user_id,acc_no,curr_balance,"DEBIT",amt,java.time.LocalDate.now(),java.time.LocalTime.now()));
		}
	}
	
	public void transfer(String acc_from, String acc_to,double amt,ArrayList <User> usr_lst, ArrayList <Account> acc_lst, ArrayList <Transaction> trans_lst)
	{
		long p=usr_lst.stream().filter(s->s.acc_no.equals(acc_from) || s.acc_no.equals(acc_to)).count();
		if(p==2)
		{
			acc_lst.stream().filter(s->s.acc_no.equals(acc_from)).forEach(s->s.curr_balance=s.curr_balance-amt);
			trans_lst.add(new Transaction(name,user_id,acc_from,curr_balance,"DEBIT",amt,java.time.LocalDate.now(),java.time.LocalTime.now()));

			acc_lst.stream().filter(s->s.acc_no.equals(acc_to)).forEach(s->s.curr_balance=s.curr_balance+amt);
			trans_lst.add(new Transaction(name,user_id,acc_to,curr_balance,"CREDIT",amt,java.time.LocalDate.now(),java.time.LocalTime.now()));

		}
		else
			System.err.println("Enter correct account number: ");
	}
	
	public void miniStatement(String acc_no,ArrayList <Transaction> trans_lst)
	{
		//this method would return last 5 transactions
		System.out.println(trans_lst.subList(Math.max(trans_lst.size() - 5, 0), trans_lst.size())); 
		
	}
	
	public void accBalance()
	{
		System.out.println(curr_balance);
	}
}

class User{
	String name;
	String user_id;
	String acc_no;
	double acc_opening_bal;
	
	/*public User(String name,String user_id,String acc_no)
	{
		this.name=name;
		this.user_id=user_id;
		this.acc_no=acc_no;
	}*/
	
	public User(String name, String user_id,String acc_no,double acc_opening_bal)
	{
		this.name=name;
		this.user_id=user_id;
		this.acc_no=acc_no;
		this.acc_opening_bal=acc_opening_bal; //minimum balance
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nUser Id: "+this.user_id+"\nUser name: "+this.name+"\nUser Account No.:"+this.acc_no;
	}
	
}

public class Bank {
	int flag=1;
	ArrayList <User> usr_lst=new ArrayList<>();
	ArrayList <Account> acc_lst=new ArrayList<>();
	ArrayList <Transaction> trans_lst=new ArrayList<>();
	
	public void show_menu()
	{
		System.out.println("***********************");
		System.out.println("Press 1 to register new user");
		System.out.println("Press 2 to view user details");
		System.out.println("Press 3 to view account details");
		System.out.println("Press 4 to credit/debit/transfer amount/get mini statement/view current balance");
		System.out.println("Press 5 to exit");
		System.out.println("***********************");
		
	}
	
	public void create()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		System.out.println("Enter user id: ");
		String id=sc.next();
		String acc_no="Wil_Ac_0"+flag;
		
		
		System.out.println("Enter opening balance: ");
		double open_bal=sc.nextDouble();
		if(open_bal<1000)
			{System.out.println("Could not proceed further. Minimum opening balance is 1000");}
		else
		{double curr_balance=open_bal;
		usr_lst.add(new User(name,id,acc_no,open_bal));
		acc_lst.add(new Account(name,id,acc_no,curr_balance));}
		flag++;
	}
	
	public void choice(){
		Scanner sc=new Scanner(System.in);
		
		char ch=' ';
		while(ch!='n')
		{
			System.out.println("Enter choice: ");
			int dt=sc.nextInt();
		switch(dt)
		{
		case 1: create();
				break;
			
		case 2: System.out.println("Enter user_id. :");
				String us_id=sc.next();
				System.out.println("User details: ");
				usr_lst.stream().filter(s->s.user_id.equals(us_id)).forEach(s->System.out.println(s));
				break;
			
		case 3: System.out.println("Enter account no.: ");
				String acc_no=sc.next();
				System.out.println("Account details: ");
				acc_lst.stream().filter(s->s.acc_no.equals(acc_no)).forEach(s->System.out.println(s));
				break;
				
		case 4: System.out.println("Enter 1 for debit\nEnter 2 for credit\nEnter 3 for transfer\nEnter 4 for mini statement\nEnter 5 to check current balance: ");
				int c=sc.nextInt();
			/*	System.out.println("Enter name: ");
				String name=sc.next();
				System.out.println("Enter user_id: ");
				String user_id=sc.nextLine();*/
				System.out.println("Enter account no: ");
				String ac=sc.nextLine();
				//String name,user_id;
				acc_lst.stream().filter(s->s.acc_no.equals(ac)).forEach(s->{
					 String name=s.name;
					 String user_id=s.user_id;
					 double curr_bal=s.curr_balance;
				
				
				Account aob=new Account(name,user_id,ac,curr_bal);
				switch(c)
				{
				case 1:System.out.println("Enter amount: ");
				double amt=sc.nextDouble();
					aob.debit(amt, trans_lst);
					break;
				case 2:System.out.println("Enter amount: ");
					double amt1=sc.nextDouble();
					aob.credit(amt1, trans_lst);
					break;
				case 3:System.out.println("Enter account_No_to_transfer: ");
					String acto=sc.next();
					System.out.println("Enter amount: ");
					double amt2=sc.nextDouble();
					aob.transfer(ac, acto, amt2, usr_lst, acc_lst, trans_lst);
					break;
				case 4:aob.miniStatement(ac, trans_lst);
					break;
				case 5:aob.accBalance();
					break;
				default: System.err.println("Incorrect choice");
				}
				}); //end of ForEach loop
				break;
			
		case 5: System.out.println("Terminating..Please wait!");
				System.out.println("Exiting..Thank you!");
				System.exit(0);
				break;
			
		default:System.err.println("Key not supported..Enter correct value.");
		
		}
		
		System.out.print("Do you want to continue: press y/n ");
		ch=sc.next().charAt(0);
		}
	}
	
	public static void main(String[] args) {
		Bank ob=new Bank();
		
		ob.show_menu();
		ob.choice();
		
		
		
		
	}
}
