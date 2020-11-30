package BOJ_15501;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15501 {
    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt( br.readLine() );  
        StringTokenizer st = new StringTokenizer( br.readLine(), " " );
 
        StringBuilder sb = new StringBuilder();
        while( st.hasMoreTokens() ){
            sb.append( st.nextToken() );
        }
        String origin = sb.toString();
        int num = origin.charAt(0) - '0';
        
        st = new StringTokenizer( br.readLine(), " " );
        int[] arrNew = new int[n];
        for(int i=0; i<arrNew.length; i++ ){
            arrNew[i] = Integer.parseInt( st.nextToken() );
        }

        int index = findIndex( num, arrNew );

        String toRight = strRight( index, arrNew );
        String toLeft = strLeft( index, arrNew );
        
        if( origin.equals( toRight ) || origin.equals( toLeft) )
            System.out.println( "good puzzle");
        else
            System.out.println( "bad puzzle");
    }

    private static String strLeft(int index, int[] arrNew) {
        StringBuilder sb = new StringBuilder();

        for(int i=index; i>=0; i--)
            sb.append( Integer.toString( arrNew[i] ) );

        for(int i=arrNew.length-1; i>index; i--)
            sb.append( Integer.toString( arrNew[i] ) );
        
        return sb.toString();
    }

    private static String strRight(int index, int[] arrNew) {
        StringBuilder sb = new StringBuilder();

        for(int i=index; i<arrNew.length; i++)
            sb.append( Integer.toString( arrNew[i] ) );

        for(int i=0; i<index; i++)
            sb.append( Integer.toString( arrNew[i] ) );
        
        return sb.toString();
    }

    private static int findIndex(int num, int[] arrNew) {
        for(int i=0; i<arrNew.length; i++)
            if( arrNew[i] == num )
                return i;
        return -1;
    }
}
