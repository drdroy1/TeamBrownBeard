/*======================================
  class MergeSortTester

  ALGORITHM:
  	given parameter array
	if array is sorted return array
	else
		split array into two halves, a and b
		return the merge the recursion of a and the recursion of b
	
	merge: view first element of two arrays, and add the lowest element to the to-be-returned array

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(n)

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: -
  n=10      time: ~2500 nanoseconds
  n=100     time: ~12000 nanoseconds
  ...
  n=100000  time:~17 million nanoseconds 

  REFER TO RESULTS.txt FOR FULL DATA
  CASE REPRESENTS LENGTH OF ARRAY
  TIME REPRESENTS TIME ELAPSED BY mergesort() IN NANOSECONDS

  ANALYSIS:
  Case 10 of Experiments 5 and 0 are outliers
  The number of digits in the number of the case is proportionate to the number of digits in time
  log_base_10(CASE) + 2 = floor( log_base_10(TIME) )
  ======================================*/

public class MergeSortTester 
{

	//create a new int array of size n and fill it with random values
	//n - positive int, length of array
	//return - newly allocated array of random elements,
	public static int[] generate_array(int n) {
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = (int)(Math.random()*100);
		}
		
		return( arr );
	}

	//for timing methods
	//return a relative start time in nanoseconds as a long
	public static long getTime() {
		return( System.nanoTime() );
	}
	
	//for timing methods
	//startTime - a relative time marking start of count
	//return - nanoseconds since startTime as a long
	public static long getTimeSince(long startTime) {
		return( Math.abs( startTime - System.nanoTime() ) );
	}
	
	//time and run test of an n-element test case array and output results
	public static void runTest( int n ) {
		
		long t;
		int arr[] = generate_array(n);
		
		System.out.println("-----------------------------------------");
		System.out.print("Sorting Array: ");
		//MergeSort.printArray(arr);
		t = getTime();
		MergeSort.sort(arr);
		t = getTimeSince(t);
		
		//MergeSort.printArray(arr);
		System.out.println("Case: " + n + "| Time: " + t);
		System.out.println();
		System.out.println("-----------------------------------------");
		
	}
	
    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) 
    {
		for(int i=0; i<10; i++) {
			System.out.println("Experiment " + i + " ===================================");
			MergeSortTester.runTest(10);
			MergeSortTester.runTest(100);
			//MergeSortTester.runTest(200);
			//MergeSortTester.runTest(300);
			System.gc();
			MergeSortTester.runTest(1000);
			//MergeSortTester.runTest(2000);
			//MergeSortTester.runTest(3000);
			System.gc();
			MergeSortTester.runTest(10000);
			System.gc();
			MergeSortTester.runTest(100000);
			System.gc();
		}
    }//end main

}//end class
