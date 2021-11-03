

import java.util.*;
import java.util.Map.Entry;

public class jobRecommand {

    public static void main(String[] args) {

        // String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT
        // JAVA PYTHON SQL C++",
        // "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON
        // KOTLIN PHP",
        // "GAME C++ C# JAVASCRIPT C JAVA" };
        // String[] languages = { "PYTHON", "C++", "SQL" };
        // int[] preference = { 7, 5, 5 };

        String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA" };
        String[] languages = { "JAVA", "JAVASCRIPT" };
        int[] preference = { 7, 5 };

        Solution s = new Solution();
        System.out.println(s.solution(table, languages, preference));
    }

    static class Solution {
        public String solution(String[] table, String[] languages, int[] preference) {

            Map[] maps = new HashMap[table.length];
            for (int i = 0; i < maps.length; i++) {
                maps[i] = new HashMap<String, Integer>();
            }

            Map<String, Integer> companyMap = new HashMap<>();
            for (int i = 0; i < table.length; i++) {
                StringTokenizer st = new StringTokenizer(table[i], " ");
                int count = st.countTokens() - 1;

                String company = st.nextToken();
                companyMap.put(company, i);
                while (st.hasMoreTokens()) {
                    maps[i].put(st.nextToken(), count--);
                }
            }

            int[] result = new int[table.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < languages.length; j++) {
                    result[i] += (int) maps[i].getOrDefault(languages[j], 0) * preference[j];
                }
            }

            int max = findMax(result);

            List<String> resultList = new ArrayList<>();
            for (int i = 0; i < result.length; i++) {
                if (result[i] == max) {
                    for (Entry<String, Integer> entry : companyMap.entrySet()) {
                        if (entry.getValue() == i) {
                            resultList.add(entry.getKey());
                        }
                    }
                }
            }

            Collections.sort(resultList);
            return resultList.get(0);
        }

        private int findMax(int[] result) {
            int max = 0;
            for (int i = 0; i < result.length; i++) {
                max = Math.max(max, result[i]);
            }
            return max;
        }
    }
}
