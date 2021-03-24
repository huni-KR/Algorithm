import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3 {
	
	static int N, M, E, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
		
		System.out.println(slide());
	}

	private static int slide() {

        int l = E, r = E, sum = 0, min = arr[arr.length-1] - arr[0];
        
        int NPos = 0;
		while (true) {
            NPos = find();
			if (sum < M) {
                // 오른쪽
                if( E < arr[NPos] ){                    
                    if( Math.abs( arr[NPos-1] - E ) < Math.abs( arr[NPos] - E ) ){
                        l = arr[NPos-1];
                        E = l;
                    }
                    else{
                        r = arr[NPos];
                        E = r;
                    }
                }
                // 왼쪽
                else if( arr[NPos] < E ){                      
                    if( Math.abs( arr[NPos] - E ) < Math.abs( arr[NPos+1] - E ) ){
                        r = arr[NPos+1];
                        E = r;
                    }
                    else{
                        l = arr[NPos];
                        E = l;
                    }
                }
                sum++;
            }
			else
                break;        
        }
        
        if( min > r - l)
            min = r - l;
        return min;
	}
    public static int find(){

        int min = 100000;
        int result = 0;
        for(int i=0; i<arr.length; i++){
            if( arr[i] == E )
                continue;
            if( min > Math.abs(arr[i]-E) ) {
                min = Math.abs(arr[i]-E);
                result = i;
            }
        }

        return result;
    }
}