import java.io.*;

public class P041 {

    static long ans;

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

        for(int i=0; i<target.length; i++){
            ans=0L;
            for(int j=0; j<str.length; j++){                
                KMP(str[j], target[i]);
            }
            System.out.println(ans);
        }
        br.close();        
    }

	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j=0;
		for(int i=1;i<pattern.length();i++) {
			while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(pattern.charAt(i)==pattern.charAt(j)) 
				pi[i] = ++j;
		}
		return pi;
	}
	
	static void KMP(String origin, String ptn) {
		int[] pi = getPi(ptn);
		int j=0;
		for(int i=0;i<origin.length();i++) {
			while(j>0 && origin.charAt(i)!=ptn.charAt(j)) {
				j=pi[j-1];
			}
			if(origin.charAt(i)==ptn.charAt(j)) {
				if(j==ptn.length()-1) {
					ans++;
					break;
				}
				else
					j++;
			}
		}
	}
}