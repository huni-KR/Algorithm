

import java.util.*;

public class insertAdvertising {
    public static void main(String[] args) {

        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
                "01:37:44-02:02:30" };

        Solution s = new Solution();
        System.out.println(s.solution(play_time, adv_time, logs));

        // "01:30:59"
    }
}

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {

        for (int i = 0; i < logs.length; i++) {
            StringTokenizer st = new StringTokenizer(logs[i], "-");
            int startTime = Integer.parseInt(st.nextToken().replace(":", ""));
            int endTime = Integer.parseInt(st.nextToken().replace(":", ""));

            System.out.println(startTime + " " + endTime);
            System.out.println(endTime - startTime);
            System.out.println();

            // double test = Double.parseDouble(endTime);
        }

        String answer = "";
        return answer;

    }
}