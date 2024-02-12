import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        
        String str = my_string;
        String answer ="";
        String[] arr = new String[str.length()];
        
        for(int i=0; i < str.length(); i++){
            answer += String.valueOf(str.charAt(str.length()-i-1));
        }        
        return answer;
    }
}