import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        String nums = String.valueOf(n);
        int[] answer = new int[nums.length()];
        
        for(int i = answer.length-1; i >=0 ; i--){
            answer[i] = nums.charAt(nums.length()-i-1)-'0';
        }
        
        return answer;
    }
}