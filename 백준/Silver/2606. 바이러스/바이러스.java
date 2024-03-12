//package baek_joon.class_3.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 */
public class Main {
    static int n;
    static int[][] graph;
    static boolean[] visit;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드 수
        n = Integer.parseInt(br.readLine());
        // 엣지 수
        int edge = Integer.parseInt(br.readLine());

        // 인접 행렬 할당 그래프
        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= edge; i++) {
            // 공백으로 나눠 입력
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            graph[from][to] = 1;
            graph[to][from] = 1;
//            System.out.println("그래프: " + graph[from][to]);
        }

        //방문 배열
        visit = new boolean[n + 1];

        //시작노드
        int start = 1;
        if (bfs(start) == 0) {
            System.out.print("0");
        } else {
            System.out.print(bfs(start));
        }
    }

    //BFS 큐 구현
    private static int bfs(int Node) {
        Queue<Integer> q = new LinkedList<>();
        //큐에 시작노드 삽입
        q.add(Node);
        //노드 방문 체크
        visit[Node] = true;

        while (!q.isEmpty()) {
            int nowNode = q.poll();
//            System.out.println("NowNode: " + nowNode);

            // 어디까지 반복
            for (int i = 0; i < graph.length; i++) {
//                System.out.println("I: " + i);

                //인접 행렬에서 노드와 연결되어있고
                if (graph[nowNode][i] == 1) {
                    //방문하지 않았다면
                    if (!visit[i]) {
//                        System.out.println("연결노드 " + i);
                        //방문 체크하고
                        visit[i] = true;
                        //큐에 삽입
                        q.add(i);
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        return count;
    }
}
