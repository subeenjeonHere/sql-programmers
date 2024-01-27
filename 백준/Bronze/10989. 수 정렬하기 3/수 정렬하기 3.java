import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;

/**
 * sec. Counting Sort로 풀기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[100001];

        // cnt 배열에 값 저장 동시에 cnt 카운팅
        // b/c 배열의 인덱스를 사용할 것이므로
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            cnt[num]++;
        }
        StringBuilder sb = new StringBuilder();
        // N.B.: cnt 순회하면서 cnt idx의 원소가 0이 될 때까지 출력
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i] > 0) {
                sb.append(i + "\n");
                cnt[i]--;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
