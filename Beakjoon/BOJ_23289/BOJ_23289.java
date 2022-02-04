package BOJ_23289;

import java.io.*;
import java.util.*;

public class BOJ_23289 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            return (this.x == ((Point) object).x && this.y == ((Point) object).y);
        }
    }

    static class Heater {
        Point point;
        int dict; // 1 : R 2 : L 3 : U 4 : D

        Heater(Point point, int dict) {
            this.point = point;
            this.dict = dict;
        }
    }

    static class Wall {
        Point p;
        int dict;

        Wall(Point p, int dict) {
            this.p = p;
            this.dict = dict;
        }
    }

    static class Wind {
        Point from;
        int dict;
        int power;

        Wind(Point p, int dict, int power) {
            this.from = p;
            this.dict = dict;
            this.power = power;
        }
    }

    static int[][] dx = {
            { 0, 0, 0 },
            { 1, 1, 1 },
            { -1, -1, -1 },
            { -1, 0, 1 },
            { -1, 0, 1 }
    };
    static int[][] dy = {
            { 0, 0, 0 },
            { -1, 0, 1 },
            { -1, 0, 1 },
            { -1, -1, -1 },
            { 1, 1, 1 }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int heat = Integer.parseInt(st.nextToken());

        int[][] originArray = new int[r + 1][c + 1];
        ArrayList<Heater> heaters = new ArrayList<>();
        ArrayList<Point> checkPoints = new ArrayList<>();
        for (int i = 1; i < r + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < c + 1; j++) {
                originArray[i][j] = Integer.parseInt(st.nextToken());
                if (originArray[i][j] > 0 && originArray[i][j] < 5) {
                    heaters.add(new Heater(new Point(j, i), originArray[i][j]));
                } else if (originArray[i][j] == 5) {
                    checkPoints.add(new Point(j, i));
                }
            }
        }

        int w = Integer.parseInt(br.readLine());
        ArrayList<Wall> walls = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int wx = Integer.parseInt(st.nextToken());
            int wy = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            // 1 : R 2 : L 3 : U 4 : D
            if (t == 0) {
                walls.add(new Wall(new Point(wx, wy), 2));
                walls.add(new Wall(new Point(wx - 1, wy), 1));
            } else {
                walls.add(new Wall(new Point(wx, wy), 4));
                walls.add(new Wall(new Point(wx, wy + 1), 3));
            }
        }

        int[][] heatMap = new int[r + 1][c + 1];

        int choco = 0;
        while (choco <= 100 || !checkHeatPoint(heatMap, checkPoints, heat)) {
            for (Heater heater : heaters) {
                blow(heatMap, heater, walls);
                PrintHeatMap(heatMap);
            }

            heatMap = controlHeat(heatMap);

            choco++;
        }
        System.out.println(choco > 100 ? 101 : choco);
    }

    private static int[][] controlHeat(int[][] heatMap) {
        int[][] newMap = new int[heatMap.length][heatMap[0].length];

        return newMap;
    }

    private static void PrintHeatMap(int[][] heatMap) {
        for (int i = 1; i < heatMap.length; i++) {
            for (int j = 1; j < heatMap[0].length; j++) {
                System.out.print(heatMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    // 1 : R 2 : L 3 : U 4 : D
    private static void blow(int[][] heatMap, Heater heater, ArrayList<Wall> walls) {

        boolean[][] visit = new boolean[heatMap.length][heatMap[0].length];
        visit[heater.point.y][heater.point.x] = true;

        Queue<Wind> queue = new LinkedList<>();
        queue.add(new Wind(heater.point, heater.dict, 5));

        while (!queue.isEmpty()) {
            Wind wind = queue.poll();

            heatMap[wind.from.y][wind.from.x] += wind.power;

            for (int dic = 0; dic < 3; dic++) {
                int nx = wind.from.x + dx[wind.dict][dic];
                int ny = wind.from.y + dy[wind.dict][dic];

                if (nx < 0 || ny < 0 || nx >= heatMap[0].length || ny >= heatMap.length) {
                    continue;
                }

                if (!visit[ny][nx] && wind.power > 0 && !isWall(walls, wind.from, new Point(nx, ny), wind.dict)) {
                    queue.add(new Wind(new Point(nx, ny), wind.dict, wind.power - 1));
                    visit[ny][nx] = true;
                }
            }
        }
    }

    // 1 : R 2 : L 3 : U 4 : D
    private static boolean isWall(ArrayList<Wall> walls, Point from, Point now, int dict) {
        int dx = now.x - from.x;
        int dy = now.y - from.y;

        for (Wall wall : walls) {
            if (dict == 1) {
                if (dx == 1 && dy == 1) {
                    if (wall.p.equals(from) && wall.dict == 4) {
                        return true;
                    }
                } else if (dx == 1 && dy == 0) {
                    if (wall.p.equals(from) && wall.dict == 2) {
                        return true;
                    }
                } else if (dx == 1 && dy == -1) {
                    if (wall.p.equals(from) && wall.dict == 3) {
                        return true;
                    }
                }
            } else if (dict == 2) {
                if (dx == -1 && dy == 1) {
                    if (wall.p.equals(from) && wall.dict == 4) {
                        return true;
                    }
                } else if (dx == -1 && dy == 0) {
                    if (wall.p.equals(from) && wall.dict == 1) {
                        return true;
                    }
                } else if (dx == -1 && dy == -1) {
                    if (wall.p.equals(from) && wall.dict == 3) {
                        return true;
                    }
                }
            }

            else if (dict == 3) {
                if (dx == -1 && dy == -1) {
                    if (wall.p.equals(from) && wall.dict == 2) {
                        return true;
                    }
                } else if (dx == 0 && dy == -1) {
                    if (wall.p.equals(from) && wall.dict == 3) {
                        return true;
                    }
                } else if (dx == 1 && dy == -1) {
                    if (wall.p.equals(from) && wall.dict == 1) {
                        return true;
                    }
                }
            }

            else if (dict == 4) {
                if (dx == -1 && dy == 1) {
                    if (wall.p.equals(from) && wall.dict == 2) {
                        return true;
                    }
                } else if (dx == 0 && dy == 1) {
                    if (wall.p.equals(from) && wall.dict == 4) {
                        return true;
                    }
                } else if (dx == 1 && dy == 1) {
                    if (wall.p.equals(from) && wall.dict == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkHeatPoint(int[][] heatMap, ArrayList<Point> checkPoints, int heat) {
        for (Point point : checkPoints) {
            if (heatMap[point.y][point.x] < heat) {
                return false;
            }
        }
        return true;
    }
}
