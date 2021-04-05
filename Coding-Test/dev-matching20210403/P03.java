import java.util.*;

public class P03 {
    
    public static void main(String[] args){
        Solution s = new Solution();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println( s.solution( enroll, referral, seller, amount ) );
    }
}

class Data{
    String name;
    String parent;
    boolean isLeaf;
    int amount;
    int result;

    Data(String n, String p, boolean l, int a, int r){
        this.name = n;
        this.parent = p;
        this.isLeaf = l;
        this.amount = a;
        this.result = r;
    }
}

class Solution {

    boolean[] isLeaf;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // Map<String, Integer> mapRelation = new HashMap<String, Integer>();
        // int pos = 1;
        // mapRelation.put("-", 0);
        // for(int i=0; i<enroll.length; i++){
        //     mapRelation.put(enroll[i], pos++);
        // }

        // List<Integer>[] list = new ArrayList[mapRelation.size()];
        // for(int i=0; i<list.length; i++){
        //     list[i] = new ArrayList<Integer>();
        // }

        // isLeaf = new boolean[mapRelation.size()];
        // for(int i=0; i<referral.length; i++){
        //     isLeaf[mapRelation.get(referral[i])] = false;
            
        //     int s = mapRelation.get(enroll[i]);
        //     int e = mapRelation.get(referral[i]);

        //     list[s].add(e);
        //     list[e].add(s);
        // }

        // Map<String, Integer> mapSeller = new HashMap<String, Integer>();
        // for(int i=0; i<seller.length; i++){
        //     mapSeller.put(seller[i], amount[i]);
        // }
        
        // Arrays.fill(isLeaf, true);
        // for(int i=0; i<referral.length; i++){
        //     isLeaf[mapRelation.get(referral[i])] = false;
        // }

        // int[] answer = new int[enroll.length];

        // for(int i=0; i<isLeaf.length; i++){
        //     if( isLeaf[i] ){
                
        //     }
        // }






        return answer;
    }
}