/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{

	//create a new int array of size n and fill it with random values
	//n - positive int, length of array
	//return - newly allocated array of random elements,
	public static int[] generate_array(int n) {
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = math.random();
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
		return( startTime - System.nanoTime() );
	}
	
	//time and run test of an n-element test case array and output results
	public static void runTest( int n ) {
		
		long t;
		int arr[] = generate_array(n);
		
		System.out.println("-----------------------------------------");
		System.out.print("Sorting Array: ");
		MergeSort.printArray(arr);
		t = getTime();
		MergeSort.sort(arr);
		t = getTimeSince(t);
		
		MergeSort.printArray(arr);
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

		MergeSortTester.runTest(10);
		MergeSortTester.runTest(100);
		MergeSortTester.runTest(200);
		MergeSortTester.runTest(300);
		MergeSortTester.runTest(1000);
		MergeSortTester.runTest(2000);
		MergeSortTester.runTest(3000);
		MergeSortTester.runTest(10000);
	
    }//end main

}//end class
