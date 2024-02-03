import java.util.*;

/**
 * 백준 2667
 * 단지수저장할 개수 1차원 배열로
 */
public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int count;
    //    static int[] countlist;
    static ArrayList<Integer> countlist;
    static int n, c;

    //4방탐색 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 지도 크기 n 입력받기
        n = sc.nextInt();

        // 2. graph, visited 초기화
        graph = new int[n][n];
        visited = new boolean[n][n];
        countlist = new ArrayList<>();
        c = 0;

        //3. graph에 0,1 입력받기
        for (int i = 0; i < n; i++) {
            String num = sc.next();
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = num.charAt(j) - '0';
            }
        }
        int count = 0;

        //mpt. 첫째줄 총 단지수, 각 단지 내 집의 수 ASC
        //4. graph 순회하면서 DFS 실행
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {

                // i행,j열에 집이 있고(1), 방문하지 않았다면 dfs 호출
                if (graph[i][j] == 1 && !visited[i][j]) {
                    c = 0; //현재 단지 집 수 초기화
                    dfs(i, j);
                    countlist.add(c); //단지 집 수 리스트에 추가
                }
            }
        }
        //p. 총 단지수 출력, 집의 개수 ASC 출력
        System.out.println(countlist.size());
        Collections.sort(countlist);
        for (Integer ele : countlist) { //mpt. Integer
            System.out.println(ele);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        c++; //현재 단지 집 수 증가

        // i,j에서 연결된 노드가 있는지 4방탐색
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx >= 0 && my >= 0 && mx < n && my < n) {
                if (graph[mx][my] == 1 && !visited[mx][my]) {
                    dfs(mx, my);
                }
            }
        }

    }
}