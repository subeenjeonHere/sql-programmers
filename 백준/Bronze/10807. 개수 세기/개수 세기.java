import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력
        int n = Integer.parseInt(br.readLine());

        //토큰 입력
        int[] arr = new int[n];
        String[] strings;
        strings = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        // v 입력받기
        int v = Integer.parseInt(br.readLine());
        // 0부터 배열 순회하며 v와 같다면 cnt 증가
        int cnt = 0;
        int start = 0;
        while (start < arr.length) {
            if (arr[start] == v) cnt++;
            start++;
        }
        System.out.println(cnt);
        br.close();
    }
}