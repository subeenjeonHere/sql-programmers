import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Subject DFS, BFS 기본 문제
 * @Point 탐색 결과 어떻게 출력
 * dfs 스택 무한루프, 다 탐색했을 때 어떻게 종료 -> 스택 Pop 해야했음
 * 방문배열 초기화
 */
public class Main {
    static int[][] arr;
    static boolean[] visit;

    static void dfs(int Node) {
        //방문 기록
        visit[Node] = true;
        // 방문한 노드 출력
        System.out.print(Node + " ");
        //스택 자료구조 할당
        Stack<Integer> stk = new Stack<>();
        stk.push(Node);
        //스택 빌 때까지 반복
        while (!stk.isEmpty()) {
            int nowNode = stk.pop();
            for (int i = 0; i < arr.length; i++) {
                if (visit[i]) {
                    continue;
                }
                if (arr[nowNode][i] == 1 && !visit[i]) {
                    dfs(i);
                }
            }
        }
        //dfs 재귀호출
    }

    static void bfs(int Node) {
        visit[Node] = true;
        //큐로 구현
        Queue<Integer> que = new LinkedList<>();

        //시작 노드 큐 삽입
        que.add(Node);

        //큐가 빌 때까지 현재 노드 poll 하고 방문
        while (!que.isEmpty()) {
            //일단 큐에서 시작노드 poll 하고, 시작노드와 인접한 노드 삽입

            int nowNode = que.poll();
            System.out.print(nowNode + " ");
            for (int i = 0; i < arr.length; i++) {
                //인접 행렬 1이고, 방문 안 했다면 큐 삽입
                if (arr[nowNode][i] == 1 && !visit[i]) {
                    que.add(i);
                    // 인접 노드 방문 체크
                    visit[i] = true;

                }
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //정점개수 n, 간선 개수 m, 시작 정점 번호 v 입력받기
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        int vtx = Integer.parseInt(info[2]);

        //인접행렬 할당
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        //간선 연결 하기 간선개수만큼 반복
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int from = Integer.parseInt(ab[0]);
            int to = Integer.parseInt(ab[1]);
            arr[from][to] = 1;
            arr[to][from] = 1;
        }
        //시작노드
        //dfs 수행
        dfs(vtx);
        visit = new boolean[n + 1];
        System.out.println();
        //bfs 수행
        bfs(vtx);

        //결과 출력하기
    }
}