package week37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week37_02_16431 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[3][2];
		for(int i=0; i<3; i++) {
			String[] token = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt( token[0] );
			arr[i][1] = Integer.parseInt( token[1] );					
		}
		br.close();
		
		int B = Math.max( Math.abs(arr[0][0] - arr[2][0]), Math.abs(arr[0][1] - arr[2][1]) );
		int D = Math.abs(arr[1][0] - arr[2][0]) + Math.abs(arr[1][1] - arr[2][1]);
		
		String result = "";
		if( D == B )
			result += "tie";
		else if( D < B )
			result += "daisy";
		else
			result += "bessie";
		System.out.println( result );		
	}
}
