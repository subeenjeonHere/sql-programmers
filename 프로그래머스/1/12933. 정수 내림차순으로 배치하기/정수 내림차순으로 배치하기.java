import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;

        String num = String.valueOf(n);
        int[] arr = new int[num.length()];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        Arrays.sort(arr);
        for(int i=0; i < arr.length/2; i++){
            int temp = 0;
            //arr.length 6 -1 , 0과 5 변경, 1과 4 변경
            temp = arr[i];
            arr[i]=arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
        for(int i=0; i<arr.length; i++){
            // sb.append(arr[i]);
            sb.append(arr[i]);
        }
        return Long.valueOf(sb.toString());

    }
}