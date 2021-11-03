import java.util.*;
import java.util.Map.Entry;

class Data {
    String code;
    int grade;
    int time;

    Data(String c, int g, int t) {
        this.code = c;
        this.grade = g;
        this.time = t;
    }

    int getGrade() {
        return this.grade;
    }

    int getTime() {
        return this.time;
    }
}

public class P02 {
    public static void main(String[] args) {

        // String[] grades = { "DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-",
        // "DS7651 B+", "AI0001 F", "DB0001 B-",
        // "AI5543 D+", "DS7651 A+", "OS1808 B-" };

        String[] grades = { "DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0" };

        Solution s = new Solution();
        System.out.println(s.solution(grades));

    }

    static class Solution {
        public String[] solution(String[] grades) {

            String[] order = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F" };

            Map<String, Integer> gradeMap = new HashMap<>();
            for (int i = 0; i < order.length; i++) {
                gradeMap.put(order[i], i);
            }

            Map<Integer, String> valueMap = new HashMap<>();
            for (int i = 0; i < order.length; i++) {
                valueMap.put(i, order[i]);
            }

            Data[] data = new Data[grades.length];
            Map<String, Integer> posMap = new HashMap<>();
            for (int i = 0; i < grades.length; i++) {

                StringTokenizer st = new StringTokenizer(grades[i], " ");
                String code = st.nextToken();
                int score = gradeMap.get(st.nextToken());

                if (posMap.containsKey(code)) {
                    if (data[posMap.get(code)].grade > score) {
                        data[i] = new Data(code, score, i);
                        posMap.put(code, i);
                    }
                } else {
                    data[i] = new Data(code, score, i);
                    posMap.put(code, i);
                }
            }

            List<Data> resultDatas = new ArrayList<>();
            for (Entry<String, Integer> entry : posMap.entrySet()) {
                resultDatas.add(data[entry.getValue()]);
            }

            resultDatas.sort(Comparator.comparing(Data::getGrade).thenComparing(Data::getTime));

            String[] answer = new String[posMap.size()];
            int pos = 0;
            for (Data d : resultDatas) {
                answer[pos++] = d.code + " " + valueMap.get(d.grade);
            }
            return answer;
        }
    }
}
