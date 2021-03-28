import java.io.*;
import java.util.*;

class A implements Comparable<A>{
    int s;
    int e;
    int v;
    public A(int s, int e, int v) {
        super();
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(A arg0) {
        return arg0.v >= this.v ? -1 : 1;
    }
}

public class P02 {
    
    static PriorityQueue<A> pq; 
    static int[] parent;   
    static int result; 
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<A>();

        Set<String> set = new HashSet<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        int count = 1;
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            String e = st.nextToken();
            set.add(s);
            set.add(e);
            
            if( !map.containsKey(s) ){
                map.put(s, count++);
            }
            if( !map.containsKey(e) ){
                map.put(e, count++);
            }

            pq.add(new A(map.get(s), map.get(e), Integer.parseInt(st.nextToken())));
        }
                  
        parent = new int[set.size()+1]; 
        for (int i = 1; i < parent.length; i++) {
            parent[i]=i;
        } 
        
        for (int i = 0; i < n; i++) {
            A oneNode = pq.poll(); 
            int start = oneNode.s; 
            int end = oneNode.e;
            int a = find(start); 
            int b = find(end);   
            if( a == b ) continue;
                
            union(start,end); 
            result += oneNode.v;
        }
        System.out.println(result);
    }

    public static int find(int a){
        if(a==parent[a]) return a; 
        parent[a] = find(parent[a]);
        return parent[a];
    }
      
    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot){
            parent[aRoot] = b;
        } else {
            return;
        }
    }
}


 
// public class source {
//     public static int find(int a){
//         if(a==parent[a]) return a; //초기화된 상태(정점이 처음 등장)이면 자기 자신이 부모
//         parent[a] = find(parent[a]); //find 할 때마다 부모는 최상위부모로 설정 (성능 향상)
//         return parent[a];
//         //return find(parent[a]); ← 최상위 부모를 저장하지 않고 매번 여러 단계를 올라가 찾으면 시간 초과 발생
//     }
      
//     public static void union(int a, int b){
//         int aRoot = find(a);
//         int bRoot = find(b);
//         if(aRoot != bRoot){
//             parent[aRoot] = b;
//         } else {
//             return;
//         }
//     }
  
// static int N; // 정점의 개수
// static int E; // 간선의 개수
// static PriorityQueue<A> pq; // 간선 값을 Min Heap 으로 하는 우선순위 큐
// static int[] parent;   // disjoint-set(union find)에서 필요한 부모 노드를 저장하는 배열
// static boolean[] visit; //방문 여부 배열
// static int result; //결과 값 저장
  
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         N = Integer.valueOf(br.readLine());  //노드의 개수
//         E = Integer.valueOf(br.readLine());  // 간선의 개수
          
//         parent = new int[N+1];  //Disjoint-set 
//         visit  = new boolean[N+1];
//         result = 0;
          
//         pq = new PriorityQueue<A>();
//         String [] tempStr ;
//         for (int i = 0; i < E; i++) {
//             tempStr = br.readLine().split(" ");
//             pq.add(new A(Integer.valueOf(tempStr[0]), Integer.valueOf(tempStr[1]), Integer.valueOf(tempStr[2])));
//         } //모든 간선에 대해 [시작, 끝, 비용] 을 가진 클래스로 우선순위 큐에 add
          
//         for (int i = 1; i <= N; i++) {
//             parent[i]=i;
//         } // union-find 의 초기화는 일단 자기 자신의 부모노드는 자기 자신으로 설정
          
//         for (int i = 0; i < E; i++) { //모든 간선에 대해서 확인
//             A oneNode = pq.poll(); // 현재 큐에 있는 모든 인스턴스 중 비용이 가장 작은 간선이 poll 된다.
//             int start = oneNode.s; 
//             int end = oneNode.e;
//             int a = find(start); // 만약 이 간선을 선택해서 연결한다고 했을때 사이클이 생기면 안되므로 
//             int b = find(end);   // 양쪽의 루트(최상위부모)노드가 무엇인지 확인하고
//             if( a == b ) continue; //만약 같으면 선택하지 않고 넘어간다.
              
//             union(start,end); //두개의 루트 노드가 달랐다면 한쪽의 최상위 부모를 다른 한쪽의 부모로 설정하고
//             result += oneNode.v; //선택된 간선이므로 간선의 비용을 더한다.
//         }
//         System.out.println(result);
//     }
  
// }