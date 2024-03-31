

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, k;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n,k 총개수 선택수
        String[] nk = br.readLine().split(" ");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);
        //DP배열
        dp = new int[n + 1][n + 1];
        //d 배열 초기화
        // 이항계수 초기값 설정해줘야 함
        //dp[i][1]= i //i개에서 1개 선택하는 경우 i개
        //dp[i][0] = 1 //i개에서 1개도 선택하지 않는 경우 1개
        //dp[i][i] = 1 // i개에서 모두 선택하는 경우 1개

        //for (i-> N만큼 반복)
        for (int i = 0; i <= n; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        System.out.print(dp[n][k]);

        //for (i->N만큼 반복)
        //for (j->N만큼 반복)
        //dp[i][j] = dp[i-1][j] + d[i-1][j-1] //조합 점화식
    }
}
