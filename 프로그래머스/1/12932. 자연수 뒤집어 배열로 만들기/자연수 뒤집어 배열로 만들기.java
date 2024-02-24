import java.util.*;
class Solution {
    public int[] solution(long n) {
        
        String strings = String.valueOf(n);
        
        int[] answer = new int[strings.length()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = strings.charAt(i) -'0';
        }

        // 배열 뒤집기, 콜렉션 말고 for문으로 뒤집기
        for(int i=0; i < answer.length / 2; i++){
            int temp;
            temp = answer[i];
            // 0 4, 1 3
        
            answer[i] = answer[answer.length-1-i];
            answer[answer.length-1-i] = temp;
        }
 
        return answer;
    }
}