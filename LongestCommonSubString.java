
public class LongestCommonSubString {

	/**
	 * @param args
	 * 
	 * 
	 */
	public String getLongestCommonSubString(String a, String b)
	{
		int z = 0;
		int[][] l = new int[a.length()][b.length()];
		String ret = "";
		int index = 0;
		
		for(int i =0; i< a.length(); i++)
		{
			for(int j = 0; j < b.length(); j++)
			{
				
				if(a.charAt(i) == b.charAt(j))
				{
					if( i == 0 || j == 0)
					{
						l[i][j] = 1;
					}
					else
					{
						l[i][j] = l[i-1][j-1] + 1;
					}
					if(l[i][j] > z)
					{
						z = l[i][j];
						index = i;
					}
				}
				else
				{
					l[i][j] = 0;
				}
			}
			
		}
		ret = a.substring(index - z + 1, index+1);
		return ret;
		
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestCommonSubString LCSS = new LongestCommonSubString();
		System.out.println(LCSS.getLongestCommonSubString("abcd2323", "131313abcc"));
		System.out.println(LCSS.getLongestCommonSubString("123456789", "123456789"));
		System.out.println(LCSS.getLongestCommonSubString("12345", "123456789"));
		System.out.println(LCSS.getLongestCommonSubString("12345", "1234c56789"));
	}

}
