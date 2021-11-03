
import java.util.*;

public class boxerSorting {

    public static void main(String[] args) {

        int[] weights = { 145, 92, 86 };
        String[] head2head = { "NLW", "WNL", "LWN" };

        // int[] weights = { 50, 82, 75, 120 };
        // String[] head2head = { "NLWL", "WNLL", "LWNW", "WWLN" };

        Solution s = new Solution();
        System.out.println(s.solution(weights, head2head));
    }

    static class Solution {
        public int[] solution(int[] weights, String[] head2head) {

            List<Boxer> list = new ArrayList<>();
            for (int i = 0; i < weights.length; i++) {

                int win = 0, lose = 0, overWeigth = 0;
                for (int j = 0; j < head2head.length; j++) {
                    if (head2head[i].charAt(j) == 'W') {
                        win++;
                        if (weights[i] < weights[j]) {
                            overWeigth++;
                        }
                    } else if (head2head[i].charAt(j) == 'L') {
                        lose++;
                    }
                }
                double winRate = (double) ((double) win / (double) (head2head[0].length()));
                if (win + lose != 0 && win + lose != head2head[i].length() - 1) {
                    winRate = (double) ((double) win / (double) (win + lose));
                } else if (win + lose == 0) {
                    winRate = 0;
                }
                list.add(new Boxer(i, weights[i], winRate, overWeigth));
            }

            Comparator<Boxer> reverseWin = Comparator.comparing(Boxer::getWinRate).reversed();
            Comparator<Boxer> reverseOverweight = Comparator.comparing(Boxer::getOverWeight).reversed();
            Comparator<Boxer> reverseWeight = Comparator.comparing(Boxer::getWeight).reversed();

            list.sort(reverseWin.thenComparing(reverseOverweight).thenComparing(reverseWeight)
                    .thenComparing(Boxer::getNumber));

            return makeArray(list, weights);
        }

        private int[] makeArray(List<Boxer> list, int[] weights) {
            int[] answer = new int[weights.length];
            for (int i = 0; i < weights.length; i++) {
                answer[i] = list.get(i).number + 1;
            }
            return answer;
        }
    }
}

// N none
class Boxer {
    int number;
    int weight;
    double winRate;
    int overWeigth;

    Boxer(int n, int w, double winRate, int o) {
        this.number = n;
        this.weight = w;
        this.winRate = winRate;
        this.overWeigth = o;
    }

    int getNumber() {
        return number;
    }

    int getWeight() {
        return weight;
    }

    double getWinRate() {
        return winRate;
    }

    int getOverWeight() {
        return overWeigth;
    }
}