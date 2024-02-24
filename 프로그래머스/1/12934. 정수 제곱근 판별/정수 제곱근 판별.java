class Solution {
    public long solution(long n) {
        
        
    for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (Math.pow(i,2)==n) {
                    return (long) Math.pow(i+1  ,2);                   
                }
            }
        }
        return -1;
    }
}