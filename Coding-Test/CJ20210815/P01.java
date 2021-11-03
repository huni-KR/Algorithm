public class P01 {
    public static void main(String[] args) {
        int[] x = { 5 };
        int[] y = { 5 };
        int[] r = { 5 };
        int[] v = { 92, 83, 14, 45, 66, 37, 28, 9, 10, 81 };
        Solution s = new Solution();
        System.out.println(s.solution(x, y, r, v));
    }

    static class Solution {
        public int solution(int[] x, int[] y, int[] r, int[] v) {

            int[] lrbt = findlrbt(x, y, r);

            int cnt = 0;
            for (int i = 0; i < v.length; i += 2) {

                int tx = lrbt[0] + v[i] % (lrbt[1] - lrbt[0]);
                int ty = lrbt[2] + v[i + 1] % (lrbt[3] - lrbt[2]);

                System.out.println(tx + " " + ty);

                if (isIn(x, y, r, tx, ty)) {
                    cnt++;
                }
            }

            double tmp = ((double) cnt / (double) (v.length / 2));

            return (int) (tmp * (lrbt[1] - lrbt[0]) * (lrbt[3] - lrbt[2]));
        }

        public boolean isIn(int[] x, int[] y, int[] r, int tx, int ty) {

            for (int i = 0; i < x.length; i++) {

                double disX = Math.abs(x[i] - tx);
                double disY = Math.abs(y[i] - ty);

                double dis = Math.sqrt(disX * disX + disY * disY);

                if (dis <= r[i]) {
                    return true;
                }
            }

            return false;
        }

        public int[] findlrbt(int[] x, int[] y, int[] r) {

            int il = Integer.MAX_VALUE;
            int ir = Integer.MIN_VALUE;
            int ib = Integer.MAX_VALUE;
            int it = Integer.MIN_VALUE;

            for (int i = 0; i < x.length; i++) {
                il = Math.min(il, x[i] - r[i]);
                ir = Math.max(ir, x[i] + r[i]);
                ib = Math.min(ib, y[i] - r[i]);
                it = Math.max(it, y[i] + r[i]);
            }

            int[] result = { il, ir, ib, it };
            return result;
        }
    }
}
