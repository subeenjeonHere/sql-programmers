

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;

/**
 * @Point - 3,2로 동시에 나눠질 때 처리
 * - n이 1일 때
 * 반례 642 정답 10인데 11나옴
 */
public class Main {
    static int n;
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.print("0");
            return;
        }
        dp = new int[n + 2];

        //2,3을 1로 만드는 횟수는 1이니 초기값 저장
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i < dp.length; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i / 2] + 1);
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.print(dp[n]);

    }
}
