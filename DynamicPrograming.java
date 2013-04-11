
public class DynamicPrograming {

	/**
	 * @param args
	 */
	
	public Integer fib(int n)
	{
		if(n == 0)
		{
			return 0;
		}
		if(n == 1)
		{
			return 1;
		}
		return fib(n-1) + fib(n-2);
		
	}
	
	
	public Integer fib2(int n)
	{
		int[] arr = new int[n+1];		
		int foo = 0;
		if(n <= 0)
		{
			return foo;
		}
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 1; i<=(n-1); i++)
		{
			
			foo = arr[i-1] + arr[i];
			arr[i+1] = foo;
		}
		
		return foo;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicPrograming a = new DynamicPrograming();
		System.out.println(a.fib(0));
		System.out.println(a.fib2(0));
		System.out.println(a.fib(15));
		System.out.println(a.fib2(15));
		System.out.println(a.fib2(45));
		System.out.println("YES");
		System.out.println(Integer.MAX_VALUE);

	}

}
