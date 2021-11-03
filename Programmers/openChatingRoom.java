import java.util.*;

class User {
    String type;
    String id;

    User(String t, String i) {
        this.type = t;
        this.id = i;
    }
}

public class openChatingRoom {

    public static void mian(String[] args) {

        String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };

        Solution s = new Solution();
        s.solution(record);
    }

    public static class Solution {
        public String[] solution(String[] record) {

            HashMap<String, String> hashMap = new HashMap<>();
            ArrayList<User> list = new ArrayList<>();

            for (int i = 0; i < record.length; i++) {
                StringTokenizer st = new StringTokenizer(record[i], " ");

                String type = st.nextToken();
                String id = st.nextToken();

                if (type.equals("Enter")) {
                    String nickName = st.nextToken();
                    hashMap.put(id, nickName);

                    list.add(new User(type, id));
                } else if (type.equals("Leave")) {
                    list.add(new User(type, id));
                } else if (type.equals("Change")) {
                    String nickName = st.nextToken();
                    hashMap.put(id, nickName);
                }
            }

            String[] result = new String[list.size()];
            for (int i = 0; i < result.length; i++) {
                if (list.get(i).type.equals("Enter")) {
                    result[i] = hashMap.get((String) list.get(i).id) + "님이 들어왔습니다.";
                } else {
                    result[i] = hashMap.get((String) list.get(i).id) + "님이 나갔습니다.";
                }
            }

            return result;
        }
    }
}
