package week40;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Week40_5_5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt( br.readLine() );				
		for(int i=0; i<n; i++) 
			bw.write( fun( br.readLine() ) + "\n" );
		bw.flush();
		bw.close();
		br.close();
	}

	private static String fun(String str) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> head = new Stack<>();
		Stack<Character> tail = new Stack<>();

		char[] arr = str.toCharArray();
		for(char c : arr) {
			if( c == '<' ) {
				if( !head.isEmpty() )
					tail.push(head.pop());
			}
			else if( c == '>' ) {
				if( !tail.isEmpty() )
					head.push(tail.pop());
			}
			else if( c == '-') {
				if( !head.isEmpty() ) 
					head.pop();
			}
			else
				head.push(c);
		}
		for(Character c : head) 
			sb.append(c);

		while(!tail.isEmpty())
			sb.append(tail.pop());

		return sb.toString();
	}
}