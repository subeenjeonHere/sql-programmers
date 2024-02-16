import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int[] cnt = new int[10];

        String str = String.valueOf(a * b * c);
        char[] charArray = str.toCharArray();

        // 0~9 ASCII= 48~57
        char asc = 48;
        int value;
        while (asc <= 57) {
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == asc) {
                    value = Integer.parseInt(String.valueOf(asc));
                    cnt[value]++;
                }
            }
            asc++;
        }

        for (int ele : cnt) {
            System.out.println(ele);
        }
    }
}
