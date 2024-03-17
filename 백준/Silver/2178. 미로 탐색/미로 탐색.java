//package baek_joon.class_3.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

/**
 * 속도 116
 */
public class Main {
    //델타 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int[][] graph;

    //길이
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        // 인접 행렬 미로 메모리 할당
        graph = new int[n + 1][m + 1];
        //방문 배열 할당
        visit = new boolean[n + 1][m + 1];
        //미로 입력
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            String line = stk.nextToken();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        bfs(0, 0);
        System.out.print(graph[n - 1][m - 1]);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        //시작 노드 삽입
        q.offer(new int[]{x, y});
        //방문 체크
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] nowNode = q.poll();

            //4방탐색
            for (int d = 0; d < 4; d++) {
                int newX = nowNode[0] + dx[d];
                int newY = nowNode[1] + dy[d];

                //4방탐색 탐색조건
                if (newX < 0 || newY < 0 || newX >= n || newY > m) {
                    continue;
                }
                if (graph[newX][newY] == 1 && !visit[newX][newY]) {
                    visit[newX][newY] = true;

                    // 중요 최단경로
                    graph[newX][newY] =
                            graph[nowNode[0]][nowNode[1]] + 1;

                    q.add(new int[]{newX, newY});
                }

            }

        }
        return -1;
    }
}
