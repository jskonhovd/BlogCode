
public class Partition {

	public int partitionProblem(int[] S, int k)
	{
		int n = S.length;
		int[] p = new int[n+1];
		int[][] M = new int[n][k];
		TestFramework test = new TestFramework();
		for(int i = 1; i < n+1; i++)
		{
			if(i > 0)
			{
				p[i] = p[i-1] + S[i-1];
			}
			else
			{
				p[0] = 0;
			}
		}

		
		//init boundary conditions
		
		for(int i = 0; i < n; i++)
		{
			M[i][0] = p[i+1];		
		}
		
		for(int j = 1; j < k; j++)
		{
			M[0][j] = S[0];
		}
		
		for(int i = 1; i < n; i++)
			for(int j = 1; j <k; j++)
			{
				M[i][j] = Integer.MAX_VALUE;
				for(int x = 0; x < i; x++)
				{
					int s = Math.max(M[x][j-1],p[i+1] - p[x+1]);
					M[i][j] = Math.min(s, M[i][j]);
					
				}
			}
		test.print(M);
		return M[n-1][k-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestFramework test = new TestFramework();
		Partition part = new Partition();
		int[] s = new int[] {1,2,3,4,5,6,7,8,9};
		
		int M = part.partitionProblem(s,2);
		System.out.println("Done");
		test.print(M);
	}

}
