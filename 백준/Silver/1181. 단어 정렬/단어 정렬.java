
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                //단어 길이가 같은 경우
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2); //사전 순 정렬
                    //그 외
                } else {
                    return o1.length() - o2.length();
                }
            }
        });
        System.out.println(arr[0]);
        //중복 아닌 단어 출력
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }

    }
}
