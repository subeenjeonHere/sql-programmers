class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        //s chartAt으로 p, y 있는지 검사
        //p,y 없다면 true 리턴
        //p,y 대문자이거나 소문자이면 count
        //for문 내에서 charAt으로 비교하며 p == y ==일 경우 countp, county 증가
        //countp == county라면 true 리턴 다르면 false 리턴
        //대문자 소문자 관계없으니 toUpperCase
        String strings = s.toUpperCase();
        
        // System.out.println(strings);
        int countp = 0;
        int county = 0;
        
        for(int i = 0; i<strings.length(); i++){
            if(strings.charAt(i) == 'P'){
                countp ++;
            }
            
            if(strings.charAt(i)=='Y'){
                county ++;
            }
        }
        if(countp == county){
            answer = true;
        }else{
            answer = false;
        }
        
        return answer;
    }
}