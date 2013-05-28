import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


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
	
	public Integer[] swap(Integer[] arr, int i, int j)
	{
		int foo = arr[i];
		int bar = arr[j];
		arr[i] = bar;
		arr[j] = foo;
		
		return arr;
	}
	
	public Integer[] insertionSort(Integer[] arr)
	{
		Integer[] ret = new Integer[arr.length];
		for(int i =1; i< ret.length; i++)
		{
			int j = i;
			while((j>0) && (arr[j] < arr[j-1]))
			{
				arr = swap(arr, j, j-1);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorting a = new Sorting();
		Integer[] arr = {1000,2,1,2,3,1,1000,5,5,6,7,1337,9,10};
		Integer[] A = {5,7,12,19};
		Integer[] B = {4,6,13,15};
		
		Integer[] me = a.merge(A,B);
		
		//Integer[] selSort = a.selectionSort(arr);
		//Integer[] insertSort = a.insertionSort(arr);
		//Integer[] foo = a.removeIndexFromArray(arr, 1000);	
		
		a.printArrs(me);
		//a.printArrs(foo);
		//a.printArrs(selSort);
		//a.printArrs(insertSort);
	}

}