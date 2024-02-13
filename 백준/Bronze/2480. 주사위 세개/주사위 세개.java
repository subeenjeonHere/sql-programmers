import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count += 1;
                }
            }
        }

        int answer = 0;
        if (count == 3) {
            answer = 10000 + arr[0] * 1000;
        } else if (count == 1) {
            int eyes = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] == arr[j])
                        eyes = arr[i];
                }
            }
            answer = 1000 + eyes * 100;
        } else {
            int max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            answer = max * 100;

        }
        System.out.println(answer);
    }
}