package week38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week38_15_3967_N {

	static int[][] grid; 
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		grid = new int[5][9];
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				int tmp = str.charAt(j) - 'A'+1;
				if( tmp >= 0 && tmp <= 12 )
					grid[i][j] = tmp;
			}
		}
		System.out.println();
		

		
	}

}
