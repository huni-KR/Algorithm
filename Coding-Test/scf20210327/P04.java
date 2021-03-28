import java.io.*;

public class P04 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for(int i=0; i<str.length; i++){
            str[i] = br.readLine();
        }
        
        int t = Integer.parseInt(br.readLine());
        String[] target = new String[t];
        for(int i=0; i<target.length; i++){
            target[i] = br.readLine();
        }

        fun(str, target);
        
        br.close();        
    }

    private static void fun(String[] str, String[] target) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                
        for(int i=0; i<target.length; i++){
            int count = 0;
            int len = target[i].length();

            for(int j=0; j<str.length; j++){
                if( len > str[i].length() ){
                    continue;
                }

                for(int k=0; k<str[j].length()-len+1; k++){
                    String sub = str[j].substring(k, k+len);
                    if( sub.equals(target[i]) ){
                        count++;
                    }                    
                }
            }
            bw.write(Integer.toString(count) + "\n");
        }

        bw.flush();
        bw.close();
    }
}

