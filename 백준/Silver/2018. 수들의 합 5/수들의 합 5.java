import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int count = 1;
        int sum = 1;

        while (end != n) {
            if (sum == n) {
                count++;
                end++;
                sum = sum + end;
            } else if (sum > n) {
                sum = sum - start;
                start++;
            } else {
                end++;
                sum = sum + end;
            }
        }
        System.out.println(count);
    }
}
