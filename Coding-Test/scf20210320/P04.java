import java.io.*;
import java.util.*;

class Content {
    int isopen;
    char alpa;
    double p;
    int x;
    int y;

    Content(int open, char a, double p, int x, int y) {
        this.isopen = open;
        this.alpa = a;
        this.p = p;
        this.x = x;
        this.y = y;
    }

    public int getIsopen() {
        return isopen;
    }

    public double getP() {
        return p;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class P04 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double[] Darr = new double[5];
        for (int i = 0; i < Darr.length; i++) {
            Darr[i] = Double.parseDouble(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char[][] Carr1 = new char[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                Carr1[i][j] = str.charAt(j);
            }
        }

        char[][] Carr2 = new char[y][x];
        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                Carr2[i][j] = str.charAt(j);
            }
        }

        List<Content> list = new ArrayList<Content>();
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (Carr1[i][j] == 'Y') {
                    if (Carr2[i][j] == 'A') {
                        list.add(new Content(1, 'A', Darr[0], j, i));
                    } else if (Carr2[i][j] == 'B') {
                        list.add(new Content(1, 'B', Darr[1], j, i));
                    } else if (Carr2[i][j] == 'C') {
                        list.add(new Content(1, 'C', Darr[2], j, i));
                    } else if (Carr2[i][j] == 'D') {
                        list.add(new Content(1, 'D', Darr[3], j, i));
                    } else if (Carr2[i][j] == 'E') {
                        list.add(new Content(1, 'E', Darr[4], j, i));
                    }
                } else if (Carr1[i][j] == 'O') {
                    if (Carr2[i][j] == 'A') {
                        list.add(new Content(2, 'A', Darr[0], j, i));
                    } else if (Carr2[i][j] == 'B') {
                        list.add(new Content(2, 'B', Darr[1], j, i));
                    } else if (Carr2[i][j] == 'C') {
                        list.add(new Content(2, 'C', Darr[2], j, i));
                    } else if (Carr2[i][j] == 'D') {
                        list.add(new Content(2, 'D', Darr[3], j, i));
                    } else if (Carr2[i][j] == 'E') {
                        list.add(new Content(2, 'E', Darr[4], j, i));
                    }
                }
            }
        }

        Comparator<Content> reverse = Comparator.comparing(Content::getP).reversed();
        list.sort(Comparator.comparing(Content::getIsopen).thenComparing(reverse).thenComparing(Content::getY)
                .thenComparing(Content::getX));

        for (Content c : list) {

            double per = Double.parseDouble(String.format("%.2f", c.p));
            System.out.println(c.alpa + " " + per + " " + c.y + " " + c.x);
        }
    }
}