import javax.imageio.IIOException;
import java.io.*;

/**
 * Counting Sort
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[100001];

        // ref. 수 입력받으면서 해당 idx 1씩 카운팅
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
//                sb.append(i).append('\n');
                sb.append(i + "\n");
                arr[i]--;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
