import java.util.Scanner;

public class Main {

    //배열
    static int[] arr;
    // 최댓값 저장할 dp 배열
    static Integer[] dp;
    //최대값 변수
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받을 정수
        int n = sc.nextInt();

        // 값 입력받을 배열
        arr = new int[n];
        dp = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        dp[0] = arr[0];
        max = arr[0];

        recur(n - 1);

        System.out.println(max);
    }

    static int recur(int n) {

        if (dp[n] == null) {
            dp[n] = Math.max(recur(n - 1) + arr[n], arr[n]);
            max = Math.max(dp[n], max);
        }
        return dp[n];
    }
}