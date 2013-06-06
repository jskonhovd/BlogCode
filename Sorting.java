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
	
	public void swap(Integer[] arr, int i, int j)
	{
   // System.out.println("|:|:|--|" + arr + " - " + i  + " - " + j);
		int foo = arr[i];
		int bar = arr[j];
		arr[i] = bar;
		arr[j] = foo;
		
		//return arr;
	}
	
	public Integer[] insertionSort(Integer[] arr)
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

    public Integer Partition(Integer[] arr, int low, int high)
    {
        
	      Random gen = new Random();
        int pivotIndex = lo + (high - lo)/2;
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
       // printArrs(arr);
       // System.out.println(getArrStringBetween(arr,low,high));
       // System.out.println("leftWall:" + leftWall + " Low:" + low + " Hi:" + high);
        return leftWall;
    }
    public void QuickSort(Integer[] arr, int low, int high)
    {
            if(low < high)
            {
              int ploc = Partition(arr,low,high);
              QuickSort(arr,low, ploc-1);
              QuickSort(arr,ploc+1,high); 
            }
    }

  public static void testParition()
  {
      eq(0,(new Sorting()).Partition(new Integer[] {5,7,4,12,19,6,13,15},0,8),new Integer[] {5,7,12,19,4,6,13,15});
  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //
        Random m = new Random();
    
		Sorting a = new Sorting();
		Integer[] arr = {1000,2,1,2,3,1,1000,5,5,6,7,1337,9,10};
		Integer[] A = {5,7,12,19,4,6,13,15};
		Integer[] A1 = {5,7,12,19,4,6,13,15};
		Integer[] BP = {5,19,7,12,4,13,6,15};
		
		Integer[] B = {15,2,100,34,24,2453,53,532,521,25555,25};
		int pivotIndex = m.nextInt(A1.length);

        
    a.printArrs(A1);
    int ploc = a.Partition(A1,0,A1.length);
    a.printArrs(A1);
	}

    private static void eq( int n, int a, int b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, char a, char b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
    }
    private static void eq( int n, long a, long b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, boolean a, boolean b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, String a, String b ) {
        if ( a != null && a.equals(b) )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
    }
    private static void eq( int n, int[] a, int[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++)
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, long[] a, long[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, String[] a, String[] b ) {
        if ( a.length != b.length) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if( !a[i].equals( b[i])) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void print( int a ) {
        System.err.print(a+" ");
    }
    private static void print( long a ) {
        System.err.print(a+"L ");
    }
    private static void print( String s ) {
        System.err.print("\""+s+"\" ");
    }
    private static void print( int[] rs ) {
        if ( rs == null) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( long[] rs) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( String[] rs ) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print( "\""+rs[i]+"\"" );
            if( i != rs.length-1)
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void nl() {
        System.err.println();
    }
  

}
