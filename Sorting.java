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
		Sorting jeff = new Sorting();
		Integer[] ret = new Integer[arr.length];
		for(int a = 0; a <= high; a++)
		{
			ret[a] = arr[a];
		}
		int i = lo;
		int j = mid + 1;
				
		for(int k =lo; k <= high; k++)
		{
			//jeff.printArrs(arr);
			//System.out.println("k:" + k +" i:" + i + " j:" + j + " mid:" + mid + " lo:" + lo + " high:" + high);
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
	
	public Integer[] swap(Integer[] arr, int i, int j)
	{
   // System.out.println("|:|:|--|" + arr + " - " + i  + " - " + j);
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

    public static String getArrsString(Integer[] arr)
    {
        String ret = "";
        for(int i = 0; i < arr.length; i++)
        {

            ret += arr[i].toString() + ".";
        }
        return ret.substring(0, ret.length() -1);
    }

    public Integer Partition(Integer[] arr, int lo, int high, int pivotIndex)
    {
        int pivot = arr[pivotIndex];
        //System.out.println(getArrsString(arr));
        arr = swap(arr, lo, pivotIndex);
        int leftWall = lo;
       // System.out.println(getArrsString(arr));
       // System.out.println("Pivot:" + pivot + " -hi:" + high + " -Lo:"  + lo );
        for(int i = lo+1; i < high; i++)
        {
            if(arr[i] < pivot)
            {
          //      System.out.println("Index:" + i + " -- " + "LeftWall: " + leftWall); 
                leftWall = leftWall + 1;
                arr = swap(arr, i, leftWall);
            }
          //  System.out.println(getArrsString(arr));
        }
        arr = swap(arr,lo, leftWall);
        return leftWall;
    }
    public void QuickSort(Integer[] arr, int lo, int high)
    {

        if(lo<high)
        {
            Random gen = new Random();
            int pivotIndex = gen.nextInt(high);
            int ploc = 0;
            
            
            ploc = Partition(arr,lo,high,pivotIndex);
            System.out.println("ploc:" +ploc);
            System.out.println("1:" +  getArrsString(arr)+ " lo:" + lo + " high:" + high + " ploc - 1:" + (ploc-1));
            QuickSort(arr,lo, ploc-1);
            
            System.out.println("2:" + getArrsString(arr)+ " lo:" + lo + " high:" + high + " ploc + 1:" + (ploc +1) );
            QuickSort(arr,ploc+1,high);
            
        }//return arr;
    }





	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //
        Random m = new Random();
    
		Sorting a = new Sorting();
		Integer[] arr = {1000,2,1,2,3,1,1000,5,5,6,7,1337,9,10};
		Integer[] A = {5,7,12,19,4,6,13,15};
		Integer[] BP = {5,19,7,12,4,13,6,15};
		
		Integer[] B = {4,6,13,15};
		int pivotIndex = m.nextInt(arr.length);
        Integer make = a.Partition(arr,0,arr.length-1,pivotIndex);
        a.printArrs(arr);
        a.QuickSort(A,0,A.length-1);
	//	Integer[] me = a.mergeSort(A, 0, 7);
		//Integer[] me2 = a.merge(BP, 0, 1, 3);
		//Integer[] me3 = a.merge(BP, 4, 5, 7);
		
		//Integer[] selSort = a.selectionSort(arr);
		//Integer[] insertSort = a.insertionSort(arr);
		//Integer[] foo = a.removeIndexFromArray(arr, 1000);	
		System.out.println(make);
		a.printArrs(A);
		//a.printArrs(me2);
		//a.printArrs(me3);
		//a.printArrs(foo);
		//a.printArrs(selSort);
		//a.printArrs(insertSort);
	}

}
