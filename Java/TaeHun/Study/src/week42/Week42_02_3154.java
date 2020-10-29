package week42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Data{
	int time;
	int effort;

	public Data(int time, int effort) {
		this.time = time;
		this.effort = effort;
	}
}

public class Week42_02_3154 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String str = br.readLine();

		Data[] data = new Data[10];

		int time = 0;
		int pos = 1000;
		for(int i=0; i<str.length(); i++) {
			if( i==2 )
				continue;
			time += ( str.charAt(i) - '0' ) * pos;
			pos /= 10;						
		}

		pos = 0;
		data[pos++] = new Data( time, effort(time) );
		if( time % 100 < 40 )
			data[pos++] = new Data( time+60, effort(time+60) );
		data[pos++] = new Data( time+2400, effort(time+2400) );
		if( time % 100 < 40 )
			data[pos++] = new Data( time+2460, effort(time+2460) );
		data[pos++] = new Data( time+4800, effort(time+4800) );
		if( time % 100 < 40 )
			data[pos++] = new Data( time+4860, effort(time+4860) );
		data[pos++] = new Data( time+7200, effort(time+7200) );
		if( time % 100 < 40 )
			data[pos++] = new Data( time+7260, effort(time+7260) );
		if( time + 9600 <= 9999) {
			data[pos++] = new Data( time+9600, effort(time+9600) );
			if( time + 9660 <= 9999 && time % 100 < 40 ) {
				data[pos++] = new Data( time+9660, effort(time+9660) );
			}
		}


		int minEffort = Integer.MAX_VALUE;
		int minTime = Integer.MAX_VALUE;
		for(int i=0; i<pos; i++) {
			if( data[i].effort < minEffort ) {
				minEffort = data[i].effort;
				minTime = data[i].time;
			}			
		}		

		String output;
		if( minTime < 10 )
			output = "000"+ Integer.toString( minTime );
		else if( minTime >= 10 && minTime < 100 )
			output = "00"+ Integer.toString( minTime );
		else if( minTime >= 100 && minTime < 1000 )
			output = "0" + Integer.toString( minTime );
		else 
			output = Integer.toString( minTime );

		String hour = output.substring(0, 2);
		String min  = output.substring(2, 4);

		System.out.println( hour + ":" + min );
	}


	private static int effort(int time) {
		int a = time/1000;
		int b = (time%1000)/100;
		int c = (time%100)/10;
		int d = time%10;

		return effort( a, b ) + effort( b, c ) + effort( c, d );
	}

	private static int effort(int a, int b) {

		if( a < b ) {
			int tmp = a;
			a = b;
			b = tmp;
		}		

		if( a == b )
			return 0;

		if( a == 0 ) {
			if( b == 8 )
				return 1;
			else if( b == 7 || b == 5 || b == 9 )
				return 2;
			else if( b == 4 || b == 2 || b == 3 )
				return 3;
			else
				return 4;				
		}

		else if( a == 1 ) {
			if( b ==2 || b == 4 )
				return 1;
			else if( b == 3 || b == 5 || b == 7 )
				return 2;
			else if( b == 6 || b == 8 )
				return 3;
			else
				return 4;
		}

		else if( a == 2 ) {
			if( b == 1 || b == 5 || b == 3 )
				return 1;
			else if( b == 4 || b == 8 || b == 6 )
				return 2;
			else
				return 3;
		}
		else if( a == 3 ) {
			if( b == 2 || b == 6 )
				return 1;
			else if( b == 1 || b == 5 || b == 9)
				return 2;
			else if( b == 4 || b == 8 )
				return 3;
			else
				return 4;
		}

		else if( a == 4 ) {
			if( b == 1 || b == 5 || b == 7 )
				return 1;
			else if( b == 2 || b == 6 || b == 8 )
				return 2;
			else 
				return 3;
		}
		else if( a == 5 ) {
			if( b == 2 || b == 4 || b == 6 || b == 8 )
				return 1;
			else 
				return 2;			
		}
		else if( a == 6 ) {
			if( b == 3 || b == 5 || b == 9 )
				return 1;
			else if( b == 2 || b == 4 || b == 8 )
				return 2;
			else
				return 3;
		}
		else if( a == 7 ) {
			if( b == 4 || b == 8 )
				return 1;
			else if( b == 1 || b == 5 || b == 9 || b ==0 )
				return 2;
			else if( b == 2 || b == 6 )
				return 3;
			else 
				return 4;
		}
		else if( a == 8 ) {
			if( b == 0 || b == 5 || b == 7 || b == 9 )
				return 1;
			else if( b == 4 || b == 2 || b == 6 )
				return 2;
			else 
				return 3;
		}
		else {
			if( b == 6 || b == 8 )
				return 1;
			else if( b == 0 || b == 7 || b == 5 || b == 3 )
				return 2;
			else if( b == 4 || b == 2 )
				return 3;
			else
				return 4;
		}
	}
}
















