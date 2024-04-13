//package baek_joon.class_3.맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    //테케
    static int tc;
    //가로, 세로 길이
    static int n, m;
    //좌표 저장
    static ArrayList<Point> list;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        //인접행렬 입력받기
        for (int i = 0; i < tc; i++) {
            //편의점 개수
            int store_count = Integer.parseInt(br.readLine());
            list = new ArrayList<Point>();
            visited = new boolean[store_count + 2];

            for (int m = 0; m < store_count + 2; m++) {

                String[] node = br.readLine().split(" ");
                int a = Integer.parseInt(node[0]);
                int b = Integer.parseInt(node[1]);
                list.add(new Point(a, b));
            }
            int result = bfs(list, visited, 0, 0);
            if (result == 1) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }
        }
        System.out.print(sb.toString().trim());
    }

    private static int bfs(ArrayList<Point> list, boolean[] visited, int x, int y) {

        //락페 좌표
        int rX = list.get(list.size() - 1).getX();
        int rY = list.get(list.size() - 1).getY();

        Queue<Point> que = new LinkedList<>();

        //시작 위치 삽입
        que.add(new Point(x, y));
        int dist = 0;

        //x,y 행렬 방문 체크
        visited[0] = true;
        while (!que.isEmpty()) {
            Point nowNode = que.poll();
            int curX = nowNode.getX();
            int nX = list.get(curX).x;
            int curY = nowNode.getY();
            int nY = list.get(curY).y;

            if (nX == rX && nY == rY) {
                return 1;
            }
            for (int s = 0; s < list.size(); s++) {
                int x2 = list.get(s).x; // 다음 좌표 x 값
                int y2 = list.get(s).y; // 다음 좌표 y 값
                int temp = x2 + y2;
                dist = Math.abs(nX - x2) + Math.abs(nY - y2);
//                dis = Math.abs(curX - x2) + Math.abs(curY - y2);
                if (dist <= 1000 && !visited[s]) {
                    visited[s] = true;
                    que.add(new Point(s, s));
                }
            }
        }
        return 0;
    }


    public static class Point {
        private final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

/**
 * 방문 배열 길이
 * 좌표 저장 할 자료 구조
 * 좌표 음수일 때
 */