//package baek_joon.class_3.유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;


/**
 * @Point - 시작 노드 설정
 * - 4방 탐색
 * - 4방 탐색 결과 방문 체크 및 DFS 호출
 * - 4방 탐색하면서 1있으면 dfs 재귀호출 지속, 1 없다면 종료
 * - 상하 좌우로 탐색하기에 1이 여러 개 있다면 원래 노드로 복귀해야 함
 * - 단지 탐색 종료 후 카운팅 어디서 누적?
 */
public class Main {
    static int n, m;
    static int[][] g;
    static boolean[][] visited;
    //4방 탐색 델타 배열
    static int[] node;
    static int count;
    static int x, y;

    public static void main(String[] args) throws IOException {
        // 인접행렬 할당

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
//        for (int w = 0; w < tc; w++) {

        for (int t = 1; t <= tc; t++) {
            String[] info = br.readLine().split(" ");
            m = Integer.parseInt(info[0]);
            n = Integer.parseInt(info[1]);
            int k = Integer.parseInt(info[2]);

            g = new int[51][51];

            //노드 저장
            node = new int[51];
            // 인접 행렬 할당
            for (int i = 1; i <= k; i++) {
                String[] ab = br.readLine().split(" ");
                int x = Integer.parseInt(ab[0]);
                int y = Integer.parseInt(ab[1]);
                g[x][y] = 1;
            }

//            System.out.println("====");
            //인접 행렬 출력
//            for (int i = 0; i < g.length; i++) {
//                for (int j = 0; j < g[i].length; j++) {
//                    System.out.print(g[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("====");

            // 방문 배열 할당
            visited = new boolean[51][51];
            int result = 0;
            //시작할 노드 찾기 (0,0)
            // 1이 있으면 dfs Call
            for (int i = 0; i < 51; i++) {
                for (int j = 0; j < 51; j++) {
                    if (g[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j, g, visited);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
//        System.out.println();
    }


//}


    //DFS 동작
    private static void dfs(int x, int y, int[][] g, boolean[][] visited) {
        //방문 체크
        visited[x][y] = true;
        // 상하 좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
//        System.out.println();
//        System.out.println("Node: " + g[x][y]);
//        System.out.println("x좌표: " + x + " / y좌표: " + y);

        // 4방 탐색하며 인접 노드 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || x > g.length || y > g[0].length) {
                continue;
            }

//            System.out.println(nx + " !GO! " + ny);
//            System.out.println("Graph:  " + g[nx][ny]);

            if (g[nx][ny] == 0) {
                continue;
            }

            // 방문하지 않았고, 노드 있으면 방문체크, dfs recursive call
            if (!visited[nx][ny] && g[nx][ny] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny, g, visited);
                // 여기서 단지 탐색 후 또 다시 반복됨
            }

        }

    }
}


/**
 * 배추가 심어져있는 곳만 인접 행렬에 할당해주어야 함
 * 노드의 시작점을 따로 지정해주지 안았으므로, 찾아내고 시작 노드를 설정해야 한다
 * 메인 메소드에서 graph를 탐색하며 1이 발견되면, 해당 노드를 기준으로 dfs를 호출한다
 */
