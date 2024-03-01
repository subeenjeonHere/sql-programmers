import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String score;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            score = br.readLine();
            System.out.println(scoreSum(score));
        }
    }

    private static int scoreSum(String score) {

        int sum = 0;
        int totalSum = 0;
        //X면 Sum 0으로 초기화, 누적 Sum을 총합 Sum에 치환

        for (int i = 0; i < score.length(); i++) {
            String s = String.valueOf(score.charAt(i));

            if (s.equals("O")) {
                sum++;
            } else if (s.equals("X") && sum > 0) {
                sum = 0;
            }
            totalSum += sum;
        }
        return totalSum;

    }
}