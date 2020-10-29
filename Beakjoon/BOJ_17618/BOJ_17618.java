import java.util.Scanner;

public class BOJ_17618 {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        kb.close();

                            
        int n = Integer.parseInt( str );
        int count = 0;
        for(int i=1; i<=n; i++){
            int num = fun(Integer.toString(i));
            if( i % num == 0 )
                count++;
        }
        
        System.out.println( count );

    }

    private static int fun(String str) {
        int result = 0;
        for(int i=0; i<str.length(); i++ )
            result += str.charAt(i) - '0';
        return result;
    }
}