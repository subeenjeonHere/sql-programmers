

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SimpleTimeZone;

public class Main {
    static int n;
    static int a, b;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            a = Integer.parseInt(br.readLine());
            b = Integer.parseInt(br.readLine());

            //배열 초기값
            dp = new int[a + 2][b + 1];

            for (int p = 0; p < dp[0].length; p++) {
                dp[0][p] = p + 1;
            }
            for (int q = 0; q < dp.length; q++) {
                dp[q][0] = 1;
            }

            for (int p = 1; p < dp.length; p++) {
                for (int q = 1; q < dp[0].length; q++) {

                    dp[p][q] = dp[p][q - 1] + dp[p - 1][q];
                }
            }
            sb.append(dp[a][b - 1]).append("\n");
        }
        System.out.print(sb.toString().trim());

    }
}