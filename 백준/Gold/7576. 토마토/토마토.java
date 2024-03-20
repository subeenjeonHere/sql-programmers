//package baek_joon.class_3.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Subject BFS
 * @Point .
 * BFS 한 레벨 탐색 +1일 최단거리.
 * BFS Depth 어떻게 구할건지
 */
public class Main {
    static int n, m;
    static int[][] g;
    //0개수
    static int zero;
    static int count;
    //델타
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    //방문
    static int[][] visit;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        //가로 M, N 미로 메모리 할당
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n,m 입력
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        g = new int[n][m];
        visit = new int[n][m];

        //0,1 토마토 인접 행렬 입력 받기
        for (int i = 0; i < n; i++) {
            String[] node = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                g[i][j] = Integer.parseInt(node[j]);
                //토마토 익었는지 안 익었는지 확인 위해 0 개수 저장
                if (g[i][j] == 0) {
                    zero += 1;
                }
            }
        }
//        print();

        //시작 부터 안익은 토마토 없으면
        if (zero == 0) {
            System.out.println("0");
            return;
        }

        //1인 노드 찾아서 bfs 시작
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1) {
                    //시작 노드 여러개일 때, 1인 노드 모두 시작 노드로 삽입
                    q.add(new int[]{i, j});
                }
            }
        }
        //1인 노드 큐에 넣고, bfs 호출
        bfs();
        int maxResult = 0;
        //토마토가 다 안 익었을 떄 0이 남아있을 떄의 처리
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == 0) {
                    System.out.print("-1");
                    return;
                } else {

                    maxResult = Math.max(g[i][j], maxResult);
                }
            }
        }
        System.out.print(maxResult - 1);
    }

    private static int bfs() {

        while (!q.isEmpty()) {
            //큐에서 폴
            int[] now = q.poll();

            //4방 탐색
            for (int d = 0; d < 4; d++) {
                int nX = now[0] + dx[d];
                int nY = now[1] + dy[d];

                if (nX < 0 || nY < 0 || nX >= n || nY >= m) {
                    continue;
                }

                //이미 익었거나, -1 막혀있는 경우
                if (g[nX][nY] == 1 && g[nX][nY] == -1) {
                    continue;
                }
                //토마토가 아직 익지 않았거나, 방문하지 않은 경우 큐에 삽입
                if (g[nX][nY] == 0 && visit[nX][nY] == 0) {
                    visit[nX][nY] = 1;
                    //각 x좌표, y좌표 갱신
                    g[nX][nY] = g[now[0]][now[1]] + 1;
                    q.add(new int[]{nX, nY});
                }
            }
        }
        return -1;
    }

    //큐 메모리 할당
    //방문 배열 = 0미방문 1방문 . 1로 변경
    // 노드 방문 1로 변경
    //큐 시작노듯 삽입
    //큐가 빌 때까지 4방 탐색 시작
    //for loop 4방 탐색
    //if -1 이거나, 1이면 continue
    //4방 탐색 인접 노드 0이고, 방문 안 했으면 큐 삽입
    //0이 1로 변경됨 -. 0 개수 감소

    private static void print() {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 상하좌우 토만토만 영향
// 모든 정점을 탐색할 때 까지, 몇 개의 레벨을 거쳐야?(일수)
// 인접 노드 한 레벨 탐색할 떄마다 + 1일 최단거리
// 모든 레벨 탐색 했는데, 0 개수가 1이 상이다 = 갈 수 없었던 곳에 0이 있었다. = -1 출력

