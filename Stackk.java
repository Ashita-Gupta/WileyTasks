package NewPackage;

class Stack {
	
	int top=-1;
	int MAX_SIZE = 100;
	int arr[] = new int[MAX_SIZE]; 
	
	void push(int a)
	{
		if (top > (MAX_SIZE)) {
			System.out.println("Stack Overflow");
		}
		else {
			arr[++top] = a;
			System.out.println(a + " pushed into stack");
		}
	}

	int pop()
	{
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int a = arr[top--];
			return a;
		}
	}
	
	void print()
	{
		System.out.print("Stack elements: ");
		for(int i = top;i>=0;i--)
			System.out.print(arr[i]+" ");
	}
}

class Stackk {
	public static void main(String args[])
	{
		Stack st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		System.out.println(st.pop() + " Popped from stack");
		System.out.println(st.pop() + " Popped from stack");
		st.print();
	}
}

