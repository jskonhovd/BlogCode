import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class InterviewPracticeApril10 {

	/**
	 * @param args
	 */
	public String reverse(String str)
	{
		String ans = "";
		List<String> A = new ArrayList<String>(); 
		List<String> B = new ArrayList<String>();
		
		A.addAll(Arrays.asList(str.split("\\s")));
		B.addAll(Collections.<String>emptyList());
		List<String> strsplit = helper(A,B);
		for(int i = 0; i<strsplit.size(); i++)
		{
			ans += strsplit.get(i) +  " ";
			
		}
		
		return ans.trim();
	}
	
	public List<String> helper(List<String> A, List<String> B)
	{
		if(A.isEmpty())
		{
			return B;
			
		}
		String grr = A.get(0);
		
		B.add(0, grr);
		
		
		return helper(A.subList(1, A.size()), B);
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterviewPracticeApril10 a = new InterviewPracticeApril10();
		
		System.out.println(a.reverse("Coding for Interviews contains too many gifs."));

	}

}
