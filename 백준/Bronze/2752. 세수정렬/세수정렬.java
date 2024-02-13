import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        int i = 0;
        while (stk.hasMoreTokens()) {
            arr[i] = Integer.parseInt(stk.nextToken());
            i++;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int ele : arr) {
            sb.append(ele + " ");
        }
        System.out.println(sb);
    }
}