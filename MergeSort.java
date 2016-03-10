

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
	given parameter array
	if array is sorted return array
	else
		split array into two halves, a and b
		return the merge the recursion of a and the recursion of b
	
	merge: view first element of two arrays, and add the lowest element to the to-be-returned array
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) {
    	
		  int[] c = new int[ a.length + b.length ];
		  int i, j, k;

		  i=0;  j=0;
		  for(k=0; k<c.length; k++) {
		  	if( i==a.length ) {
		  		c[k] = b[j];
		  		j++;
		  	}
		  	else if( j==b.length ) {
		  		c[k] = a[i];
		  		i++;
		  	}
		  	else if( a[i]<b[j] ) { 
		  		c[k] = a[i];
		  		i++;
		  	}
		  	else {
		  		c[k] = b[j];
		  		j++;
		  	}
		  	//c[k] = ( a[i]<b[j] ? a[i++] : b[j++] );
		  	//for some reason that didnt work ^ :( 
		  	
		  }

		  return c;
		  
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) {
    	
    	  if(arr.length==1) return( arr ); //a base case
		
		  int si = arr.length/2; //split index
		  int[] v = new int[ si ];
		  int[] u = new int[ arr.length - si ];
		
		  for(int i=0; i<arr.length; i++) {
		  	if( i<si ) v[i] = arr[i];
		  	else u[i-si] = arr[i];
		  }
		  
		  return( merge( sort(v), sort(u) ) );

    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
		for( int i = 0 ; i<a.length; i++ )
		    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
		System.out.print("[");
		for( int i : a )
		    System.out.print( i + ",");
		System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );
    

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
