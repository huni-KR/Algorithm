package week42;

import java.util.Arrays;
import java.util.Scanner;

public class Week42_01_17945 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int a = kb.nextInt();
		int b = kb.nextInt();		
		kb.close();

		int[] arr = new int[2];

		for(int i=-33; i<=33; i++) {
			if( i == 0 )
				continue;
			if( b%i == 0 ) {
				for(int j=-33; j<=33; j++) {
					if( i+j == -a*2 && i*j == b ) {
						arr[0] = i;
						arr[1] = j;						
					}					
				}				
			}			
		}

		Arrays.sort(arr);

		if( arr[0] == arr[1] )
			System.out.println( arr[0] );
		else
			System.out.println( arr[0] + " " + arr[1] );
	}
}
