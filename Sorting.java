import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Sorting {

	/**
	 * @param args
	 */
	public Integer findMinIndex(Integer[] arr)
	{
		int ret = Integer.MAX_VALUE;
		int retIndex = 0;
		for(int i =0; i < arr.length; i++)
		{
			if(arr[i] < ret)
			{
				ret = Math.min(arr[i], ret);
				retIndex = i;
			}
		}
		return retIndex;
	}
	
	public Integer findMin(Integer[] arr)
	{
		int ret = Integer.MAX_VALUE;
		for(int i =0; i < arr.length; i++)
		{
			ret = Math.min(arr[i], ret);
		}
		return ret;
	}
	
	public Integer[] removeIndexFromArray(Integer[] arr, Integer val)
	{
		List<Integer> ls = new LinkedList<Integer>();
		boolean found = false;
		for(int i =0; i< arr.length; i++)
		{
			boolean equals = (!arr[i].equals(val));
			if(equals || found)
			{
				
				ls.add(arr[i]);
				//System.out.println(equals);
			}
			else
			{
				//System.out.println(arr[i]);
				found = true;
			}	
			//printList(ls);
		}

		return ls.toArray(new Integer[arr.length -1]);
	}
	
	
	
	public Integer[] initArray(Integer[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = 0;
		}
		return arr;
	}
	
	public Integer[] selectionSort(Integer[] arr)
	{
		Sorting a = new Sorting();
		Integer[] ret = new Integer[arr.length];
		ret = initArray(ret);
		int size = arr.length;
		for(int i =0; i < size; i++)
		{
			ret[i] = findMin(arr);			
			arr = removeIndexFromArray(arr, ret[i]);	
			//a.printArrs(arr);
		}		
		return ret;
	}
	
	public Integer[] mergeSort(Integer[] arr, int lo, int high)
	{
		if(lo >= high)
		{
			return arr;
		}
		int mid = lo + (high - lo)/2;
		arr = mergeSort(arr, lo, mid);
		arr = mergeSort(arr, mid+1, high);
		
		return merge(arr, lo, mid, high);
		
	}
	
	
	public Integer[] merge(Integer[] arr, int lo, int mid, int high)
	{
		
		Integer[] ret = new Integer[arr.length];
		for(int a = 0; a <= high; a++)
		{
			ret[a] = arr[a];
		}
		int i = lo;
		int j = mid + 1;
				
		for(int k =lo; k <= high; k++)
		{
			if(i > mid)
				arr[k] = ret[j++];
			else if(j > high)
				arr[k] = ret[i++];
			else if (ret[i] > ret[j])
				arr[k] = ret[j++];
			else
				arr[k] = ret[i++];
		}
		return arr;
	}
	
	public Integer[] merge(Integer[] left, Integer[] right)
	{
		Integer[] ret = new Integer[left.length + right.length];
		
		int j = 0;
		int k = 0;
		for(int i = 0; i < ret.length; i++)
		{
			boolean leftSmaller = false;
			boolean checkLeft = (j < left.length);
			boolean checkRight = (k < right.length);
			
			if(checkLeft && checkRight)
			{
			   leftSmaller = (left[j] <= right[k]);
			}
			if(leftSmaller)
			{
				if(checkLeft)
				{   
					ret[i] = left[j];			
					j++;
				}
				else
				{
					if(checkRight)
					{
						ret[i] = right[k];
						k++;
					}
				}
			}
			else
			{
				if(checkRight)
				{
					ret[i] = right[k];
					k++;
				}
				else
				{
					if(checkLeft)
					{   
						ret[i] = left[j];			
						j++;
					}
				}
			}
			
			
		}
		return ret;
		
	}
	
	public void swap(int[] arr, int i, int j)
	{
		int foo = arr[i];
		int bar = arr[j];
		arr[i] = bar;
		arr[j] = foo;
	}
	
	public int[] insertionSort(int[] arr)
	{
		Integer[] ret = new Integer[arr.length];
		for(int i =1; i< ret.length; i++)
		{
			int j = i;
			while((j>0) && (arr[j] < arr[j-1]))
			{
				swap(arr, j, j-1);
				j = j - 1;
			}
		}
		return arr;
	}
	
	public void printList(List arr)
	{
		String ret = "";
		for(int i=0; i < arr.size(); i++)
		{
			ret += arr.get(i) + ",";
		}
		System.out.println(ret);
	}
	
	public void printArrs(Integer[] arr)
	{
		String ret = "";
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == null)
			{
				ret += "NIL";
			}
			else
			{
				ret += arr[i].toString() + ",";
			}
		}
		System.out.println(ret.substring(0, ret.length()-1));
	}
	
	public void printArrs(int[] arr)
	{
		String ret = "";
		for(int i = 0; i < arr.length; i++)
		{			
			ret += arr[i] + ",";			
		}
		System.out.println(ret.substring(0, ret.length()-1));
	}
	public static String getArrStringBetween(Integer[] arr, int lo, int high)
	 {
		String ret = "";
		if(lo < high)
		{
	    	for(int i = lo; i < high; i++)
	    	{
	    		ret += arr[i].toString() + ".";
        	}
		}
    	return ret.substring(0, ret.length());
	 }
	public static String getArrsString(Integer[] arr)
    {
        String ret = "";
    for(int i = 0; i < arr.length; i++)
    {

        ret += arr[i].toString() + ".";
    }
    return ret.substring(0, ret.length() -1);
	}
	
	public Integer Partition(int[] arr, int low, int high)
	{
		Random gen = new Random();
	    int pivotIndex = low + (high - low)/2;
	    swap(arr,low,pivotIndex);
	    int leftWall = low;
	    int pivot = arr[low];
	    for(int i = low+1; i < high; i++)
	    {
	        if(arr[i] < pivot)
	        {
	            leftWall = leftWall + 1;
	            swap(arr, i, leftWall);
	        }
	    }
	    swap(arr,low, leftWall);

	    return leftWall;
	}
	public void QuickSort(int[] arr, int low, int high)
	{
	        if(low < high)
	        {
	          int ploc = Partition(arr,low,high);
	          QuickSort(arr,low, ploc);
	          QuickSort(arr,ploc+1,high); 
	        }
	}
  
	public static void testQuickSort()
	{
		System.out.println("QuickSort: ----------- START");
		TestFramework test = new TestFramework();
	    int[] arr = new int[] {5,7,4,12,19,6,13,15};
	    new Sorting().QuickSort(arr, 0, arr.length);
	    test.print(arr);
	    int[] grr = new int[] {1,2,5,3,51,23,511,5555,33,6};
	    new Sorting().QuickSort(grr, 0, grr.length);
	    test.print(grr);
	    System.out.println("QuickSort: ----------- END");
	    
	}
	public static void testParition()
	{
		System.out.println("Parition: ----------- START");
		TestFramework test = new TestFramework();
		int[] arr = new int[] {5,7,4,12,19,6,13,15};
		int ploc = new Sorting().Partition(arr,0,arr.length-1);
		test.checkPartion(ploc, arr);
		test.print(arr);
		int ploc2 = new Sorting().Partition(arr,0,ploc);
		test.checkPartion(ploc2, arr);
		test.print(arr);
		int ploc3 = new Sorting().Partition(arr,0,ploc2);
		test.checkPartion(ploc3, arr);
		test.print(arr);
		int ploc4 = new Sorting().Partition(arr,ploc2+1,ploc);
		test.checkPartion(ploc4, arr);
		test.print(arr);  
		System.out.println("Parition: ----------- END");
  }

  public static void main(String[] args) {
		// TODO Auto-generated method stub

	testParition();
	testQuickSort();
  }

    
  

}