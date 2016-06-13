package task1;

/*
Please implement this method to
return a new array with only positive numbers from the given array.
The elements in the resulting array shall be sorted in the ascending order.
*/

public class BetterProgrammerTask {


	public static int[] retainPositiveNumbers(int[] a) {
        /*
          Please implement this method to
          return a new array with only positive numbers from the given array.
          The elements in the resulting array shall be sorted in the ascending order.
         */
    	
    	int[] arr1 = new int[a.length];
    	int count = 0;
    	
    	// Copy only positive.
    	for( int i=0;i<a.length;i++){
    		if (a[i] >=0 ){arr1[count] = a[i]; count++;}
    	}
    	
    	int[] arr = new int[count];
    	for( int i = 0;i < count; i++ ){
    		arr[i] = arr1[i];
    	}
    	
    	//Sort ascending
    	for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr[j] > arr[j+1] ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
    	}
    	return arr;
    }

	//Short test.
	public static void main(String[] args) {
		
		int[] arr = new int[5];
		int[] arr_sorted;
		
		arr[0] = 31;
		arr[1] = -10;
		arr[2] = 1;
		arr[3] = -5;
		arr[4] = 14;
		
		arr_sorted = BetterProgrammerTask.retainPositiveNumbers(arr);
		
		for( int i = 0; i < arr_sorted.length; i++){
			System.out.println(arr_sorted[i]);
		}
	}
}
