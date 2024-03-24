

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * @Point - 연결요소의 개수
 * 인접리스트, DFS 사용
 */
public class Main {

    static ArrayList<ArrayList<Integer>> g;
    static boolean visit[];
    static int n, m;
    static int count;
    static int subNode;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //정점 N, 간선 M 입력
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        //인접 리스트 할당
        g = new ArrayList<>();

        //노드 개수 만큼 각 arraylist 초기화

        for (int i = 0; i <= n; i++) {
            g.add(i, new ArrayList<>());
        }

        //무방향 그래프 간선 연결, 간선 개수 m만큼 반복
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            g.get(a).add(b);
            g.get(b).add(a);
        }
        //출력
//        print();
        //방문 배열 초기화
        visit = new boolean[n + 1];
        //카운트 초기화
        count = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < g.get(i).size(); j++) {
                int node = g.get(i).get(j);
                if (!visit[node]) {
                    dfs(g, node, visit);
                    count++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                subNode++;
            }
        }

        if (m == 0) {
            System.out.print(n);
        } else {
            System.out.print(count + subNode);
        }

    }

    //dfs
    private static void dfs(ArrayList<ArrayList<Integer>> g, int node, boolean[] visit) {
        visit[node] = true;
        for (int v : g.get(node)) {
            if (!visit[v]) {
                dfs(g, v, visit);
            }
        }
    }

    private static void print() {
        for (ArrayList<Integer> subList : g) {
            System.out.println(subList);
        }
    }
}
//정점 1개일 때
//간선 0개일 때 고려