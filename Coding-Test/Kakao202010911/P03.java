import java.util.*;

import javax.sound.midi.Receiver;

class Car {
    String carNumber;
    String inTime;
    String outTime;
    int useMin;

    Car(String c, String i) {
        this.carNumber = c;
        this.inTime = i;
        this.outTime = "23:59";
    }

    int calcMin(String inTime, String outTime) {
        StringTokenizer st = new StringTokenizer(inTime, ":");
        int inH = Integer.parseInt(st.nextToken());
        int inM = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(outTime, ":");
        int outH = Integer.parseInt(st.nextToken());
        int outM = Integer.parseInt(st.nextToken());

        return ((outH - inH) * 60) + (outM - inM);
    }

    String getCarNumber() {
        return this.carNumber;
    }
}

class Data {
    String number;
    int cost;

    Data(String n, int c) {
        this.number = n;
        this.cost = c;
    }

    String getNumber() {
        return number;
    }
}

public class P03 {
    public static void main(String[] args) {

        int[] fees = { 180, 5000, 10, 600 };
        String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

        Solution s = new Solution();
        s.solution(fees, records);
    }

    static class Solution {
        public int[] solution(int[] fees, String[] records) {

            ArrayList<Car> list = new ArrayList<>();
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < records.length; i++) {
                StringTokenizer st = new StringTokenizer(records[i], " ");
                String time = st.nextToken();
                String carNumber = st.nextToken();
                String status = st.nextToken();

                if (status.equals("IN")) {
                    list.add(new Car(carNumber, time));
                } else {
                    for (Car c : list) {
                        if (c.carNumber.equals(carNumber) && c.outTime.equals("23:59")) {
                            c.outTime = time;
                        }
                    }
                }
            }

            for (Car c : list) {
                c.useMin = c.calcMin(c.inTime, c.outTime);
            }

            Map<String, Integer> map = new HashMap<>();
            for (Car c : list) {
                if (map.containsKey(c.carNumber)) {
                    map.put(c.carNumber, map.get(c.carNumber) + c.useMin);
                } else {
                    map.put(c.carNumber, c.useMin);
                }
            }

            ArrayList<Data> datas = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int min = entry.getValue();
                int cost = fees[1];

                if (min > fees[0]) {
                    cost = fees[1] + (int) (Math.ceil((double) ((double) min - (double) fees[0]) / (double) fees[2])
                            * fees[3]);
                }

                datas.add(new Data(entry.getKey(), cost));
            }

            datas.sort(Comparator.comparing(Data::getNumber));
            int[] answer = new int[datas.size()];

            int pos = 0;
            for (Data data : datas) {
                answer[pos++] = data.cost;
            }
            return answer;
        }
    }
}
