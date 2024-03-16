

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Formattable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Subject - BFS 풀이
 */

/**
 * @Point 왜 그래프 n+2, m+2로 해줘야 하는지
 * 큐 BFS 4방탐색
 * 예제 2에서 4,0 탐색 안 됨
 * 4방탐색 continue 조건 설정
 */
public class Main {
    // 가로 m, 세로 n, 노드 k
    static int m, n, k;
    static int[][] graph;
    static boolean[][] visit;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테케
        int tc = Integer.parseInt(br.readLine());
        //가로길이, 세로길이, 노드
        for (int i = 1; i <= tc; i++) {

            String[] info = br.readLine().split(" ");
            m = Integer.parseInt(info[0]);
            n = Integer.parseInt(info[1]);
            k = Integer.parseInt(info[2]);

            // 인접 행렬 할당
            graph = new int[51][51];
            visit = new boolean[51][51];

            //인접 행렬 할당 2
            for (int j = 1; j <= k; j++) {
                String[] ab = br.readLine().split(" ");
                int x = Integer.parseInt(ab[0]);
                int y = Integer.parseInt(ab[1]);
                graph[x][y] = 1;
            }
            for (int x = 0; x < graph.length; x++) {
                for (int y = 0; y < graph[x].length; y++) {
                    if (graph[x][y] == 1 && !visit[x][y]) {
                        count++;
                        bfs(x, y, visit, graph);
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }
    }

    //BFS 시작
    private static void bfs(int x, int y, boolean[][] visit, int[][] graph) {


        //델타 4방 탐색
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        //큐 배열 선언
        Queue<int[]> queue = new LinkedList<>();
        //큐에 시작노드 좌표 삽입
        queue.add(new int[]{x, y});

        //방문 체크
        visit[x][y] = true;
        //BFS 반복
        while (!queue.isEmpty()) {

            //좌표배열 있어야 함
            int[] current = queue.poll();
            int nowX = current[0];
            int nowY = current[1];

            //4방 탐색 인접행렬
            for (int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];

                if (nx < 0 || ny < 0 || nx >= graph.length || ny >= graph[0].length) {
                    continue;
                }


                // 큐에 방문하지 않았고, 4방 탐색 좌표가 1이라면
                if (graph[nx][ny] == 1 && !visit[nx][ny]) {
                    //방문 처리
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

    }
}
