import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String s = sc.next();

            if (s.equals("0")) {
                return;
            }
            if (s.length() == 1) {
                System.out.println("yes");
                continue;
            }

            //배열 생성
            String[] strings = new String[s.length()];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = String.valueOf(s.charAt(i));
            }

            // 0 & strings.len-1
            // 1 & strings.len-2
            // start  < mid 일 때 까지
            for (int j = 0; j < strings.length / 2; j++) {
                // 같지 않다면 No 출력하고 종료하기
                if (!strings[j].equals(strings[strings.length - 1 - j])) {
                    System.out.println("no");
                    break;
                }
                if (j == strings.length / 2 - 1) {
                    System.out.println("yes");
                }

            }
        }
    }
}
