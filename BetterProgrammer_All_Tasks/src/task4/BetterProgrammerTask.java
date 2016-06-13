package task4;

/*
A set of stairs has N steps.
You can jump either 1 or 2 steps at a time.
For example, if the stairs is N=4 steps, you can reach the end in 5 possible ways:
1-1-1-1, or 1-2-1 or 1-1-2 or 2-1-1 or 2-2
Please implement this method to
return the count of the different ways to reach the end of the stairs with N steps.
*/

public class BetterProgrammerTask {

	public static int summ_summ(int n){
		int summ = 0;
		for(int i = 1;i <= n; i++){
			summ = summ + i;
		}
		return summ;
	}
	
	// Fill the array.
	public static void fill_arr( int[][] arr_buf, int position, int n ){
		int j = 0;
		for(int i_count = 1; i_count <= n; i_count++){
			for(int i_phaze = 0; i_phaze <= n-i_count; i_phaze++){			
				for(int i = 0; i < i_count; i++){
					arr_buf[ j + position ][ i_phaze + i ] = 2;	
				}
				j++;	
			}
		}
	}
	
	// The verification of the identity of the two one-dimensional arrays.
	public static boolean equal_int_arr(int[] a, int[] b){
		if( a.length != b.length ){
			return false;}
		else{
			boolean searched = true;
			for( int i =0; i < a.length; i ++ ){
				if ( a[i] != b[i] ){ searched = false; }
			}
			return searched;
		}
	}
	
	// Removal of typical elements of a two-dimensional array.
	public static void del_equal(int[][] arr_buf){
		for( int i = 0; i < arr_buf.length - 1; i++ ){
			for( int j = i + 1; j < arr_buf.length; j++ ){
				if( equal_int_arr( arr_buf[i], arr_buf[j] ) ){
					for( int k = 0; k < arr_buf[0].length; k++ ){
						arr_buf[j][k] = 0;
					}
				}
			}
		}
	}
	
	// The displacement of zero.
	public static void del_zero(int[][] arr_buf){
		
		int[] arr_sub = new int[arr_buf[0].length];
		
		for( int i = 0; i < arr_sub.length; i++ ){ arr_sub[i] = 0; }
		
		for( int i = 0; i < arr_buf.length; i++ ){
			int count = 0;
			for( int j = 0; j < arr_buf[0].length; j++ ){
				if( arr_buf[i][j] != 0 ){
					arr_sub[count] = arr_buf[i][j];	
					count ++;
				}
			}
			for( int k = 0; k < arr_buf[0].length; k++ ){
				arr_buf[i][k] = arr_sub[k];
			}
			for( int k = 0; k < arr_sub.length; k++ ){ arr_sub[k] = 0; }
		}
	}
	
	
	public static int countWaysToJump(int N){
        /*
        A set of stairs has N steps.
        You can jump either 1 or 2 steps at a time.
        For example, if the stairs is N=4 steps, you can reach the end in 5 possible ways:
        1-1-1-1, or 1-2-1 or 1-1-2 or 2-1-1 or 2-2
        Please implement this method to
        return the count of the different ways to reach the end of the stairs with N steps.
       */
		
		// Base array.
		int n1 = summ_summ(N)+1;
		int [][] arr = new int[n1*n1][N];
				
		for(int i= 0; i < arr.length; i++){
			for(int j= 0; j < N; j++){
				arr[i][j] = 0;
			}
		}
		
		int j = 0 + n1;
		// Filling of array of single items.	
		for( int i_count = 1; i_count <= N; i_count++){
			for( int i_phaze = 0; i_phaze <= N-i_count; i_phaze++){			
				for( int i = 0; i < i_count; i++){
					arr[j][i_phaze + i] = 1;
				}
				
				for( int z = 1; z < n1; z++ ){
					for( int h = 0; h < N; h++ ){
						arr[ j + z][ h ] = arr[ j ][ h] ;
					}
				}

				j = j + n1 ;
			}
		}
		
		// Fill the array of double positions.
		int k = 0;
		while( k < n1 ){
			fill_arr(arr, 1 + (n1)*k, N);
			k++;
		}
		
		del_zero(arr);
		del_equal( arr );
		
		int sum_buf = 0;
		int steps_count = 0;
		
		// Count the steps.
		if( N != 0 ){
			for(int i = 0; i < arr.length;i++){
				for( int i2 = 0; i2 < N; i2++){
					sum_buf = sum_buf + arr[i][i2];
				}
				if(sum_buf == N){
					steps_count++;
					String t = "";
					for (int l = 0; l < N; l++){
						if(arr[i][l] != 0){ t = t + arr[i][l] + " "; }
					}
					System.out.println( steps_count + " : " + t);
				}
				sum_buf = 0;
			}
			return steps_count;
		}else{ return 0; }
	}
	
	public static void main(String[] args) {
		// Example calculation for a stair of 5 steps.
		System.out.println( "Steps_combination = " + BetterProgrammerTask.countWaysToJump(5));
	}

}
