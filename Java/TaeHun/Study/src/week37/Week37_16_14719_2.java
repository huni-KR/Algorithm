package week37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Data{
	int index;
	int h;
	public Data(int index, int h) {
		this.index = index;
		this.h = h;
	}
}

public class Week37_16_14719_2 {

	static int sum = 0;
	static int[] grid;
	static Data[] data; 

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		data = new Data[2];
		for (int i = 0; i < data.length; i++) 
			data[i] = new Data(0,0);

		String[] token = br.readLine().split(" ");
		int h = Integer.parseInt( token[0] );
		int w = Integer.parseInt( token[1] );	
		grid = new int[w];

		token = br.readLine().split(" ");
		for(int i=0; i<token.length; i++)
			grid[i] = Integer.parseInt( token[i] );

		int count = 0;
		for(int i=0; i<grid.length; i++) {

			if( i == 0 ) {
				data[count].h = grid[i];
				data[count].index = i;
			}

			else {			
				if( isIncrease(i) == 1 ) {
					data[count%2].h = grid[i];
					data[count%2].index = i;	
					if( i == grid.length - 1 )
						sum += calc();
				}
				else if( isIncrease(i) == 0 ) {
					data[count%2].h = grid[i];
					data[count%2].index = i;
					if( i == grid.length - 1 )
						sum += calc();
				}
				else {	
					sum += calc();
					if( count != 0 ) {
						data[0].h = 0;
						data[0].index = 0;
					}
					count++;					
				}
			}			
		}
		System.out.println( sum );
	}

	public static int calc() {

		if( data[0].index > data[1].index ) {
			Data tmp = data[0];
			data[0] = data[1];
			data[1] = tmp;
		}

		int h = Math.min( data[0].h, data[1].h ); 
		int count = 0;
		for(int i=data[0].index+1; i<data[1].index; i++) 
			count += h-grid[i];		

		return count;
	}

	public static int isIncrease(int i) {
		if( grid[i-1] < grid[i] )
			return 1;
		else if( grid[i-1] == grid[i] )
			return 0;
		else
			return -1;
	}

}




