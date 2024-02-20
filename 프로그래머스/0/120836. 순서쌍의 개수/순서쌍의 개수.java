import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start = 1;
        int count = 0;
        while(start <=n){
            answer = (n%start ==0) ? count++ : 1;
            start++;
        }
        answer = count;
        return answer;
  
    }
}