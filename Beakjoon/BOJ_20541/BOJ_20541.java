package BOJ_20541;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class BOJ_20541 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static Album now;

    static class Album {
        Album parent;
        String name;
        TreeMap<String, Album> album;
        TreeSet<String> photo;

        Album(Album parent, String name) {
            this.parent = parent;
            this.name = name;
            this.album = new TreeMap<>();
            this.photo = new TreeSet<>();
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        now = new Album(null, "album");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            String value = st.nextToken();

            if (command.equals("mkalb")) {
                handleMkalb(value);
            } else if (command.equals("rmalb")) {
                handleRmalb(value);
            } else if (command.equals("insert")) {
                handleInsert(value);
            } else if (command.equals("delete")) {
                handleDelete(value);
            } else if (command.equals("ca")) {
                handleCA(value);
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void handleCA(String value) throws IOException {
        if (value.equals("..")) {
            if (now.parent != null) {
                now = now.parent;
            }
        } else if (value.equals("/")) {
            while (now.parent != null) {
                now = now.parent;
            }
        } else {
            if (now.album.containsKey(value)) {
                now = now.album.get(value);
            }
        }
        sb.append(now.name + "\n");
    }

    private static void handleDelete(String value) throws IOException {
        int cntPhoto = 0;
        if (value.equals("-1")) {
            if (now.photo.size() > 0) {
                String str = now.photo.first();
                now.photo.remove(str);
                cntPhoto++;
            }
        } else if (value.equals("0")) {
            cntPhoto += now.photo.size();
            now.photo = new TreeSet<>();
        } else if (value.equals("1")) {
            if (now.photo.size() > 0) {
                String str = now.photo.last();
                now.photo.remove(str);
                cntPhoto++;
            }
        } else {
            if (now.photo.remove(value)) {
                cntPhoto++;
            }
        }
        sb.append(Integer.toString(cntPhoto) + "\n");
    }

    private static void handleInsert(String value) throws IOException {
        if (now.photo.contains(value)) {
            sb.append("duplicated photo name\n");
            return;
        }
        now.photo.add(value);
    }

    private static void handleRmalb(String value) throws IOException {
        int cntAlbum = 0, cntPhoto = 0;
        if (value.equals("-1")) {
            if (now.album.size() > 0) {
                String str = now.album.firstKey();
                int[] cnt = remove(now.album.get(str));

                cntAlbum += cnt[0];
                cntPhoto += cnt[1];

                now.album.remove(str);
            }
        } else if (value.equals("0")) {
            List<String> list = new ArrayList<>(now.album.keySet());
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                int[] cnt = remove(now.album.get(str));

                cntAlbum += cnt[0];
                cntPhoto += cnt[1];
            }
            now.album = new TreeMap<>();
        } else if (value.equals("1")) {
            if (now.album.size() > 0) {
                String str = now.album.lastKey();
                int[] cnt = remove(now.album.get(str));

                cntAlbum += cnt[0];
                cntPhoto += cnt[1];

                now.album.remove(str);
            }
        } else {
            if (now.album.containsKey(value)) {
                int[] cnt = remove(now.album.get(value));

                cntAlbum += cnt[0];
                cntPhoto += cnt[1];

                now.album.remove(value);
            }
        }
        sb.append(Integer.toString(cntAlbum) + " " + Integer.toString(cntPhoto) + "\n");
    }

    private static int[] remove(Album alb) {
        int[] cnt = new int[2];
        if (alb.album.size() == 0) {
            return new int[] { 1, alb.photo.size() };
        }
        for (String str : alb.album.keySet()) {
            int[] tmp = remove(alb.album.get(str));
            cnt[0] += tmp[0];
            cnt[1] += tmp[1];
        }
        cnt[0]++;
        cnt[1] += alb.photo.size();
        return cnt;
    }

    private static void handleMkalb(String value) throws IOException {
        if (now.album.containsKey(value)) {
            sb.append("duplicated album name\n");
            return;
        }
        now.album.put(value, new Album(now, value));
    }
}