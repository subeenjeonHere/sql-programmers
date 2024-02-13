import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder(  );
        for(int i=0; i<my_string.length(); i++){
            
            int cnt = 0;
            
            while(cnt < n ){
                sb.append(my_string.charAt(i));
                cnt++;
            }
        }
        answer = sb.toString();
        return answer;
    }
}